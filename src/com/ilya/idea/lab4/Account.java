package com.ilya.idea.lab4;

public class Account {
    public static void paySalary(Employee employee){
        System.out.println("Employee: " + employee.getRole() +
                " " + employee.getGivenName() +
                " " + employee.getSurName() +
                " (" + employee.getAge() + " years old)" +
                " from department " + employee.getDept() + " received SALARY!");
    }

    public static void payPremium(Employee employee){
        System.out.println("Employee: " + employee.getRole() +
                " " + employee.getGivenName() +
                " " + employee.getSurName() +
                " (" + employee.getAge() + " years old)" +
                " from department " + employee.getDept() +
                " received " + employee.getRole().getBenefit() +" PREMIUM!");
    }
}
