package puc.service

import puc.model.Tarefa
import puc.repository.TarefaRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class TarefaService {
    @Inject
    private lateinit var tarefaRepository: TarefaRepository

    fun listarTarefas(): List<Tarefa> {
        val tarefas = tarefaRepository.listAll()
        println("Tarefas recuperadas: $tarefas") // Adicione este log
        return tarefas
    }


    @Transactional
    fun criarTarefa(tarefa: Tarefa): Tarefa {
        tarefaRepository.persist(tarefa)
        return tarefa
    }

    // Implementar os demais métodos (editar, excluir, etc.)
}
