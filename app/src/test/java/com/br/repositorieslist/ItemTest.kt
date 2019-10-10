package com.br.repositorieslist

import com.br.repositorieslist.model.Item
import org.junit.Assert
import org.junit.Test

class ItemTest {
    @Test
    fun repositorioPossuiEstrelas(){
        var item = Item()
        item.stargazersCount=10
        Assert.assertTrue(item.hasStars())
    }

    @Test
    fun repositorioNaoPossuiEstrelas(){
        var item = Item()
        item.stargazersCount=0
        Assert.assertFalse(item.hasStars())
    }
    @Test
    fun repositorioPossuiForks(){
        var item = Item()
        item.forksCount=10
        Assert.assertTrue(item.hasForks())
    }

    @Test
    fun repositorioNaoPossuiForks(){
        var item = Item()
        item.forksCount=0
        Assert.assertFalse(item.hasForks())
    }
}