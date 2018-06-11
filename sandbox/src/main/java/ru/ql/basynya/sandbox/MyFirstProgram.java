package ru.ql.basynya.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Andrey");
    double l = 3;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));
    double a = 2;
    double b = 5;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }

}