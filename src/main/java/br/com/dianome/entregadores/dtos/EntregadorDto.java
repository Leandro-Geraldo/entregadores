package br.com.dianome.entregadores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadorDto(@NotBlank String nome,
                           @NotNull String cpf,
                           @NotNull Integer carga) {

}
