package com.br.repositorieslist.config

import android.content.Context
import com.br.repositorieslist.repository.RepositoryService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer(context: Context) {

    var cacheSize = 10 * 1024 * 1024
    var cache = Cache(context.cacheDir, cacheSize.toLong())

    var okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun repositoryService() = retrofit.create(RepositoryService::class.java)

}