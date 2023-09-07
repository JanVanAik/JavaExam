package Exam;
import lombok.Data;
import lombok.Getter;

@Data
public class Item {
    protected Integer Id;
    protected Integer Amount;
    protected String Name;
    protected Integer DropChance;
    public Item (Integer Id, Integer Amount, String Name, Integer DropChance) {
        this.Id = Id;
        this.Amount = Amount;
        this.Name = Name;
        this.DropChance = DropChance;
    }

    @Override
    public String toString() {
        return String.format("Игрушка имеет следующие свойства: id: %s, amount: %s, Name: %s, DropChance %s",
                getId(),
                getAmount(), getName(), getDropChance());
    }

    public Integer getAmount() {
        return Amount;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getDropChance() {
        return DropChance;
    }

    public String getName() {
        return Name;
    }

    public void setDropChance(Integer dropChance) {
        DropChance = dropChance;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }
}
