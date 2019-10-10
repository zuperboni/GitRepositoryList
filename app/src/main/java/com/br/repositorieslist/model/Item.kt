package com.br.repositorieslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Item : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("private")
    @Expose
    var _private: Boolean = false
    @SerializedName("owner")
    @Expose
    var owner: Owner? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("fork")
    @Expose
    var fork: Boolean = false
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("forks_url")
    @Expose
    var forksUrl: String? = null
    @SerializedName("keys_url")
    @Expose
    var keysUrl: String? = null
    @SerializedName("collaborators_url")
    @Expose
    var collaboratorsUrl: String? = null
    @SerializedName("teams_url")
    @Expose
    var teamsUrl: String? = null
    @SerializedName("hooks_url")
    @Expose
    var hooksUrl: String? = null
    @SerializedName("issue_events_url")
    @Expose
    var issueEventsUrl: String? = null
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @SerializedName("assignees_url")
    @Expose
    var assigneesUrl: String? = null
    @SerializedName("branches_url")
    @Expose
    var branchesUrl: String? = null
    @SerializedName("tags_url")
    @Expose
    var tagsUrl: String? = null
    @SerializedName("blobs_url")
    @Expose
    var blobsUrl: String? = null
    @SerializedName("git_tags_url")
    @Expose
    var gitTagsUrl: String? = null
    @SerializedName("git_refs_url")
    @Expose
    var gitRefsUrl: String? = null
    @SerializedName("trees_url")
    @Expose
    var treesUrl: String? = null
    @SerializedName("statuses_url")
    @Expose
    var statusesUrl: String? = null
    @SerializedName("languages_url")
    @Expose
    var languagesUrl: String? = null
    @SerializedName("stargazers_url")
    @Expose
    var stargazersUrl: String? = null
    @SerializedName("contributors_url")
    @Expose
    var contributorsUrl: String? = null
    @SerializedName("subscribers_url")
    @Expose
    var subscribersUrl: String? = null
    @SerializedName("subscription_url")
    @Expose
    var subscriptionUrl: String? = null
    @SerializedName("commits_url")
    @Expose
    var commitsUrl: String? = null
    @SerializedName("git_commits_url")
    @Expose
    var gitCommitsUrl: String? = null
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null
    @SerializedName("issue_comment_url")
    @Expose
    var issueCommentUrl: String? = null
    @SerializedName("contents_url")
    @Expose
    var contentsUrl: String? = null
    @SerializedName("compare_url")
    @Expose
    var compareUrl: String? = null
    @SerializedName("merges_url")
    @Expose
    var mergesUrl: String? = null
    @SerializedName("archive_url")
    @Expose
    var archiveUrl: String? = null
    @SerializedName("downloads_url")
    @Expose
    var downloadsUrl: String? = null
    @SerializedName("issues_url")
    @Expose
    var issuesUrl: String? = null
    @SerializedName("pulls_url")
    @Expose
    var pullsUrl: String? = null
    @SerializedName("milestones_url")
    @Expose
    var milestonesUrl: String? = null
    @SerializedName("notifications_url")
    @Expose
    var notificationsUrl: String? = null
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null
    @SerializedName("releases_url")
    @Expose
    var releasesUrl: String? = null
    @SerializedName("deployments_url")
    @Expose
    var deploymentsUrl: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("pushed_at")
    @Expose
    var pushedAt: String? = null
    @SerializedName("git_url")
    @Expose
    var gitUrl: String? = null
    @SerializedName("ssh_url")
    @Expose
    var sshUrl: String? = null
    @SerializedName("clone_url")
    @Expose
    var cloneUrl: String? = null
    @SerializedName("svn_url")
    @Expose
    var svnUrl: String? = null
    @SerializedName("homepage")
    @Expose
    var homepage: String? = null
    @SerializedName("size")
    @Expose
    var size: Int = 0
    @SerializedName("stargazers_count")
    @Expose
    var stargazersCount: Int = 0
    @SerializedName("watchers_count")
    @Expose
    var watchersCount: Int = 0
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("has_issues")
    @Expose
    var hasIssues: Boolean = false
    @SerializedName("has_projects")
    @Expose
    var hasProjects: Boolean = false
    @SerializedName("has_downloads")
    @Expose
    var hasDownloads: Boolean = false
    @SerializedName("has_wiki")
    @Expose
    var hasWiki: Boolean = false
    @SerializedName("has_pages")
    @Expose
    var hasPages: Boolean = false
    @SerializedName("forks_count")
    @Expose
    var forksCount: Int = 0
    @SerializedName("mirror_url")
    @Expose
    var mirrorUrl: Any? = null
    @SerializedName("archived")
    @Expose
    var archived: Boolean = false
    @SerializedName("disabled")
    @Expose
    var disabled: Boolean = false
    @SerializedName("open_issues_count")
    @Expose
    var openIssuesCount: Int = 0
    @SerializedName("license")
    @Expose
    var license: License? = null
    @SerializedName("forks")
    @Expose
    var forks: Int = 0
    @SerializedName("open_issues")
    @Expose
    var openIssues: Int = 0
    @SerializedName("watchers")
    @Expose
    var watchers: Int = 0
    @SerializedName("default_branch")
    @Expose
    var defaultBranch: String? = null
    @SerializedName("score")
    @Expose
    var score: Double = 0.toDouble()

    constructor()

    fun hasForks() : Boolean{ return this.forksCount > 0 }
    fun hasStars() : Boolean{ return this.stargazersCount > 0 }
}