package com.devfloor.untitled.hashtag.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.Modifying

@Transactional(readOnly = true)
interface HashtagRepository : JpaRepository<Hashtag, Long> {
    fun findByName(hashtag: String): Hashtag?

    fun findAllByNameIn(hashtags: List<String>): List<Hashtag>
}
