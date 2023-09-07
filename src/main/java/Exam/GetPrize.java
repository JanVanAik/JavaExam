package Exam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetPrize {
    public static void GetPrize(){
        GenerateItems.getAllUserItems();
        System.out.println("Введите id игрушки, которую вы хотите получить");
        Scanner scanner = new Scanner(System.in);
        Integer Id = scanner.nextInt();
        for(Item item: GenerateItems.UserItems){
            if (Id == item.Id){
                System.out.println("Сколько игрушек вы хотите получить? Всего их у вас " + item.Amount);
                Scanner scan = new Scanner(System.in);
                Integer amt = scanner.nextInt();
                try{
                    try (FileWriter writer = new FileWriter("storage.txt",true)) {
                        Validation.HasAmountValid(item, amt);
                        writer.write(item.toString() + "\n");
                        item.setAmount(item.getAmount()-amt);
                        if (item.getAmount() == 0){
                            GenerateItems.items.remove(item);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
