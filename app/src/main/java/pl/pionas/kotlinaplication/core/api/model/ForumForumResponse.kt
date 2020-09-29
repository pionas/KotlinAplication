package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ForumForumResponse(
    @SerializedName("forum")
    val forumForumRemote: ForumForumRemote,
    @SerializedName("forumTopics")
    val forumTopicListRemote: ForumTopicListRemote,
    @SerializedName("canTopicCreate")
    val canTopicCreate: Boolean
)