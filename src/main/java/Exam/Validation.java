package Exam;

public class Validation {
    public static void HasAmountValid(Item item,Integer amt){
        if (item.getAmount() < amt || amt < 0 ){throw new RuntimeException("Такого количества игрушек нет");}
    }
    public static void HasAmount(Item item){
        if (item.getAmount() <= 0 ){throw new RuntimeException("Игрушка закончилась в магазине :(");}
    }
    public static void DropChanceValid(Integer DropChance){
        if (DropChance < 0 || DropChance >100){throw new RuntimeException("Шанс выпадения введен некооректнол");}
    }
}
