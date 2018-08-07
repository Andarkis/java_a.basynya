package ru.ql.basynya.mantis.appmanager;

import org.openqa.selenium.By;

public class ManageUserHelper extends HelperBase {

  public ManageUserHelper(ApplicationManager app) {
    super(app);
  }

  public void resetPassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("[type = submit]"));
  }

  public void clickSecond() {
    click(By.xpath("//tbody//tr[2]//a"));
  }

  public void openUserProfileByName(String username) {
    click(By.linkText(username));
  }

  public String getEmail() {
    return wd.findElement(By.xpath("//tr[3]//input[@name='email']")).getAttribute("value");
  }

  public String getName() {
    return wd.findElement(By.xpath("//tr[1]//input[@name='username']")).getAttribute("value");
  }

  public void initResetPassword() {
    click(By.cssSelector("input[value = 'Сбросить пароль']"));
  }


}
