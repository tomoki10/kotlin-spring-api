package com.example.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.api.model.Todo

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
    fun findByTitle(title: String): List<Todo>
}