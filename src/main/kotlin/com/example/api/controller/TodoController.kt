package com.example.api.controller

import com.example.api.model.Todo
import com.example.api.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        val todos = todoService.findAll()
        return ResponseEntity.ok(todos)
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<Todo> {
        val todo = todoService.findById(id)
        return if (todo.isPresent) {
            ResponseEntity.ok(todo.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        val createdTodo = todoService.save(todo)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo)
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todo: Todo): ResponseEntity<Todo> {
        val updatedTodo = todoService.update(id, todo)
        return if (updatedTodo.isPresent) {
            ResponseEntity.ok(updatedTodo.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Void> {
        return if (todoService.delete(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}