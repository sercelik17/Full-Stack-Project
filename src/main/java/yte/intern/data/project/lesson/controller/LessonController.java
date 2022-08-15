package yte.intern.data.project.lesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.lesson.controller.request.AddLessonRequest;
import yte.intern.data.project.lesson.controller.request.UpdateLessonRequest;
import yte.intern.data.project.lesson.controller.responses.LessonQueryModel;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.lesson.controller.request.AddLessonRequest;
import yte.intern.data.project.lesson.controller.request.UpdateLessonRequest;
import yte.intern.data.project.lesson.controller.responses.LessonQueryModel;
import yte.intern.data.project.lesson.service.LessonService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
@Validated
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody AddLessonRequest addStudentRequest) {
        return lessonService.addLesson(addStudentRequest.toDomainEntity());
    }

    @GetMapping
    public List<LessonQueryModel> getAllStudents() {
        return lessonService.getAllLessons()
                .stream()
                .map(lesson -> new LessonQueryModel(lesson))
                .toList();
    }

    @GetMapping("/{id}")
    public LessonQueryModel getById(@NotNull @PathVariable Long id) {
        return new LessonQueryModel(lessonService.getById(id));
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteLessonById(@PathVariable @NotNull Long id) {
        return lessonService.deleteLessonById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateLesson(@Valid @RequestBody UpdateLessonRequest request, @PathVariable Long id) {
        return lessonService.updatedLesson(id, request.toDomainEntity());
    }
}
