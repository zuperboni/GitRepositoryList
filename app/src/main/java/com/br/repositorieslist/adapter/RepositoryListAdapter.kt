package com.br.repositorieslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.repositorieslist.R
import com.br.repositorieslist.model.Item
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryListAdapter(private val items: List<Item>?,
                            private val context: Context): RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder?.let {
            it.bindView(item)
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Item?) {
            val title = itemView.tv_nome_repo
            val tv_estrelas = itemView.tv_estrelas
            val tv_forks = itemView.tv_forks
            val tv_nome_autor = itemView.tv_nome_autor
            val iv_img_autor =  itemView.iv_img_autor
            val iv_estrelas = itemView.iv_estrelas
            val iv_forks = itemView.iv_forks

            title.text = item?.name
            tv_nome_autor.text = item?.owner?.login
            tv_estrelas.text = item?.stargazersCount.toString()
            tv_forks.text = item?.forksCount.toString()

            if(!item?.hasForks()!!){
                iv_forks.visibility=View.GONE
                tv_forks.visibility=View.GONE
            }
            if(!item?.hasStars()!!){
                iv_estrelas.visibility=View.GONE
                tv_estrelas.visibility = View.GONE
            }

            val requestOptions =  RequestOptions ()
                .fitCenter()
                .placeholder(R.drawable.circular_progress_bar)
                .diskCacheStrategy (DiskCacheStrategy.AUTOMATIC)
                .signature(ObjectKey(item.updatedAt))

            Glide.with(itemView)
                .load(item?.owner?.avatarUrl)
                .thumbnail(0.25f)
                .apply(requestOptions)
                .into(iv_img_autor)
        }
    }
}