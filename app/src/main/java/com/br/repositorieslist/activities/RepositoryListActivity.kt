package com.br.repositorieslist.activities

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.repositorieslist.R
import com.br.repositorieslist.adapter.RepositoryListAdapter
import com.br.repositorieslist.config.RetrofitInitializer
import com.br.repositorieslist.constants.RepositoryConstants
import com.br.repositorieslist.model.GitRepository
import com.br.repositorieslist.model.Item
import kotlinx.android.synthetic.main.activity_repository_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryListActivity : AppCompatActivity() {

    var page = 1
    var isLoading = false
    val limit = 30
    var limitMax = 30
    var itemsReturn: MutableList<Item> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var items: GitRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)
        items = GitRepository()
        callAPI()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putSerializable("items",items)
        Log.i("onSaveInstanceState","")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("onRestoreInstanceState","")

        items = savedInstanceState?.getSerializable("items") as GitRepository
        configureList(items)

        super.onRestoreInstanceState(savedInstanceState)
    }

    fun configureList(items: GitRepository){
        viewManager = LinearLayoutManager(this)
        viewAdapter = RepositoryListAdapter(items.items, this)
        recyclerView = findViewById<RecyclerView>(R.id.repository_list_recyclerview).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val lastChild = recyclerView.getChildAt(recyclerView.getChildCount() - 1)
        val bottomHolder = recyclerView.getChildViewHolder(lastChild) as RepositoryListAdapter.ViewHolder
        val pastVisibleItem : Int = bottomHolder.position

                if(pageAllowed(page,isLoading)) {
                    if (pastVisibleItem >= (limitMax - 1)) {
                        page++
                        limitMax = page * limit
                        pagination()
                    }
                }
        }
    })
    }

    fun pagination(){
        isLoading = true
        progressBar.visibility= View.VISIBLE

        callAPI()

        Handler().postDelayed({
            if(::viewAdapter.isInitialized){
                viewAdapter.notifyDataSetChanged()
            }
            else{
                viewAdapter = RepositoryListAdapter(items.items, this)
            }
            recyclerView.smoothScrollToPosition(if(page==1){page * limit} else{ (page - 1) * limit})
            isLoading = false
            progressBar.visibility = View.GONE
        },5000)
    }

    private fun callAPI(){
        val call = RetrofitInitializer(this).repositoryService().list(
            "language:kotlin","stars",page)
        call.enqueue(object : Callback<GitRepository?> {
            override fun onResponse(call: Call<GitRepository?>?,
                                    response: Response<GitRepository?>?) {
                response?.body()?.let {
                   if(itemsReturn.isEmpty()){
                       itemsReturn = it.items!!
                       items = it
                   } else{
                       itemsReturn.addAll(it.items!!)
                   }
                    configureList(items)
                }
            }

            override fun onFailure(call: Call<GitRepository?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun pageAllowed(page:Int,isLoading:Boolean):Boolean{
        return page <= RepositoryConstants.REPOSITORY.limit && (!isLoading)
    }
}

