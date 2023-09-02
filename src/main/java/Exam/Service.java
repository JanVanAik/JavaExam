package Exam;

import java.util.Scanner;

public class Service {
    public static void Service(){
        GenerateItems.items.add(new Item(0, 10, "car", 5));
        System.out.println("Добро пожаловать в программу розыгрыша игрушек. Выберите один из следующих пунктов\n" +
                "1) Добавить игрушку - Add\n" +
                "2) Попытаться достать игрушку  - Roll\n" +
                "3) Получить выигранный приз  - Get\n" +
                "4) Изменить вероятность выпадения игрушки - Change\n"+
                "5) Выйти из программы  - Exit\n");
        String UserInfo = ScanStr();
        switch(UserInfo.toLowerCase()){
            case "add":
                System.out.println("Введите имя игрушки:");
                String name = ScanStr();
                System.out.println("Введите количество игрушек на складе:");
                Integer amount = ScanInt();
                System.out.println("Введите вероятность выпадения в виде процента - одним числом от 1 до 100");
                Integer DropChance = ScanInt();
                GenerateItems.CreateNewItem(name, amount, DropChance);
            case "roll":
            case "get":
                GetPrize.GetPrize();
            case "change":
                GenerateItems.ChangeDropChance();
            case "exit":
                System.exit(0);
        }
    }

    public static Integer ScanInt() {
        Scanner scanner = new Scanner(System.in);
        Integer IntInfo = scanner.nextInt();
        return IntInfo;

    }
    public static String ScanStr() {
        Scanner scanner = new Scanner(System.in);
        String StrInfo = scanner.nextLine();
        return StrInfo;
    }

}
