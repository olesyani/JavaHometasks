package com.company;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws Exception {
	    // f.e. Петров Петр Петрович 11.12.2003
		System.out.println("Введите фамилию, имя, отчество и дату рождения (ДД.ММ.ГГГГ) через пробел:\n");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        Person example = new Person(str);
        example.printInformation();
	}
}
