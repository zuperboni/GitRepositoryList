package com.br.repositorieslist.repository


import com.br.repositorieslist.model.GitRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryService {
    @GET("https://api.github.com/search/repositories")
    fun list(@Query("q") q : String,@Query("sort") sort : String,
             @Query("page") page : Int) : Call<GitRepository>
}
