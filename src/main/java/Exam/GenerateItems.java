package Exam;
import java.util.List;
import java.util.Scanner;

public  class GenerateItems {
    private  List<Item> items;
    public  void CreateNewItem(){

        System.out.println("Введите имя игрушки:");
        Scanner scanner = new Scanner(System.in);
        String ItemName = scanner.nextLine();
        System.out.println("Введите количество игрушек, доступных для розыгрыша");
        Integer ItemAmt = scanner.nextInt();
        System.out.println("Введите вероятность выпадения в виде процента - одним числом от 1 до 100");
        Integer ItemDropChance = scanner.nextInt();
        Integer ItemId = getMaxId() + 1;
        items.add(CreateItem.CreateItem(ItemId, ItemName, ItemAmt, ItemDropChance));

    }

    private Integer getMaxId() {
        Integer maxId = 0;
        for (Item item : items) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }
        return maxId;
    }
    public List<Item> getAll() {
        return items;
    }
}
