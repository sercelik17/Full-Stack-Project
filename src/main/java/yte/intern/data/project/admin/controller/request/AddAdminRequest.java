package yte.intern.data.project.admin.controller.request;

import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAdminRequest(
        @NotBlank
        String username,
        @NotBlank
        String password

) {

    public Admin toDomainEntity() {
        return new Admin(username, password);
    }
}
