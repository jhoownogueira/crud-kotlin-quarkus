package puc.dto

import puc.enums.StatusTarefa
import java.time.LocalDate
import javax.validation.constraints.*

data class TarefaDTO(
    @field:NotBlank
    val titulo: String,

    val descricao: String? = null,

    @field:NotNull
    val dataInicio: LocalDate,

    @field:NotNull
    val prazoConclusao: LocalDate,

    @field:NotNull
    val status: StatusTarefa
)
