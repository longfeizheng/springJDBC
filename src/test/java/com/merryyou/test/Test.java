package com.merryyou.test;

/**
 * Created on 2016/6/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Tesing tripleValue:");
        double percent = 10;
        System.out.println("Before :percent = "+percent);
        tripleValue(percent);
        System.out.println("after :percent = "+percent);


        System.out.println("------------------------------------------------");

        System.out.println("\nTesing tripleSalary");
        Employee a = new Employee("Alice",7000);
        Employee b = new Employee("Bob",6000);
        System.out.println("Before : a="+a.getName());
        System.out.println("Before : b="+b.getName());
        swap(a,b);
        System.out.println("After : a="+a.getName());
        System.out.println("After : b="+b.getName());


        System.out.println("------------------------------------------------");

        System.out.println("\nTesing tripleSalary");
        Employee harry = new Employee("Harry",5000);
        System.out.println("Before salary="+harry.getSalary());
        tripleSalary(harry);
        System.out.println("After salary ="+harry.getSalary());

    }

    private static void tripleSalary(Employee harry) {
        harry.setSalary(200);
        System.out.println("End of method salary ="+harry.getSalary());
    }

    private static void swap(Employee x, Employee y) {
        Employee temp = x;
        x=y;
        y = temp;
        System.out.println("End of method x ="+x.getName());
        System.out.println("End of method y ="+y.getName());
    }

    private static void tripleValue(double x) {
        x = 3*x;
        System.out.println("End of method x="+x);
    }

    static class Employee{
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
