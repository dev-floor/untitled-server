package com.devfloor.hongit.core.bookmarkboard.domain

import com.devfloor.hongit.core.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface BookmarkBoardRepository : JpaRepository<BookmarkBoard, Long> {
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "DELETE FROM BookmarkBoard WHERE user = :user")
    fun deleteAllByUser(user: User)
}
