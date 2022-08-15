package yte.intern.data.project.asistan.controller.responses;

import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.student.entity.Student;

public record AsistanQueryModel(
        Long id,
        String name,
        String surname,
        String username,
        String password

) {
    public AsistanQueryModel(yte.intern.data.project.asistan.entity.Asistan asistan) {
        this(
                asistan.getId(),
                asistan.getName(),
                asistan.getSurname(),
                asistan.getUsername(),
                asistan.getPassword()
        );
    }
}
