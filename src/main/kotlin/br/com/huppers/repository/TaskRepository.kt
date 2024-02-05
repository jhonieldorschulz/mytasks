package br.com.huppers.repository

import br.com.huppers.database.dao.TaskDao
import br.com.huppers.models.Task

class TaskRepository(
    private val dao: TaskDao = TaskDao()
) {

    suspend fun tasks() = dao.findAll()

    suspend fun save(task: Task): Task? = dao.save(task)


}