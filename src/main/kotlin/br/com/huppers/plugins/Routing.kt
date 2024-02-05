package br.com.huppers.plugins

import br.com.huppers.dto.TaskRequest
import br.com.huppers.dto.toTaskResponse
import br.com.huppers.models.Task
import br.com.huppers.repository.TaskRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val repository = TaskRepository()

    routing {

        get("/tasks") {

            val response = repository.tasks().map {
                it.toTaskResponse()
            }

            call.respond(response)
        }

        post("/tasks") {
            val request = call.receive<TaskRequest>()
            repository.save(request.toTask())?.let {
                call.respondText("Task was created", status = HttpStatusCode.Created)
            } ?: call.respondText("Unexpected error", status = HttpStatusCode.BadRequest)

        }
    }
}
