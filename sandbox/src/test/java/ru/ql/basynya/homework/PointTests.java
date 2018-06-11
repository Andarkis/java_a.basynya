package ru.ql.basynya.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point a = new Point(0,0);
    Point b = new Point(3,4);
    Point c = new Point(4,4);
    Point d = new Point(-3,-4);
    Assert.assertEquals(a.distance(a),0.0);
    Assert.assertEquals(a.distance(b),5.0);
    Assert.assertEquals(a.distance(b), b.distance(a));
    Assert.assertEquals(b.distance(c), 1.0);
    Assert.assertEquals(b.distance(d), 10.0);
    Assert.assertEquals(a.distance(c), Math.sqrt(32));
  }
}
