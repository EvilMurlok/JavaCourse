package com.ilya.idea.lab4;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state; // region
    private int code; // code of region

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        STAFF("10%"), MANAGER("20%"), EXECUTIVE("30%");
        private final String percent;
        Role(String role){
            this.percent = role;
        }
        public String getBenefit(){ return percent; }
    }

    public Employee() {

    }

    public String getGivenName() {
        return givenName;
    }

    public Role getRole() {
        return role;
    }

    public String getSurName() {
        return surName;
    }

    public String getDept() {
        return dept;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + role +
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code=" + code +
                '}';
    }

    public static class Builder{
        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private Role role;
        private String dept;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state; // region
        private int code; // code of region

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public Builder setEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Employee build(){
            Employee employee = new Employee();
            employee.givenName = this.givenName;
            employee.surName = this.surName;
            employee.age = this.age;
            employee.gender = this.gender;
            employee.role = this.role;
            employee.dept = this.dept;
            employee.eMail = this.eMail;
            employee.phone = this.phone;
            employee.address = this.address;
            employee.city = this.city;
            employee.state = this.state;
            employee.code = this.code;
            return employee;
        }
    }

    public static List<Employee> createShortList(){
        List<Employee> shortList = new ArrayList<>();
        shortList.add(new Builder()
                .setGivenName("Ilia")
                .setSurName("Panin")
                .setAge(20)
                .setGender(Gender.MALE)
                .setRole(Role.STAFF)
                .setDept("Development-dept")
                .setEMail("ilia@gmail.com")
                .setPhone("89647777777")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Anna")
                .setSurName("Sidorova")
                .setAge(35)
                .setGender(Gender.FEMALE)
                .setRole(Role.MANAGER)
                .setDept("Development-dept")
                .setEMail("anna@yandex.ru")
                .setPhone("89646666666")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Ivan")
                .setSurName("Ivanov")
                .setAge(24)
                .setGender(Gender.MALE)
                .setRole(Role.STAFF)
                .setDept("QA-dept")
                .setEMail("ivan@gmail.com")
                .setPhone("89645555555")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Petr")
                .setSurName("Petrov")
                .setAge(47)
                .setGender(Gender.MALE)
                .setRole(Role.MANAGER)
                .setDept("QA-dept")
                .setEMail("petr@mail.ru")
                .setPhone("89644444444")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Vasily")
                .setSurName("Vasechkin")
                .setAge(38)
                .setGender(Gender.MALE)
                .setRole(Role.MANAGER)
                .setDept("Frontend-dept")
                .setEMail("vasily@yandex.ru")
                .setPhone("89643333333")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Mariya")
                .setSurName("Ivanova")
                .setAge(40)
                .setGender(Gender.FEMALE)
                .setRole(Role.EXECUTIVE)
                .setDept("Frontend-dept")
                .setEMail("mariya@gmail.com")
                .setPhone("89642222222")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Olga")
                .setSurName("Lubimova")
                .setAge(26)
                .setGender(Gender.FEMALE)
                .setRole(Role.STAFF)
                .setDept("Frontend-dept")
                .setEMail("olga@mail.ru")
                .setPhone("89641111111")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Alina")
                .setSurName("Gamova")
                .setAge(38)
                .setGender(Gender.FEMALE)
                .setRole(Role.MANAGER)
                .setDept("Backend-dept")
                .setEMail("alina@gmail.com")
                .setPhone("89642121212")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Kate")
                .setSurName("Klimova")
                .setAge(24)
                .setGender(Gender.FEMALE)
                .setRole(Role.STAFF)
                .setDept("Backend-dept")
                .setEMail("kate@yandex.ru")
                .setPhone("89643131313")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Denis")
                .setSurName("Maksimov")
                .setAge(25)
                .setGender(Gender.MALE)
                .setRole(Role.EXECUTIVE)
                .setDept("Backend-dept")
                .setEMail("denis@yandex.ru")
                .setPhone("89644141414")
                .setAddress("planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Anna")
                .setSurName("Lubimova")
                .setAge(48)
                .setGender(Gender.FEMALE)
                .setRole(Role.MANAGER)
                .setDept("Frontend-dept")
                .setEMail("Anna@mail.ru")
                .setPhone("89268168418")
                .setAddress("Planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Darya")
                .setSurName("Maksimova")
                .setAge(42)
                .setGender(Gender.FEMALE)
                .setRole(Role.EXECUTIVE)
                .setDept("Development-dept")
                .setEMail("Darya@mail.ru")
                .setPhone("89162591343")
                .setAddress("Planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());

        shortList.add(new Builder()
                .setGivenName("Denis")
                .setSurName("Petrov")
                .setAge(29)
                .setGender(Gender.MALE)
                .setRole(Role.STAFF)
                .setDept("QA-dept")
                .setEMail("Denis@yandex.ru")
                .setPhone("89178140903")
                .setAddress("Planet Earth")
                .setCity("Moscow")
                .setState("Moscow")
                .setCode(777)
                .build());
        return shortList;
    }
}