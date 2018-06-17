package ru.ql.basynya.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    wd.findElement(By.linkText("home")).click();
    wd.findElement(By.name("selected[]")).click();
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    wd.switchTo().alert().accept();
  }

}
