package com.ilya.idea.lab4;

/*
Based on past lab work add Employee salary field and
create 2 examples of using the following streaming methods:
1. map, peek
2. findFirst, lazy-operations
3. max, min
4. average, sum
 */

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TrainWorkWithStreams {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------------");
        List<Employee> listToTrain = Employee.createShortList();
        listToTrain.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // MAP
        // save only mail domains to the list, starting with the @ symbol where the domain is not equal "yandex.ru"
        List<String> result1 = listToTrain.stream()
                .filter(employee -> !employee.getMail().substring(employee.getMail().indexOf("@") + 1).equals("yandex.ru"))
                .map(employee -> employee.getMail().substring(employee.getMail().indexOf("@")))
                .collect(Collectors.toList());
        result1.forEach(System.out::println);
        listToTrain.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // get a list of 10% bonuses to be paid to women from the front-end department for the 8 March holiday
        List<Double> result2 = listToTrain.stream()
                .filter(employee -> employee.getGender().equals(Gender.FEMALE) &&
                        employee.getDept().equals("Frontend-dept"))
                .map(employee -> employee.getSalary() * 0.1)
                .collect(Collectors.toList());
        result2.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        //PEEK
        // output the salary and the Role,
        // also save in the list the first and last names in upper case
        // only male managers and male leads over 35 years old
        // from the front-end development department
        List<String> result3 = listToTrain.stream()
                .filter(employee -> employee.getDept().equals("Backend-dept") &&
                        employee.getGender().equals(Gender.MALE) &&
                        (employee.getRole().equals(Role.MANAGER) || employee.getRole().equals(Role.EXECUTIVE)))
                .peek(employee -> System.out.println(
                        employee.getGivenName() + " has salary: " +
                                employee.getSalary() + " and works as " + employee.getRole()
                ))
                .map(employee -> (employee.getGivenName() + " " + employee.getSurName()).toUpperCase())
                .collect(Collectors.toList());
        result3.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");


        // FIND_FIRST and AVERAGE
        // find the first employee from among the testers,
        // whose salary exceeds the average salary across the entire IT department
        double avgSalary = listToTrain.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println("The average salary of the it-department is " + avgSalary);
        Employee moreAvgTester = listToTrain.stream()
                .filter(employee -> employee.getDept().equals("QA-dept") && employee.getSalary() > avgSalary)
                .findFirst().orElse(new Employee.Builder().build());
        System.out.println(moreAvgTester);
        System.out.println("-----------------------------------------------------------------------------------------");


        // ANY_MATCH (all_match too boring) and MAX
        // is there at least one girl who works as a lead
        // and receives the maximum salary of all leads in the IT department?
        double maxSalary = listToTrain.stream()
                .filter(employee -> employee.getRole().equals(Role.EXECUTIVE))
                .mapToDouble(Employee::getSalary)
                .max().orElse(0.0);
        boolean booleanResult = listToTrain.stream().anyMatch(
                employee -> employee.getGender().equals(Gender.FEMALE) && employee.getSalary() == maxSalary
        );
        System.out.println("The max salary among the executives is " + maxSalary);
        System.out.println(booleanResult);
        System.out.println("-----------------------------------------------------------------------------------------");


        // SORTED and MIN
        // sort by salary, save the first 3 women whose salary is higher than the minimum among men
        double minMenSalary = listToTrain.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE))
                .mapToDouble(Employee::getSalary)
                .min().orElse(0.0);

        List<Employee> result4 = listToTrain.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .filter(employee -> employee.getGender().equals(Gender.FEMALE)
                        && employee.getSalary() > minMenSalary)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("The min salary among men is " + minMenSalary);
        result4.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
