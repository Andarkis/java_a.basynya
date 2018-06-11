package ru.ql.basynya.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Andrey");
    Square s = new Square(3);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));
    Rectangle r = new Rectangle(2,5);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }

}