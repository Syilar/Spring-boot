package com.example.registrationstudent.event;

import com.example.registrationstudent.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentCreatedEvent extends ApplicationEvent {
    private Student student;
    public StudentCreatedEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
