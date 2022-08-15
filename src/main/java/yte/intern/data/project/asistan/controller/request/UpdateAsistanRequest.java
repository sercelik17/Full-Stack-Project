package yte.intern.data.project.asistan.controller.request;

import yte.intern.data.project.asistan.entity.Asistan;

public record UpdateAsistanRequest(
        String name,
        String surname,
        String username,
        String password
) {
    public Asistan toDomainEntity() {
        return new Asistan(name, surname, username, password);
    }

}
