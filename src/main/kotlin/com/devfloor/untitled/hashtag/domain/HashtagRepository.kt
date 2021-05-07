package com.devfloor.untitled.hashtag.domain

import org.springframework.data.jpa.repository.JpaRepository

interface HashtagRepository : JpaRepository<Hashtag, Long> {
    fun findByName(hashtag: String): Hashtag
    fun findAllByNameIn(hashtags: List<String>): List<Hashtag>
    fun existsByName(hashtag: String): Boolean
}
