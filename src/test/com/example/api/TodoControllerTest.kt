import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(TodoController::class)
class TodoControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @Test
    fun `GET /todos should return list of todos`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `POST /todos should create a new todo`() {
        val todoJson = """{"title": "New Todo", "completed": false}"""
        
        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoJson))
            .andExpect(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    fun `GET /todos/{id} should return a todo by id`() {
        val todoId = 1
        
        mockMvc.perform(MockMvcRequestBuilders.get("/todos/$todoId"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    fun `PUT /todos/{id} should update a todo`() {
        val todoId = 1
        val updatedTodoJson = """{"title": "Updated Todo", "completed": true}"""
        
        mockMvc.perform(MockMvcRequestBuilders.put("/todos/$todoId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedTodoJson))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `DELETE /todos/{id} should delete a todo`() {
        val todoId = 1
        
        mockMvc.perform(MockMvcRequestBuilders.delete("/todos/$todoId"))
            .andExpect(MockMvcResultMatchers.status().isNoContent)
    }
}