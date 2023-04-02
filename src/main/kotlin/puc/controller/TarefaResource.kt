package puc.controller

import puc.dto.TarefaDTO
import puc.model.Tarefa
import puc.service.TarefaService
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/tarefas")
@Produces(MediaType.APPLICATION_JSON)
class TarefaResource {
    @Inject
    lateinit var tarefaService: TarefaService

    @GET
    fun listarTarefas(): List<Tarefa> = tarefaService.listarTarefas()

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    fun createTarefa(@Valid tarefaDTO: TarefaDTO): Response {
        println("Olá, ${tarefaDTO.titulo}! Bem-vindo ao meu programa.")
        val tarefa = Tarefa(
            titulo = tarefaDTO.titulo,
            descricao = tarefaDTO.descricao ?: "",
            data_inicio = tarefaDTO.data_inicio,
            prazo_conclusao = tarefaDTO.prazo_conclusao,
            status = tarefaDTO.status
        )


        tarefaService.criarTarefa(tarefa)
        return Response.status(Response.Status.CREATED).entity(tarefa).build()
    }

    // Implementar os demais endpoints (editar, excluir, etc.)
}
