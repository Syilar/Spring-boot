package com.example.registrationstudent.initializationStudents;

import com.example.registrationstudent.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@ConditionalOnProperty(name = "app.registration-student-service.enabled", havingValue = "true")
public class InitializationStudents implements InitializationStudentsInterface {
    @Override
    public List<Student> init() {
        System.out.println("Генерация студентов прошла успешно!\nВведите команду list," +
                "чтобы проверить список студентов.");
        List<Student> listStudents = new ArrayList<>();
        String[] firstNames = {"Иван", "Алексей", "Михаил", "Олег", "Григорий", "Дмитрий", "Антон", "Матвей", "Никита"};
        String[] lastNames = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов", "Соколов", "Максимов", "Захаров"};
        Random random = new Random();
        int count = 0;
        while (count < 10) {
            UUID id = UUID.randomUUID();
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = 18 + random.nextInt(13);
            Student student = new Student(id, firstName, lastName, age);
            listStudents.add(student);
            count++;
        }
        return listStudents;
    }

//    @Bean
//    @EventListener(ApplicationReadyEvent.class)
//    public void generationStudents() {
//        String[] firstNames = {"Иван", "Алексей", "Михаил", "Олег", "Григорий", "Дмитрий", "Антон", "Матвей", "Никита"};
//        String[] lastNames = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов", "Соколов", "Максимов", "Захаров"};
//        Random random = new Random();
//        int count = 0;
//        while (count < 10) {
//            String firstName = firstNames[random.nextInt(firstNames.length)];
//            String lastName = lastNames[random.nextInt(lastNames.length)];
//            int age = 18 + random.nextInt(13);
//            registrationStudentsService.addStudent(firstName, lastName, age);
//            count++;
//        }
//    }
}
