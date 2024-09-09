package entities;

public class Champion {
    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void takeDamage(int damage) {
        int damageTaken = Math.max(damage - this.armor, 1);
        this.life = Math.max(this.life - damageTaken, 0);
    }

    public String status() {
        if (this.life == 0) {
            return this.name + ": 0 life (died)";
        } else {
            return this.name + ": " + this.life + " life";
        }
    }
}

