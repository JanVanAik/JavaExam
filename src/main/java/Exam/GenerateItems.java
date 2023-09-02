package Exam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class GenerateItems {
    public static List<Item> items = new ArrayList<>();
    public static void CreateNewItem( String name, Integer amount, Integer DropChance){
        Integer id = getMaxId() + 1;
        Item NewItem = new Item(id, amount, name, DropChance);
        items.add(NewItem);
    }
    public static void ChangeDropChance(){
        System.out.println("Введите id игрушки, у который вы хотите поменять вероятность выпадения");
        Integer Id = Service.ScanInt();
        for(Item item: items){
            if (Id == item.Id){
                System.out.println(" Шанс выпадения игрушки равен " + item.DropChance + "% \n" +
                        "Введите новый шанс выпадения");
                Integer NewDropChance  = Service.ScanInt();
                item.setDropChance(NewDropChance);
                System.out.println("Шанс выпадения изменен");
            }
        }
    }

    public List<Item> getAll() {
        return items;
    }
    public static void AddItem(Item item){items.add(item);}
    public static Integer getMaxId() {
        Integer maxId = 0;
        for (Item item : items) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }
        return maxId;
    }

    public Integer getId(Integer Id) {
        for (Item item : items) {
            if (item.getId() == Id) {
                return Id;
            }
        }
        return 0;
    }
}
