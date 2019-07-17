package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner( System.in );
    private static ArrayList<String> employees = new ArrayList<>();
    private static String firstName = null;
    private static String lastName = null;
    private static int age = 0;
    private static String gender = null;
    private static String address = null;
    private static double height = 0;
    private static double weight = 0;

    private static void inputData() {

        //Fields
        Person person = new Person(firstName, lastName, age, gender, address, height, weight);

        System.out.println( "Enter the number of employees" );
        final int NUMBER_EMPLOYEES = in.nextInt();
        int counter = 0;

        while (counter != NUMBER_EMPLOYEES) {
            counter++;

            in.nextLine();
            System.out.println( "Enter the first name" );
            firstName = in.nextLine();

            System.out.println( "Enter the last name" );
            lastName = in.nextLine();

            System.out.println( "Enter the age" );
            age = in.nextInt();

            in.nextLine();
            System.out.println( "Enter the gender" );
            gender = in.nextLine();

            System.out.println( "Enter the address" );
            address = in.nextLine();

            System.out.println( "Enter the height" );
            height = in.nextDouble();

            System.out.println( "Enter the weight" );
            weight = in.nextDouble();

            person.setName(firstName);
            person.setLastName(lastName);
            person.setAge(age);
            person.setGender(gender);
            person.setAddress(address);
            person.setHeight(height);
            person.setWeight(weight);
            employees.add(person.getName() + person.getLastName() + person.getAge() + person.getGender() + person.getAddress() + person.getHeight() + person.getWeight());
        }
    }

    public static void main(String[] args) {
        inputData();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }

}
