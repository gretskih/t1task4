package ru.t1.task4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.t1.task4.domain.Student;

import java.util.List;

@Slf4j
@Service
public class StudentService {

    public Student findOneStudent(Integer number) {
        return new Student(number, "fac" + number, "fName", "lName", "mName");
    }

    public List<Student> findAllStudents() {
        return List.of(new Student(1, "fac1", "fName1", "lName1", "mName1"),
                new Student(2, "fac2", "fName2", "lName2", "mName2")
        );
    }

}
