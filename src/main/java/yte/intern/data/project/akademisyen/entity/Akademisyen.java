package yte.intern.data.project.akademisyen.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.common.entity.BaseEntity;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.student.entity.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Akademisyen extends BaseEntity {

    private String name;
    private String surname;
    private String username;
    private String password;


    public Akademisyen(String name,
                   String surname,
                   String username,
                   String password
    ) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

    }

    public void update(Akademisyen updatedAkademisyen) {
        this.name = updatedAkademisyen.name;
        this.surname = updatedAkademisyen.surname;
        this.password = updatedAkademisyen.password;
    }


    @OneToMany(mappedBy = "akademisyen")
    private Set <Lesson> lessons= new HashSet<>();

    @OneToMany(mappedBy = "akademisyen",cascade=CascadeType.ALL)
    private  Set<Asistan> asistans =new HashSet<>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set <Student> students= new HashSet<>();


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
