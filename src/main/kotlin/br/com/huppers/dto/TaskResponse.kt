package br.com.huppers.dto

import br.com.huppers.models.Task
import kotlinx.serialization.Serializable

@Serializable
class TaskResponse(val id: String,
    val title: String,
    val description: String,
    val isDone: Boolean)

fun Task.toTaskResponse() = TaskResponse(
    id = id.toString(),
    title = title,
    description = description,
    isDone = isDone
)