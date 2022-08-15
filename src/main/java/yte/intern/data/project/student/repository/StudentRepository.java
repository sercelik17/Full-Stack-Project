package yte.intern.data.project.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.data.project.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
