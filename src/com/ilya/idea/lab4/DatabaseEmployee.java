package com.ilya.idea.lab4;

import java.util.Random;

public class DatabaseEmployee {
    private static String getRandomName(Gender gender){
        if (gender == Gender.MALE){
            String[] firstMenNames = {"Ilia", "Ivan", "Denis", "Filipp", "Daniil", "Andrew"};
            return firstMenNames[new Random().nextInt(6)];
        }
        else{
            String[] firstWomenNames = {"Anna", "Olga", "Kate", "Darya", "Alina", "Mariya"};
            return firstWomenNames[new Random().nextInt(6)];

        }
    }

    private static String getRandomSurname(Gender gender){
        if (gender == Gender.MALE){
            String[] menSurnames = {"Ivanov", "Petrov", "Sidorov", "Panin", "Maksimov", "Lubimov"};
            return menSurnames[new Random().nextInt(6)];
        }
        else{
            String[] womenSurnames = {"Ivanova", "Petrova", "Sidorova", "Panina", "Maksimova", "Lubimova"};
            return womenSurnames[new Random().nextInt(6)];
        }
    }

    private static int getRandomAge() {
        return 20 + new Random().nextInt(31);
    }

    private static Role getRandomRole(){
        int choice = new Random().nextInt(3);
        switch (choice){
            case 0:
                return Role.STAFF;
            case 1:
                return Role.MANAGER;
            case 2:
                return Role.EXECUTIVE;
        }
        return Role.STAFF;
    }

    private static double getSalary(int min, int max){
        max -= min;
        return Math.random() * ++max + min;
    }

    // staff: 1500-3500, manager: 3501-5000, executive: 5001-8000;
    private static double getRandomSalary(Role givenRole) {
        final int LOW_STAFF = 1500;
        final int HIGH_STAFF = 3500;
        final int LOW_MANAGER = 3501;
        final int HIGH_MANAGER = 5000;
        final int LOW_EXECUTIVE = 5001;
        final int HIGH_EXECUTIVE = 8000;
        switch (givenRole){
            case STAFF:
                return getSalary(LOW_STAFF, HIGH_STAFF);
            case MANAGER:
                return getSalary(LOW_MANAGER, HIGH_MANAGER);
            case EXECUTIVE:
                return getSalary(LOW_EXECUTIVE, HIGH_EXECUTIVE);
        }
        return getSalary(LOW_STAFF, HIGH_STAFF);
    }

    private static String getRandomDepartment(){
        String[] departments = {"Development-dept", "QA-dept", "Frontend-dept", "Backend-dept"};
        return departments[new Random().nextInt(4)];
    }

    private static String getRandomEmail(String name){
        String[] domains = {"@yandex.ru", "@mail.ru", "@gmail.com"};
        return name + domains[new Random().nextInt(3)];
    }

    private static String getRandomPhone(){
        String[] numbers = {"8916", "8903", "8926", "8964", "8917"};
        int min = 1000000;
        int max = 9999999;
        return numbers[new Random().nextInt(5)] + (min + new Random().nextInt(max + 1 - min));
    }

    private static String getRandomAddress(){
        String[] addresses = {"Planet Earth", "Planet Mars", "Planet Moon"};
        return addresses[new Random().nextInt(3)];
    }

    // in all planets there is the state Moscow and the code of this region is 777
    public static Employee getEmployee(Gender gender){
        String givenName = DatabaseEmployee.getRandomName(gender);
        Role randomRole = DatabaseEmployee.getRandomRole();
        return new Employee.Builder()
                .setGivenName(givenName)
                .setSurName(DatabaseEmployee.getRandomSurname(gender))
                .setAge(DatabaseEmployee.getRandomAge())
                .setGender(gender)
                .setRole(randomRole)
                .setSalary(DatabaseEmployee.getRandomSalary(randomRole))
                .setDept(DatabaseEmployee.getRandomDepartment())
                .setEMail(DatabaseEmployee.getRandomEmail(givenName))
                .setPhone(DatabaseEmployee.getRandomPhone())
                .setAddress(DatabaseEmployee.getRandomAddress())
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build();
    }
}
