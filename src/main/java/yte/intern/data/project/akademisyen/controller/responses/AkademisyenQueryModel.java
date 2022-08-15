package yte.intern.data.project.akademisyen.controller.responses;

import yte.intern.data.project.akademisyen.entity.Akademisyen;

public record AkademisyenQueryModel(
        Long id,
        String name,
        String surname,
        String username,
        String password

) {
    public AkademisyenQueryModel(Akademisyen akademisyen) {
        this(
                akademisyen.getId(),
                akademisyen.getName(),
                akademisyen.getSurname(),
                akademisyen.getUsername(),
                akademisyen.getPassword()
        );
    }
}
