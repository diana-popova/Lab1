package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите количество сотрудников:");
        int count = sc.nextInt();
        sc.nextLine();
        Employee employees[] = new Employee[count];
        System.out.println("Введите информацию о каждом сотруднике:");
        //ввод
        for (int i = 0; i < employees.length; i++) {

            employees[i] = new Employee();

            System.out.print("Введите фамилию " + (i + 1) + " сотрудника: \n");
            employees[i].surname = sc.nextLine();
            System.out.print("Введите его имя: \n");
            employees[i].name = sc.nextLine();
            System.out.print("Введите его отчество: \n");
            employees[i].otch = sc.nextLine();
            System.out.print("Введите его должность: \n");
            employees[i].position = sc.nextLine();
            System.out.print("Введите его оклад: \n");
            employees[i].salary = sc.nextInt();
            System.out.print("Введите количество детей:\n");
            employees[i].countChild = sc.nextInt();
            sc.nextLine(); // очистка буфера
            if (employees[i].countChild != 0) {
                employees[i].childen = new Child[employees[i].countChild];
                System.out.println("Дети: \n");
                for (int j = 0; j < employees[i].childen.length; j++) {
                    employees[i].childen[j] = new Child();
                    System.out.print("Введите имя " + (i + 1) + " ребенка: \n");
                    employees[i].childen[j].name = sc.nextLine();
                    System.out.print("Введите его возраст: \n");
                    employees[i].childen[j].age = sc.nextInt();
                    sc.nextLine(); // очистка буфера
                    sc.nextLine();
                }
            }
        }

        //вывод
        System.out.println("\n Сотрудники фирмы: \n Фамилия \t Имя \t Отчество \t Должность \tЗарплата");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].surname + "\t" + employees[i].name + "\t" + employees[i].otch
                    + "\t" + employees[i].position + "\t\t" + employees[i].salary);
            if(employees[i].countChild != 0){
                System.out.println("\nДети:");
                for (Child c : employees[i].childen)
                    System.out.println("Имя: " + c.name+ "\t" + "Возраст: " + c.age);
            }
        }
    }
}