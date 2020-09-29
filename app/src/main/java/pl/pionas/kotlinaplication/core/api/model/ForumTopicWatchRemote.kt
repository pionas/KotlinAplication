package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ForumTopicWatchRemote(
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("watch")
    val watch: Int,
    @SerializedName("forum_topic")
    val forumTopic: ForumTopicRemote,
    @SerializedName("user")
    val user: UserRemote
)