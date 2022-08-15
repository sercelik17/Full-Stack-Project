package yte.intern.data.project.asistan.controller.request;

import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.asistan.entity.Asistan;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAsistanRequest(
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
)

{
    public Asistan toDomainEntity() {
        return new Asistan(name, surname, username, password);
    }
}
