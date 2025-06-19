package com.example.api.service

import com.example.api.model.Todo
import com.example.api.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun findAll(): List<Todo> {
        return todoRepository.findAll()
    }

    fun findById(id: Long): Optional<Todo> {
        return todoRepository.findById(id)
    }

    fun save(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    fun update(id: Long, todoUpdate: Todo): Optional<Todo> {
        return if (todoRepository.existsById(id)) {
            val todo = todoUpdate.copy(id = id)
            Optional.of(todoRepository.save(todo))
        } else {
            Optional.empty()
        }
    }

    fun delete(id: Long): Boolean {
        return if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}