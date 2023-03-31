public class Item {
    private String name;
    private int price;
    private int defence;

    public Item(String name, int price, int defence) {
        setName(name);
        setPrice(price);
        setDefence(defence);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        if (defence >= 0) {
            this.defence = defence;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    @Override
    public String toString() {
        return getName() + " defends or heals you with " + getDefence() + " hp";
    }
}
