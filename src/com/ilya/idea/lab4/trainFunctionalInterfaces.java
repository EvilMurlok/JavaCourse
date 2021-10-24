package com.ilya.idea.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class trainFunctionalInterfaces {
    public static void main(String[] args) {
        // randomListToTest.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
        List<Employee> listToTest = Employee.createShortList();
        listToTest.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // display the first name, surname, age and department of employees
        // from the front-end department and the QA department
        // who are over or equal 40 years old
        Consumer<Employee> printConsumer = employee -> System.out.println("An employee " +
                employee.getGivenName() + " " + employee.getSurName() +
                " " + employee.getAge() + " years old from the department: " + employee.getDept());
        Predicate<Employee> predicate1 = employee -> (employee.getDept().equals("Frontend-dept") ||
                employee.getDept().equals("QA-dept")) && employee.getAge() >= 1000;
        listToTest.stream().filter(predicate1).forEach(printConsumer);
        // output the first such employee
        System.out.println("Output the first such employee:");
        printConsumer.accept(listToTest.stream().filter(predicate1).findFirst().orElse(new Employee()));
        System.out.println("-----------------------------------------------------------------------------------------");

        // get phone numbers without the eight and operator code
        Function<Employee, String> getNumber = employee -> employee.getPhone().substring(4);
        listToTest.forEach(employee -> System.out.println(employee.getGivenName() + " " +
                                                          employee.getSurName() + " has "  +
                                                          getNumber.apply(employee) + " number"));
        // we can save these numbers in the list for example
        List<String> result = listToTest.stream().map(getNumber).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Create an arrayList with 10 random employees using DatabaseEmployee
        Supplier<Employee> employeeMaleSupplier = () -> DatabaseEmployee.getEmployee(Employee.Gender.MALE);
        Supplier<Employee> employeeFemaleSupplier = () -> DatabaseEmployee.getEmployee(Employee.Gender.FEMALE);
        List<Employee> randomListToTest = new ArrayList<>();
        for (int i = 0; i < 10; ++i){
            if (i % 2 == 1){
                randomListToTest.add(employeeFemaleSupplier.get());
            }
            else{
                randomListToTest.add(employeeMaleSupplier.get());
            }
        }
        randomListToTest.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Save in the list all required (by department) employees from random employees list
        BiPredicate<Employee, String> biPredicate = ((employee, s) -> employee.getDept().equals(s));
        List<Employee> requiredEmployees = randomListToTest.stream().filter(employee ->
                biPredicate.test(employee, "Development-dept")).collect(Collectors.toList());
        requiredEmployees.forEach(employee -> System.out.println(employee.getGivenName() +
                                                                " " + employee.getSurName() +
                                                                " works in " + employee.getDept()));
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
