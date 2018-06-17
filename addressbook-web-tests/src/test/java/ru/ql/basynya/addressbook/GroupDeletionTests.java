package ru.ql.basynya.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    wd.findElement(By.linkText("groups")).click();
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
    wd.findElement(By.name("delete")).click();
    wd.findElement(By.linkText("group page")).click();
  }

}
