package puc.model

import puc.enums.StatusTarefa
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.*

@Entity
data class Tarefa (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    val titulo: String,

    val descricao: String? = null,

    @field:NotNull
    val data_inicio: LocalDate,

    @field:NotNull
    val prazo_conclusao: LocalDate,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    val status: StatusTarefa
) {
    constructor() : this(null, "", null, LocalDate.now(), LocalDate.now(), StatusTarefa.PENDENTE)
}