package com.company;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person
{
    private String surname, initials, sex; 
    private long age;
    
    public Person(String str) throws Exception {
        Scanner scan = new Scanner(str);
        surname = scan.next();
        String name = scan.next();
        String secondname = scan.next();
        String birthdate = scan.next();
        computeSex(secondname);
        modifyToInitials(name, secondname);
        computeAge(birthdate);
    }
    public void modifyToInitials(String name, String secondname) {
        name = name.substring(0, 1);
        secondname = secondname.substring(0, 1);
        initials = name + ". " + secondname + ".";
    }
    public void printInformation() {
        System.out.print(surname + " " + initials + ", " + sex + ", " + age);
    }
    public void computeAge(String birthdate) {
        int day = Integer.parseInt(birthdate.substring(0,2));
        int month = Integer.parseInt(birthdate.substring(3,5));
        int year = Integer.parseInt(birthdate.substring(6,10));
        LocalDate dateofbirth = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        age = ChronoUnit.YEARS.between(dateofbirth, today);
    }
    public void computeSex(String secondname) {
        if (secondname.endsWith("ич")) {
            sex = "Мужчина";
        } else if (secondname.endsWith("на")) {
            sex = "Женщина";
        } else {
            System.out.print("Wrong secondname");
        }
    }
    public String getSurname() {
        return surname;
    }
    public String getInitials() {
        return initials;
    }
    public String getSex() {
        return sex;
    }
    public long getAge() {
        return age;
    }
}