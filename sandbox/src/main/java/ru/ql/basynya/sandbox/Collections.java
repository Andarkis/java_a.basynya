package ru.ql.basynya.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main (String[] args) {
    String[] langs1 = new String[4];
    langs1[0] = "Java";
    langs1[1] = "C#";
    langs1[2] = "Python";
    langs1[3] = "PHP";

    for (int i = 0; i < langs1.length; i++) {
      System.out.println("Я хочу выучить " + langs1[i]);
    }

    String[] langs2;
    langs2 = new String[]{"1","2","3","4"};

    for (String l : langs2) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages2 = Arrays.asList("1","2","3","4");

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages2.get(i));
    }
  }
}
