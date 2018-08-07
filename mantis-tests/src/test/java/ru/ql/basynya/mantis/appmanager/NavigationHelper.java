package ru.ql.basynya.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void manageOverviewPage() {
    click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
  }


  public void manageUserPage() {
    //click(By.xpath("//a[contains(text(),'Управление пользователями')]"));
    //click(By.linkText("Управление пользователями)"));
    click(By.xpath("//div[2]/div[2]/div[2]/div/ul/li[2]/a"));
  }
}
