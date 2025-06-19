package com.example.api.model

import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    
    @Column(nullable = false)
    var title: String = "",
    
    @Column(nullable = false)
    var completed: Boolean = false
)