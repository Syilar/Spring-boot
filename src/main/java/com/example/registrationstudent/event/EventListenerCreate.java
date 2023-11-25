package com.example.registrationstudent.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerCreate {

    @EventListener(StudentCreatedEvent.class)
    public void listen(StudentCreatedEvent studentCreatedEvent) {
        System.out.println("Добавлен студент: ");
        System.out.println(studentCreatedEvent.getStudent());
    }
}
