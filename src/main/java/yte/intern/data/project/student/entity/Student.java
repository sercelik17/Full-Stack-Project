package yte.intern.data.project.student.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.data.project.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;


    public Student(String name,
                   String surname,
                   String email,
                   String username,
                   String password
                   ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;

    }

    public void update(Student updatedStudent) {
        this.name = updatedStudent.name;
        this.surname = updatedStudent.surname;
        this.email = updatedStudent.email;
        this.password = updatedStudent.password;
    }

}
