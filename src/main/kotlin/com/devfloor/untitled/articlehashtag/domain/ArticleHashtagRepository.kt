package com.devfloor.untitled.articlehashtag.domain

import com.devfloor.untitled.article.domain.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

/**
 * 게시글과 해시태그의 연관관계를 관리하는 repository
 */
@Transactional(readOnly = true)
interface ArticleHashtagRepository : JpaRepository<ArticleHashtag, Long> {
    fun findAllByArticle(article: Article): List<ArticleHashtag>

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "DELETE FROM ArticleHashtag WHERE article = :article")
    fun deleteAllByArticle(article: Article)
}
