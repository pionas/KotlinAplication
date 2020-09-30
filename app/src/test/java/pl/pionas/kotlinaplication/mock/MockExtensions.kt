package pl.pionas.kotlinaplication.mock

import org.jetbrains.annotations.TestOnly
import pl.pionas.kotlinaplication.core.api.model.*
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCached
import pl.pionas.kotlinaplication.features.articles.domain.model.Article
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached
import pl.pionas.kotlinaplication.features.users.domain.model.User
import java.util.*

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@TestOnly
fun ArticleRemote.Companion.mock() = ArticleRemote(
    id = 1,
    title = "article title",
    website = "article website",
    slug = "article-slug",
    urls = emptyList(),
    status = 1,
    createdAt = Date(),
    endDays = 5,
    startDays = 0
)

fun ArticleResponse.Companion.mock() = ArticleResponse(
    data = listOf(
        ArticleRemote.mock(),
        ArticleRemote.mock(),
        ArticleRemote.mock()
    )
)

fun ArticleCached.Companion.mock() = ArticleCached(
    id = 1,
    title = "article title",
    website = "article website",
    slug = "article-slug",
    urls = emptyList(),
    status = 1,
    createdAt = Date(),
    endDays = 5,
    startDays = 0
)

@TestOnly
fun Article.Companion.mock() = Article(
    id = 1,
    title = "article title",
    website = "article website",
    slug = "article-slug",
    urls = emptyList(),
    status = 1,
    createdAt = Date(),
    endDays = 5,
    startDays = 0
)

@TestOnly
fun ArticleDisplayable.Companion.mock() = ArticleDisplayable(
    id = 1,
    title = "article title",
    website = "article website",
    slug = "article-slug",
    urls = emptyList(),
    status = 1,
    createdAt = Date(),
    endDays = 5,
    startDays = 0
)

@TestOnly
fun UserRemote.Companion.mock() = UserRemote(
    id = 1,
    name = "user name",
    avatar = "user avatar",
    createdAt = Date(),
    lastActive = null
)

fun UserResponse.Companion.mock() = UserResponse(
    data = listOf(
        UserRemote.mock(),
        UserRemote.mock(),
        UserRemote.mock()
    )
)

fun UserCached.Companion.mock() = UserCached(
    id = 1,
    name = "user name",
    avatar = "user avatar",
    createdAt = Date(),
    lastActive = null
)

@TestOnly
fun User.Companion.mock() = User(
    id = 1,
    name = "user name",
    avatar = "user avatar",
    createdAt = Date(),
    lastActive = null,
    userFieldsValues = usersFieldsValues
)

@TestOnly
fun UserDisplayable.Companion.mock() = UserDisplayable(
    id = 1,
    name = "user name",
    avatar = "user avatar"
)