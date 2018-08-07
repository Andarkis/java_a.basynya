package ru.ql.basynya.mantis.appmanager;

import org.openqa.selenium.By;

public class UiSessionHelper extends HelperBase {

  public UiSessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    click(By.cssSelector("[type = submit]"));
    type(By.name("password"), password);
    click(By.cssSelector("[type = submit]"));
  }
}
