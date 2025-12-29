package org.example;

public class Main {

    // ---------- Point Sınıfı ----------
    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Getter ve Setter
        public int getX() { return x; }
        public int getY() { return y; }
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }

        // distance metodları
        public double distance() {
            return distance(0, 0);
        }

        public double distance(Point p) {
            return distance(p.getX(), p.getY());
        }

        public double distance(int a, int b) {
            return Math.sqrt((a - x) * (a - x) + (b - y) * (b - y));
        }
    }

    // ---------- Weapon Enum ----------
    public enum Weapon {
        SWORD(50, 1.2),
        AXE(60, 1.0),
        BOW(40, 1.5);

        private final int damage;
        private final double attackSpeed;

        Weapon(int damage, double attackSpeed) {
            this.damage = damage;
            this.attackSpeed = attackSpeed;
        }

        public int getDamage() { return damage; }
        public double getAttackSpeed() { return attackSpeed; }
    }

    // ---------- Player Sınıfı ----------
    public static class Player {
        private String name;
        private int healthPercentage;
        private Weapon weapon;

        public Player(String name, int healthPercentage, Weapon weapon) {
            this.name = name;
            this.weapon = weapon;
            if (healthPercentage > 100) this.healthPercentage = 100;
            else if (healthPercentage < 0) this.healthPercentage = 0;
            else this.healthPercentage = healthPercentage;
        }

        public int healthRemaining() { return healthPercentage; }

        public void loseHealth(int damage) {
            healthPercentage -= damage;
            if (healthPercentage <= 0) {
                healthPercentage = 0;
                System.out.println(name + " player has been knocked out of game");
            }
        }

        public void restoreHealth(int healthPotion) {
            healthPercentage += healthPotion;
            if (healthPercentage > 100) healthPercentage = 100;
        }
    }

    // ---------- Main Metodu ----------
    public static void main(String[] args) {
        // Test amaçlı örnekler
        Point p1 = new Point(6,5);
        Point p2 = new Point(3,1);

        System.out.println("distance(0,0)= " + p1.distance());
        System.out.println("distance(p2)= " + p1.distance(p2));
        System.out.println("distance(2,2)= " + p1.distance(2,2));

        Player player = new Player("John", 120, Weapon.SWORD);
        System.out.println("Player health: " + player.healthRemaining());
        player.loseHealth(50);
        System.out.println("Player health after damage: " + player.healthRemaining());
        player.restoreHealth(30);
        System.out.println("Player health after potion: " + player.healthRemaining());
    }
}
