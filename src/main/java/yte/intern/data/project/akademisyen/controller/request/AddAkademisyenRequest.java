package yte.intern.data.project.akademisyen.controller.request;

import yte.intern.data.project.akademisyen.entity.Akademisyen;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAkademisyenRequest(
        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,
        @NotBlank
        String username,
        @NotBlank
        String password

) {
    public Akademisyen toDomainEntity() {
        return new Akademisyen(name, surname, username, password);
    }
}
