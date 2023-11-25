package com.example.registrationstudent;

import com.example.registrationstudent.event.StudentCreatedEvent;
import com.example.registrationstudent.event.StudentRemovedEvent;
import com.example.registrationstudent.initializationStudents.InitializationStudentsInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RegistrationStudentsService {

    private final InitializationStudentsInterface studentsInitializator;
    private List<Student> listStudents = new ArrayList<>();
    private final ApplicationEventPublisher publisher;

    public void getListStudents() {
        System.out.println("Список судентов:");
        System.out.println(listStudents.toString());
    }

    public void addStudent(String firstName, String lastName, int age) {
        UUID id = UUID.randomUUID();
        Student student = new Student(id, firstName, lastName, age);
        listStudents.add(student);
        publisher.publishEvent(new StudentCreatedEvent(this, student));
    }

    public void removeStudent(UUID id) {
        boolean flag = false;
        for (Student student : listStudents) {
            if (student.getId().equals(id)) {
                listStudents.remove(student);
                publisher.publishEvent(new StudentRemovedEvent(this, student));
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Студент не найден!");
        }
    }

    public void listClear() {
        listStudents = new ArrayList<>();
        System.out.println("Список студентов полностью очищен!");
    }

    @EventListener(ApplicationStartedEvent.class)
    public void startInitialization() {
        listStudents = studentsInitializator.init();
    }
}
