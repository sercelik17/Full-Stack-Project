package yte.intern.data.project.akademisyen.controller.request;

import yte.intern.data.project.akademisyen.entity.Akademisyen;

public record UpdateAkademisyenRequest(
        String name,
        String surname,
        String username,
        String password
) {
    public Akademisyen toDomainEntity() {
        return new Akademisyen(name, surname, username, password);
    }

}
