package com.example.registrationstudent;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
public class RegistrationStudents {

    private final RegistrationStudentsService registrationStudentsService;

    @ShellMethod(key = "list")
    public void getListStudents() {
        registrationStudentsService.getListStudents();
    }

    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "f") String firstName,
                           @ShellOption(value = "l") String lastName,
                           @ShellOption(value = "a") int age) {
        registrationStudentsService.addStudent(firstName, lastName, age);

    }

    @ShellMethod(key = "remove")
    public void removeStudent(@ShellOption(value = "i") UUID id) {
        registrationStudentsService.removeStudent(id);
    }

    @ShellMethod(key = "cl")
    public void listClear() {
        registrationStudentsService.listClear();
    }
}
