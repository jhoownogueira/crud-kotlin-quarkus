package puc.repository


import io.quarkus.hibernate.orm.panache.PanacheRepository
import puc.model.Tarefa
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TarefaRepository : PanacheRepository<Tarefa>