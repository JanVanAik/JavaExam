package Exam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetPrize {
    public static void GetPrize(){
        System.out.println("Введите id игрушки, у который вы хотите поменять вероятность выпадения");
        Scanner scanner = new Scanner(System.in);
        Integer Id = scanner.nextInt();
        for(Item item: GenerateItems.items){
            if (Id == item.Id){
                System.out.println("Сколько игрушек вы хотите получить? Всего их у вас" + item.Amount);
                Scanner scan = new Scanner(System.in);
                Integer amt = scanner.nextInt();
                try (FileWriter writer = new FileWriter("storage.txt",true)) {
                    writer.write(item.toString() + "\n");
                    item.setAmount(item.getAmount()-amt);
                    if (item.getAmount() == 0){
                        GenerateItems.items.remove(item);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
