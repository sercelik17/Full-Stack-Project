package yte.intern.data.project.student.controller.request;

import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.entity.Student;

public record UpdateStudentRequest(
        String name,
        String surname,
        String email,

        String username,
        String password
) {
    public Student toDomainEntity() {
        return new Student(name, surname, username, email, password);
    }
}
