//Namespace
package com.company;

//Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    //Fields
    private static Scanner in = new Scanner( System.in );
    private static ArrayList<Person> employees = new ArrayList<>();

    //Input data method to add employees to the array list.
    private static void inputData() {

        //Prompt
        System.out.println( "Enter the number of employees" );
        final int NUMBER_EMPLOYEES = in.nextInt();
        int counter = 0;

        while (counter != NUMBER_EMPLOYEES) {
            counter++;

            //Prompts
            in.nextLine();
            //Variables
            String firstName;
            do {
                System.out.println( "Enter the first name" );
                firstName = in.nextLine();
                if (!firstName.matches( "[A-Z][a-zA-Z]*" )) {
                    System.out.println( "Invalid input" );
                }
            }  while (!firstName.matches( "[A-Z][a-zA-Z]*" ));

            String lastName;
            do {
                System.out.println( "Enter the last name" );
                lastName = in.nextLine();
                if (!lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" )) {
                    System.out.println( "Invalid input" );
                }
            } while (!lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" ));

            int age;
            do {
                System.out.println( "Enter the age" );
                age = in.nextInt();
                if (age < 0 || age >= 120) {
                    System.out.println( "Age can not be negative or more than 120" );
                }
            } while (age < 0 || age >= 120);

            in.nextLine();
            System.out.println( "Enter the gender" );
            String gender = in.nextLine();

            String address;
            do {
                System.out.println( "Enter the address" );
                address = in.nextLine();
                if (!address.matches( "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")) {
                    System.out.println( "Invalid input" );
                }
            } while (!address.matches( "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"));

            System.out.println( "Enter the height" );
            double height = in.nextDouble();

            System.out.println( "Enter the weight" );
            double weight = in.nextDouble();

            //Add to array list creating a new object for each employee
            employees.add( new Person( firstName, lastName, age, gender, address, height, weight ) );
        }
    }

    //Main method
    public static void main(String[] args) {
        inputData();
        System.out.println(nameLongestAndShortest());
        System.out.println(lastNameLongestAndShortest());
        System.out.println(nameAndLastNameLongestAndShortest());
        System.out.println(oldestAndYoungest());
        System.out.println(tallestAndSmallest());
        System.out.println(heavierAndThinnest());
        arrangeAges();
        heightOrder();
    }

    private static String nameAndLastNameLongestAndShortest() {
        int longest = 0;
        String longestInfo = null;
        int shortest = 0;
        String shortestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                longest = employees.get(i).getName().length() + employees.get(i).getLastName().length();
                shortest = employees.get(i).getName().length() + employees.get(i).getLastName().length();
                longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                shortestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getName().length() + employees.get(i).getLastName().length() > longest) {
                    longest = employees.get(i).getName().length() + employees.get(i).getLastName().length();
                    longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getName().length() + employees.get(i).getLastName().length() < shortest) {
                    shortest = employees.get(i).getName().length() + employees.get(i).getLastName().length();
                    shortestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }
            }

        }
        return "The employee with the longest name and last name is: " + "\"" + longestInfo + "\" with " + longest + " letters.\nThe employee with the shortest name and last name is: " + "\"" + shortestInfo + "\" with " + shortest + " letters.";
    }

    private static String nameLongestAndShortest() {
        int longest = 0;
        String longestInfo = null;
        int shortest = 0;
        String shortestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                longest = employees.get(i).getName().length();
                shortest = employees.get(i).getName().length();
                longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                shortestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getName().length() > longest) {
                    longest = employees.get(i).getName().length();
                    longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getName().length() < shortest) {
                    shortest = employees.get(i).getName().length();
                    shortestInfo = employees.get(i).getLastName() + ", " + employees.get(i).getName();
                }
            }

        }
        return "The employee with the longest name is: " + "\"" + longestInfo + "\" with " + longest + " letters.\nThe employee with the shortest name is: " + "\"" + shortestInfo + "\" with " + shortest + " letters.";
    }

    private static String lastNameLongestAndShortest() {
        int longest = 0;
        String longestInfo = null;
        int shortest = 0;
        String shortestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                longest = employees.get(i).getLastName().length();
                shortest = employees.get(i).getLastName().length();
                longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                shortestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getLastName().length() > longest) {
                    longest = employees.get(i).getLastName().length();
                    longestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getLastName().length() < shortest) {
                    shortest = employees.get(i).getLastName().length();
                    shortestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }
            }

        }
        return "The employee with the longest last name is: " + "\"" + longestInfo + "\" with " + longest + " letters.\nThe employee with the shortest last name is: " + "\"" + shortestInfo + "\" with " + shortest + " letters.";
    }

    private static String tallestAndSmallest() {
        double tallest = 0.00;
        String tallestInfo = null;
        double smallest = 0.00;
        String smallestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                tallest = employees.get(i).getHeight();
                smallest = employees.get(i).getHeight();
                tallestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                smallestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getHeight() > tallest) {
                    tallest = employees.get(i).getHeight();
                    tallestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getHeight() < smallest) {
                    smallest = employees.get(i).getHeight();
                    smallestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }
            }

        }
        return "The tallest employee is: " + "\"" + tallestInfo + "\" measuring " + tallest + "mts.\nThe smallest employee is: " + "\"" + smallestInfo + "\" measuring " + smallest + "mts.";
    }

    private static String heavierAndThinnest() {
        double heaviest = 0.00;
        String heaviestInfo = null;
        double thinnest = 0.00;
        String thinnestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                heaviest = employees.get(i).getWeight();
                thinnest = employees.get(i).getWeight();
                heaviestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                thinnestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getWeight() > heaviest) {
                    heaviest = employees.get(i).getWeight();
                    heaviestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getWeight() < thinnest) {
                    thinnest = employees.get(i).getWeight();
                    thinnestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }
            }

        }
        return "The heaviest employee is: " + "\"" + heaviestInfo + "\" at " + heaviest + "kg.\nThe thinnest employee is: " + "\"" + thinnestInfo + "\" at " + thinnest + "kg.";
    }

    private static String oldestAndYoungest() {
        int oldest = 0;
        String oldestInfo = null;
        int youngest = 0;
        String youngestInfo = null;

        for (int i = 0; i < employees.size(); i++) {
            if (i == 0) {
                oldest = employees.get(i).getAge();
                youngest = employees.get(i).getAge();
                oldestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                youngestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
            } else {
                if (employees.get(i).getAge() > oldest) {
                    oldest = employees.get(i).getAge();
                    oldestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }

                if (employees.get(i).getAge() < youngest) {
                    youngest = employees.get(i).getAge();
                    youngestInfo = employees.get(i).getLastName() + ", " +employees.get(i).getName();
                }
            }

        }
        return "The oldest employee is: " + "\"" + oldestInfo + "\" at " + oldest + " years old.\nThe youngest employee is: " + "\"" + youngestInfo + "\" at " + youngest + " years old.";
    }

    private static void heightOrder() {

        Collections.sort( employees, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        } );

        System.out.println("Employee\t\tHeight(Tallest to shortest)");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getLastName() + ", " +employees.get(i).getName() + ": " + employees.get(i).getHeight());
        }
    }

    private static void arrangeAges () {
        int count0To12 = 0;
        int count13To18 = 0;
        int count19To35 = 0;
        int count36To65 = 0;
        int count65Plus = 0;


        for (Person employee : employees) {

            if (employee.getAge() < 13) {
                count0To12++;

            } else if (employee.getAge() >= 13 && employee.getAge() < 19) {
                count13To18++;

            } else if (employee.getAge() >= 19 && employee.getAge() < 36) {
                count19To35++;

            } else if (employee.getAge() >= 36 && employee.getAge() < 66) {
                count36To65++;

            } else {
                count65Plus++;
            }

        }
        System.out.println("There were " + count0To12 + " workers between ages 0-12");
        System.out.println("There were " + count13To18 + " workers between ages 13-18");
        System.out.println("There were " + count19To35 + " workers between ages 19-35");
        System.out.println("There were " + count36To65 + " workers between ages 36-65");
        System.out.println("There were " + count65Plus + " workers between ages 65+");
    }
}
