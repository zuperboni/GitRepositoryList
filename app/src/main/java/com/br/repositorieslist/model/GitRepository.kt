package com.br.repositorieslist.model

import com.br.repositorieslist.constants.RepositoryConstants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class GitRepository : Serializable{

    @SerializedName("total_count")
    @Expose
    var totalCount: Int = 0
    @SerializedName("incomplete_results")
    @Expose
    var incompleteResults: Boolean = false
    @SerializedName("items")
    @Expose
    var items: MutableList<Item>? = null

}