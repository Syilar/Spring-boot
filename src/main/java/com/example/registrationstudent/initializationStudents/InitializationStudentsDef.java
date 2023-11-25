package com.example.registrationstudent.initializationStudents;

import com.example.registrationstudent.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.registration-student-service.enabled", havingValue = "false")
public class InitializationStudentsDef implements InitializationStudentsInterface {
    @Override
    public List<Student> init() {
        System.out.println("Список студентов пуст!");
        return new ArrayList<>();
    }
}
