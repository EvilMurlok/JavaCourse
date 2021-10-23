package com.ilya.idea.lab4;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.function.Predicate;

public class trainStreams {
    public static void main(String[] args) {
        List<Employee> listToTrain = Employee.createShortList();
        Account acc = new Account();

        // Payment of bonuses to women employees
        System.out.println("-----------------------------------------------------------------------------------------");
        listToTrain.stream()
                .filter(employee -> employee.getGender() == Employee.Gender.FEMALE)
                .forEach(acc::payPremium);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Payment of salaries to employees of a Backend department
        listToTrain.stream()
                .filter(employee -> employee.getDept().equals("Backend-dept"))
                .forEach(acc::paySalary);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Payment of bonuses to employees over 30 working in a Frontend department
        // I've decided to train Predicate<T>
        Predicate<Employee> predicate = employee -> employee.getAge() > 30 &&
                                        employee.getDept().equals("Frontend-dept");
        listToTrain.stream()
                .filter(predicate)
                .forEach(acc::payPremium);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Payment of salaries to managers
        listToTrain.stream()
                .filter(employee -> employee.getRole() == Employee.Role.MANAGER)
                .forEach(acc::paySalary);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Payment of bonuses to staff
        listToTrain.stream()
                .filter(employee -> employee.getRole() == Employee.Role.STAFF)
                .forEach(acc::payPremium);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("OK!");
    }
}
