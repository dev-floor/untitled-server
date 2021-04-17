package com.devfloor.untitled.articlehashtag.domain

import com.devfloor.untitled.article.domain.Article
import com.devfloor.untitled.hashtag.domain.Hashtag
import javax.persistence.*

@Entity
@Table(name = "article_hashtag")
class ArticleHashtag(
    article: Article,
    hashtag: Hashtag,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_hashtag_id")
    var id: Long? = null
        protected set

    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article = article

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    val hashtag: Hashtag = hashtag
}
