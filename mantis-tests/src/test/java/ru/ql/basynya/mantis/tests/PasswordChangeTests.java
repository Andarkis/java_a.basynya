package ru.ql.basynya.mantis.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.ql.basynya.mantis.appmanager.HttpSessionHelper;
import ru.ql.basynya.mantis.model.MailMessage;
import ru.ql.basynya.mantis.model.UserData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class PasswordChangeTests extends TestBase {


  @BeforeClass
  public void startMailServer() {
    app.mail().start();
  }

  @DataProvider
  public static Iterator<Object[]> data() {
    String adminLogin = app.getProperty("web.adminLogin");
    String adminPassword = app.getProperty("web.adminPassword");
    String newUserPassword = app.getProperty("web.newUserPassword");
    UserData user = app.db().nonAdminUsers().iterator().next();

    List<Object[]> data = new ArrayList<>();
    data.add(new Object[]{adminLogin, adminPassword, newUserPassword, user});
    return data.iterator();
  }

  @Test(dataProvider = "data")
  public void testChangePassword(String adminLogin, String adminPassword, String newUserPassword, UserData user) throws IOException {

    app.uiSession().login(adminLogin, adminPassword);

    app.goTo().manageOverviewPage();
    app.goTo().manageUserPage();

    app.manageUser().openUserProfileByName(user.getUsername());

    String userEmail = app.manageUser().getEmail();
    assertThat(userEmail, equalTo(user.getEmail()));
    String userName = app.manageUser().getName();
    assertThat(userName, equalTo(user.getUsername()));

    app.manageUser().initResetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, userEmail);
    app.manageUser().resetPassword(confirmationLink, newUserPassword);

    HttpSessionHelper session = app.httpSession();
    assertTrue(session.login(userName, newUserPassword));
    assertTrue(session.isLoggedInAs(userName));
  }

  @AfterClass(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}