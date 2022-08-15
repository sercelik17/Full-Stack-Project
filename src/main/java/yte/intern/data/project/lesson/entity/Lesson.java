package yte.intern.data.project.lesson.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.common.entity.BaseEntity;
import yte.intern.data.project.student.entity.Student;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends BaseEntity {

    private String name;
    LocalTime zaman;



    public Lesson(String name,
                   LocalTime zaman,
                  Long akademisyenId) {
        this.name = name;
        this.zaman = zaman;

        this.akademisyen = new Akademisyen();
        this.akademisyen.setId(akademisyenId);


    }

    public void update(Lesson updatedLesson) {
        this.name = updatedLesson.name;
        this.zaman = updatedLesson.zaman;

        this.akademisyen = updatedLesson.akademisyen;

    }

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set <Student> students= new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="akademisyen_id",referencedColumnName = "ID")
    private Akademisyen akademisyen;



}
