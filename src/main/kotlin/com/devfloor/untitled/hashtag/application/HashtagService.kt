package com.devfloor.untitled.hashtag.application

import com.devfloor.untitled.hashtag.domain.Hashtag
import com.devfloor.untitled.hashtag.domain.HashtagRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HashtagService(
    private val repository: HashtagRepository,
) {
    @Transactional
    fun createByName(hashtagName: String): Hashtag = repository.findByName(hashtagName)
        ?: repository.save(Hashtag(hashtagName))
}
