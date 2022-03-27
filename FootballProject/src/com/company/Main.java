package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите кол-во футбольных команд");
        int n = sc.nextInt(); //кол-во команд
        Command commands[] = new Command[n];
        System.out.println("Введите информацию о командах");
        for(int i=0; i< commands.length; i++) //ввод
        {
            sc.nextLine();
            commands[i] = new Command();
            System.out.println("Введите название " + (i+1) + "-й команды");
            commands[i].title = sc.nextLine();
            System.out.println("Введите страну " + (i+1) + "-й команды");
            commands[i].city = sc.nextLine();
            System.out.println("Введите место в лиге " + (i+1) + "-й команды");
            commands[i].leagueTop = sc.nextInt();
            System.out.println("Введите кол-во побед " + (i+1) + "-й команды");
            commands[i].countWin = sc.nextInt();
            System.out.println("Характеристики команды:");
        }
        System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
        for(Command c: commands) //вывод
        {
            System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                    c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
        }
        //поиск команды к макс. кол-вом побед
        int nmax = 0; //индекс команды с наибольшим кол-вом побед
        int max = commands[nmax].countWin;
        for(int i = 0; i< commands.length; i++)
        {
            if(commands[i].countWin > max)
            {
                max = commands[i].countWin;
                nmax = i;
            }
        }
        System.out.println("Команда с максимальным кол-вом побед:" + "\n");
        System.out.println("Название команды: " + commands[nmax].title + "\n" +
                "Кол-во побед: " + commands[nmax].countWin);

        //поиск команды с кол-вом побед > среднего
        int sum = 0; //сумма всех побед
        for(int i=0; i< commands.length; i++)
            sum+=commands[i].countWin;
        double medium = sum/ commands.length; //среднее кол-во побед
        System.out.println("Среднее кол-во побед: " + medium);
        System.out.println("Команды с кол-вом побед выше среднего: " + "\n");
        for(int i=0; i<commands.length; i++)
        {
            if(commands[i].countWin>medium)
            {
                System.out.println("Название команды: " + commands[i].title + "\n" +
                        "Кол-во побед: " + commands[i].countWin + "\n");
            }
        }

        //Сортировка по месту в лиге
        for(int i=0; i < commands.length-1; i++)
        {
            for(int j=0; j < commands.length-1-i; j++)
            {
                if(commands[j].leagueTop > commands[j+1].leagueTop)
                {
                    Command temp = commands[j]; //временная переменная для перестановки
                    commands[j] = commands[j+1];
                    commands[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный список по месту в лиге: ");
        System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
        for(int i=0; i< commands.length; i++){
            System.out.println(commands[i].title + "\t"+ "\t" + commands[i].city + "\t" + "\t" + "\t" +
                    commands[i].leagueTop + "\t" + "\t" + "\t" + "\t" + commands[i].countWin);
        }

        //поиск по названию
        sc.nextLine();
        System.out.println("Введите название команды чтобы найти ее:");
        String search_title = sc.nextLine();
        int num = -1;
        for(int i=0; i< commands.length; i++)
        {
            if(search_title.equalsIgnoreCase(commands[i].title))
                num = i;
        }
        System.out.println("Найденые команды:");
        if(num != -1)
        {
            System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                    "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
            System.out.println(commands[num].title + "\t"+ "\t" + commands[num].city + "\t" + "\t" + "\t" +
                    commands[num].leagueTop + "\t" + "\t" + "\t" + "\t" + commands[num].countWin);
        }
        else System.out.println("Такой команды нет(");

        //редактирование полей
        sc.nextLine();
        int s; //индекс команды по умолчанию
        System.out.println("Введите название команды которую хотите редактировать: ");
        String inputTitle = sc.nextLine();
        for(int i=0; i< commands.length; i++) {
            if (inputTitle.equalsIgnoreCase(commands[i].title)) {
            }
            else
            {
                System.out.println("Такой команды нет(");
                break;
            }
        }
        System.out.println("Выберите поле которое хотите редактировать: " + "\n" +
                "1 - название" + "\n" +
                "2 - страна" + "\n" +
                "3 - место в лиге" + "\n" +
                "4 - кол-во побед");
        int inputField = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< commands.length; i++)
        {
                s=i;
                if(inputField == 1)
                {
                    String t;
                    System.out.println("Введите новое название команды:");
                    t = sc.nextLine();
                    commands[s].title = t;
                    System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                            "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                    for(Command c: commands) //вывод
                    {
                        System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                                c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                    }
                }
                else if(inputField == 2)
                {
                    System.out.println("Введите новую страну команды:");
                    commands[s].city = sc.nextLine();
                    System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                    "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                    for(Command c: commands) //вывод
                    {
                    System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                    c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                    }
                }
                else if(inputField == 3)
                {
                    System.out.println("Введите новое место команды в лиге:");
                    commands[s].leagueTop = sc.nextInt();
                    System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                            "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                    for(Command c: commands) //вывод
                    {
                        System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                                c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                    }
                }
                else if(inputField == 4)
                {
                    System.out.println("Введите новое кол-во побед команды:");
                    commands[s].countWin = sc.nextInt();
                    System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                            "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                    for(Command c: commands) //вывод
                    {
                        System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                                c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                    }
                }
        }
    }
}

