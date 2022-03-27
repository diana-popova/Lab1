package com.company;

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
        //вызовы методов
        MaxWin(commands);
        WinsHigherMedium(commands);
        LeagueTopSort(commands);
        TitleSearch(commands);
        EditFields(commands);
    }

    public static void MaxWin(Command arr[]) //поиск команды к макс. кол-вом побед
    {
        int nmax = 0; //индекс команды с наибольшим кол-вом побед
        int max = arr[nmax].countWin;
        for(int i = 0; i< arr.length; i++)
        {
            if(arr[i].countWin > max)
            {
                max = arr[i].countWin;
                nmax = i;
            }
        }
        System.out.println("Команда с максимальным кол-вом побед:" + "\n");
        System.out.println("Название команды: " + arr[nmax].title + "\n" +
                "Кол-во побед: " + arr[nmax].countWin);
    }

    public static void WinsHigherMedium(Command arr[]) //поиск команды с кол-вом побед > среднегo
    {
        int sum = 0; //сумма всех побед
        for(int i=0; i< arr.length; i++)
            sum+=arr[i].countWin;
        double medium = sum/ arr.length; //среднее кол-во побед
        System.out.println("Среднее кол-во побед: " + medium);
        System.out.println("Команды с кол-вом побед выше среднего: " + "\n");
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i].countWin>medium)
            {
                System.out.println("Название команды: " + arr[i].title + "\n" +
                        "Кол-во побед: " + arr[i].countWin + "\n");
            }
        }
    }

    public static void LeagueTopSort(Command arr[]) //Сортировка по месту в лиге
    {
        for(int i=0; i < arr.length-1; i++)
        {
            for(int j=0; j < arr.length-1-i; j++)
            {
                if(arr[j].leagueTop > arr[j+1].leagueTop)
                {
                    Command temp = arr[j]; //временная переменная для перестановки
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный список по месту в лиге: ");
        System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i].title + "\t"+ "\t" + arr[i].city + "\t" + "\t" + "\t" +
                    arr[i].leagueTop + "\t" + "\t" + "\t" + "\t" + arr[i].countWin);
        }
    }

    public static void TitleSearch(Command arr[]) //поиск по названию
    {
        Scanner sc = new Scanner(System.in, "cp1251");
        sc.nextLine();
        System.out.println("Введите название команды чтобы найти ее:");
        String search_title = sc.nextLine();
        int num = -1;
        for(int i=0; i< arr.length; i++)
        {
            if(search_title.equalsIgnoreCase(arr[i].title))
                num = i;
        }
        System.out.println("Найденые команды:");
        if(num != -1)
        {
            System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                    "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
            System.out.println(arr[num].title + "\t"+ "\t" + arr[num].city + "\t" + "\t" + "\t" +
                    arr[num].leagueTop + "\t" + "\t" + "\t" + "\t" + arr[num].countWin);
        }
        else System.out.println("Такой команды нет(");
    }

    public static void EditFields(Command arr[]) //редактирование полей
    {
        Scanner sc = new Scanner(System.in, "cp1251");
        sc.nextLine();
        int s; //индекс команды по умолчанию
        System.out.println("Введите название команды которую хотите редактировать: ");
        String inputTitle = sc.nextLine();
        for(int i=0; i< arr.length; i++) {
            if (inputTitle.equalsIgnoreCase(arr[i].title)) {
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
        for(int i=0; i< arr.length; i++)
        {
            s=i;
            if(inputField == 1)
            {
                String t;
                System.out.println("Введите новое название команды:");
                t = sc.nextLine();
                arr[s].title = t;
                System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                        "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                for(Command c: arr) //вывод
                {
                    System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                            c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                }
            }
            else if(inputField == 2)
            {
                System.out.println("Введите новую страну команды:");
                arr[s].city = sc.nextLine();
                System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                        "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                for(Command c: arr) //вывод
                {
                    System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                            c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                }
            }
            else if(inputField == 3)
            {
                System.out.println("Введите новое место команды в лиге:");
                arr[s].leagueTop = sc.nextInt();
                System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                        "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                for(Command c: arr) //вывод
                {
                    System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                            c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                }
            }
            else if(inputField == 4)
            {
                System.out.println("Введите новое кол-во побед команды:");
                arr[s].countWin = sc.nextInt();
                System.out.println("Название" + "\t"+ "Страна" + "\t"+ "\t" +
                        "Место в лиге" + "\t" + "Кол-во побед" + "\n" + "_____________________________________________________");
                for(Command c: arr) //вывод
                {
                    System.out.println(c.title + "\t"+ "\t" + c.city + "\t" + "\t" + "\t" +
                            c.leagueTop + "\t" + "\t" + "\t" + "\t" + c.countWin);
                }
            }
        }
    }
}
