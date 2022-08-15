package yte.intern.data.project.admin.controller.responses;

import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.student.entity.Student;

public record AdminQueryModel(
        Long id,
        String username,
        String password

) {
    public AdminQueryModel(Admin admin) {
        this(
                admin.getId(),
                admin.getUsername(),
                admin.getPassword()

        );
    }


}
