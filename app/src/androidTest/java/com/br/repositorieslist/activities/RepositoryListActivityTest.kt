package com.br.repositorieslist.activities
import androidx.test.core.app.ActivityScenario
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


class RepositoryListActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<RepositoryListActivity> = ActivityTestRule(
        RepositoryListActivity::class.java,
        true,
        true
    )

    @Test
    fun activityInicialExibidaSucesso() {
        ActivityScenario.launch(RepositoryListActivity::class.java)
    }
    @Test
    fun verificaSePaginacaoPermitida() {
        Assert.assertTrue(activityRule.activity.pageAllowed(10,false))
    }
    @Test
    fun verificaSePaginacaoNaoPermitida() {
        Assert.assertFalse(activityRule.activity.pageAllowed(35,false))
    }
}