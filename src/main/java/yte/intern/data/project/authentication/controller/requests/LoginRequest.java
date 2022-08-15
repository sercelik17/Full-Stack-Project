package yte.intern.data.project.authentication.controller.requests;

import javax.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
