package com.devfloor.untitled.article.application.response

import com.devfloor.untitled.article.domain.Article
import com.devfloor.untitled.articlefavorite.domain.ArticleFavorite
import com.devfloor.untitled.articlefavorite.domain.ArticleFavoriteType
import com.devfloor.untitled.common.utils.LOCAL_DATE_TIME_FORMAT
import com.devfloor.untitled.common.utils.SEOUL_TIME_ZONE
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ArticleHomeResponse(
    val id: Long,

    val title: String? = null,

    val favoriteCount: Long,

    val wonderCount: Long,

    val clipCount: Long,

    @JsonFormat(
        pattern = LOCAL_DATE_TIME_FORMAT,
        shape = JsonFormat.Shape.STRING,
        locale = SEOUL_TIME_ZONE
    )
    val createdAt: LocalDateTime,

    @JsonFormat(
        pattern = LOCAL_DATE_TIME_FORMAT,
        shape = JsonFormat.Shape.STRING,
        locale = SEOUL_TIME_ZONE
    )
    val modifiedAt: LocalDateTime,
) {
    constructor(
        article: Article,
        articleFavorites: List<ArticleFavorite>,
    ) : this(
        id = article.id,
        title = article.title,
        favoriteCount = articleFavorites.count { it.matchType(ArticleFavoriteType.FAVORITE) }.toLong(),
        wonderCount = articleFavorites.count { it.matchType(ArticleFavoriteType.WONDER) }.toLong(),
        clipCount = articleFavorites.count { it.matchType(ArticleFavoriteType.CLIP) }.toLong(),
        createdAt = article.createdAt,
        modifiedAt = article.modifiedAt,
    )
}
