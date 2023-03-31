interface Defends {
    int defend();
}

class CoffeeDefence implements Defends { //tar in totala skadan
    public int defend() {
        int defence = 15;
        System.out.println("The ten hour old coffee made you rage and protected you from " + defence + " damage\n");
        return defence;
    }
}

class BeerDefence implements Defends {
    public int defend() { //tar in totala skadan
        int defence = 20;
        System.out.println("The beer made you invincible and protected you from " + defence + " in damage\n");
        return defence;
    }
}

class WetTowelDefence implements Defends {
    public int defend() {
        int defence = 30;
        System.out.println("You used the wet towel as a whip and protected yourself from " + defence + " in damage\n");
        return defence;
    }
}

class SteelApronDefence implements Defends {
    public int defend() {
        int defence = 40;
        System.out.println("The steel apron returned the attack protected you from " + defence + " in damage\n");
        return defence;
    }
}

class GasBurnerDefence implements Defends {
    public int defend() {
        int defence = 50;
        System.out.println("Like a dragon you surrounded yourself with fire and protected yourself from " + defence + " in damage\n");
        return defence;
    }
}
