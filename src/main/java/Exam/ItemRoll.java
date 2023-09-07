package Exam;
import java.util.Random;

public class ItemRoll {
    public static void Roll(){
        GenerateItems.getAll();
        System.out.println("Какую игрушку вы хотите попытаться получить? Введите ее id\n");
        Integer id = Service.ScanInt();
        for(Item item: GenerateItems.items){
            if (id == item.Id){
                try {
                    Validation.HasAmount(item);
                    if (RollTheDice(item)){
                        System.out.println("Поздравляем, вы выиграли! ");
                        Integer CheckId = item.getId();
                        if (GenerateItems.UserItems.stream().filter(el->el.getId() == CheckId).toList().isEmpty()){
                            GenerateItems.UserItems.add(new Item(item.getId(), 1,
                                    item.getName(),item.getDropChance()));
                        } else {
                            GenerateItems.UserItems.stream().filter(el->el.getId() == CheckId).
                                    forEach(el -> el.setAmount(el.getAmount()+1));
                        }
                        item.setAmount(item.getAmount()-1);
                    } else {
                        System.out.println("Не повезло :( Попробуйте в другой раз.");
                    }
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static boolean RollTheDice(Item item){
        if (GetChance() < item.getDropChance()){return true;} else {return false;}
    }
    public static int GetChance(){
        Random rand = new Random();
        int res = rand.nextInt(1, 101);
        return res;
    }
}
