package ru.t1.task4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.t1.task4.domain.Student;
import ru.t1.task4.exception.ControllerException;
import ru.t1.task4.service.StudentService;

import java.util.List;

@Tag(
        name="Контроллер студентов",
        description="Предоставление информации о студентах курса"
)
@SecurityRequirement(name = "JWT")
@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Студент с номером",
            description = "Информация о студенте с номером"
    )
    @SecurityRequirement(name = "JWT")
    @GetMapping("/{number}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Student> student(@PathVariable Integer number) throws ControllerException {
        Student student;
        student = studentService.findOneStudent(number);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(student);
    }

    @Operation(
            summary = "Все студенты",
            description = "Информация о всех студентах курса"
    )
    @SecurityRequirement(name = "JWT")
    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<List<Student>> students() throws ControllerException {
        List<Student> students;
        students = studentService.findAllStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(students);
    }

}
