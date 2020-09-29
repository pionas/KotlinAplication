package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ForumTopicViewRemote(
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("forum_topic")
    val forumTopic: ForumTopicRemote,
    @SerializedName("user")
    val user: UserRemote
)