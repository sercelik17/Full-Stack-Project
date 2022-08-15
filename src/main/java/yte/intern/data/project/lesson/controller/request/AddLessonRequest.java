package yte.intern.data.project.lesson.controller.request;

import yte.intern.data.project.lesson.entity.Lesson;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalTime;

public record AddLessonRequest(
        @NotBlank
        @Size(max = 25)
        String name,



        LocalTime zaman,

        Long akademisyenId



) {
    public Lesson toDomainEntity() {

        return new Lesson(name, zaman,akademisyenId);
    }
}
