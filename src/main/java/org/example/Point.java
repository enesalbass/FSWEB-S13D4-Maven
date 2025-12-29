package org.example;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    // 0,0 noktasına göre uzaklık
    public double distance(){
        return distance(0, 0);
    }

    // Başka bir Point objesine göre uzaklık
    public double distance(Point p){
        return distance(p.getX(), p.getY());
    }

    // (a,b) noktasına göre uzaklık
    public double distance(int a, int b){
        return Math.sqrt((a - x)*(a - x) + (b - y)*(b - y));
    }
}
