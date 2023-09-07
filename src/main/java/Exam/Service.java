package Exam;

import java.util.Scanner;

public class Service {
    public static void Service(){
        GenerateItems.items.add(new Item(0, 10, "Car", 5));
        GenerateItems.items.add(new Item(1, 18, "Puzzle", 15));
        GenerateItems.items.add(new Item(2, 1, "PlushBear", 3));
        GenerateItems.items.add(new Item(3, 400, "sweet", 30));
        System.out.println("Добро пожаловать в программу розыгрыша игрушек. Выберите один из следующих пунктов\n" +
                "1) Добавить игрушку - Add\n" +
                "2) Попытаться достать игрушку  - Roll\n" +
                "3) Получить выигранный приз  - Get\n" +
                "4) Изменить вероятность выпадения игрушки - Change\n"+
                "5) Выйти из программы  - Exit\n");
        while (true) {
            System.out.println("*****\nОжидание команды\n*****\n");
            String UserInfo = ScanStr();
            switch (UserInfo.toLowerCase()) {
                case "add":
                    System.out.println("Введите имя игрушки:");
                    String name = ScanStr();
                    System.out.println("Введите количество игрушек на складе:");
                    Integer amount = ScanInt();
                    System.out.println("Введите вероятность выпадения в виде процента - одним числом от 1 до 100");
                    Integer DropChance = ScanInt();
                    try{
                        Validation.DropChanceValid(DropChance);
                        GenerateItems.CreateNewItem(name, amount, DropChance);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "roll":
                    ItemRoll.Roll();
                    break;
                case "get":
                    GetPrize.GetPrize();
                    break;
                case "change":
                    GenerateItems.ChangeDropChance();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Некорректная команда");
                    break;
            }
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
