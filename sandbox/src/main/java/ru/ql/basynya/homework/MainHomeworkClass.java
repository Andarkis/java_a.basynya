package ru.ql.basynya.homework;

public class MainHomeworkClass {
  public static void main(String[] args) {
    Point a = new Point(0,0);
    Point b = new Point(3,4);
    Point c = new Point(4,4);
    //System.out.println("Растояние между точками (" + a.x + ", " + a.y +") и (" + b.x + ", " + b.y + ") = " + distance(a,b));
    System.out.println("Растояние между точками (" + a.x + ", " + a.y +") и (" + b.x + ", " + b.y + ") = " + a.distance(b));
    System.out.println("Растояние между точками (" + a.x + ", " + a.y +") и (" + c.x + ", " + c.y + ") = " + a.distance(c));
    System.out.println("Растояние между точками (" + b.x + ", " + b.y +") и (" + c.x + ", " + c.y + ") = " + b.distance(c));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}
