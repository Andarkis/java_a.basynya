package ru.ql.basynya.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    gotoHomePage();
    selectContact();
    deleteSelectedContacts();
    acceptAlert();
  }

  private void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  private void deleteSelectedContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  private void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }

  private void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

}
