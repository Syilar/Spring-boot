package com.example.registrationstudent.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerRemove {

    @EventListener(StudentRemovedEvent.class)
    public void listen(StudentRemovedEvent studentRemovedEvent) {
        System.out.println("Студент с id - " + studentRemovedEvent.getStudent().getId() + " успешно удален!");
    }
}
