package com.desafiobackendjr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoDTO(@NotBlank String name, @NotBlank String description, @NotNull boolean realized, @NotNull int priority) {
}
