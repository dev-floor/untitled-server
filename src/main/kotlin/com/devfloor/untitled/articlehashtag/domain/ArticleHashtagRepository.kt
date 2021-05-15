package com.devfloor.untitled.articlehashtag.domain

import com.devfloor.untitled.article.domain.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional

interface ArticleHashtagRepository : JpaRepository<ArticleHashtag, Long> {
    fun findAllByArticle(article: Article): List<ArticleHashtag>

    @Transactional
    @Modifying(clearAutomatically = true)
    fun deleteAllByArticle(article: Article)
}
