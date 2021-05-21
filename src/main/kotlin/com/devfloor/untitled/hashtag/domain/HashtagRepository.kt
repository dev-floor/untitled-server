package com.devfloor.untitled.hashtag.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
interface HashtagRepository : JpaRepository<Hashtag, Long> {
    fun findByName(hashtag: String): Hashtag?
}
