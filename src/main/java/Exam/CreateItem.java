package Exam;

public class CreateItem {
    public static Item CreateItem(Integer id, String name, Integer amount, Integer DropChance){
        Item NewItem = new Item(id, amount, name, DropChance);
        return NewItem;
    }
}