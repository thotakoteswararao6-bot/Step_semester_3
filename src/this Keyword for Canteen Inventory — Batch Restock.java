class Item {
    String itemName;
    int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock += stock; // resolve clash with this
    }

    public void printStock() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }
}

public class CanteenInventoryDemo {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Samosa", 15),
                new Item("Tea Powder", 40),
                new Item("Bread", 8),
                new Item("Biscuit Packs", 25)
        };

        for (Item i : items) {
            i.restock(20);
            i.printStock();
        }
    }
}
