package Items;

import Characters.Player;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public abstract boolean use(Player player);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
