package puc.controller

import puc.dto.TarefaDTO
import puc.model.Tarefa
import puc.service.TarefaService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/tarefas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TarefaResource {
    @Inject
    lateinit var tarefaService: TarefaService

    @GET
    fun listarTarefas(): List<Tarefa> = tarefaService.listarTarefas()

    @POST
    fun createTarefa(tarefaDTO: TarefaDTO): Response {
        val tarefa = Tarefa(
            titulo = tarefaDTO.titulo,
            descricao = tarefaDTO.descricao,
            data_inicio = tarefaDTO.dataInicio,
            prazo_conclusao = tarefaDTO.prazoConclusao,
            status = tarefaDTO.status
        )
        tarefaService.criarTarefa(tarefa)
        return Response.status(Response.Status.CREATED).entity(tarefa).build()
    }

    // Implementar os demais endpoints (editar, excluir, etc.)
}
