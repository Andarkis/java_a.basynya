package ru.ql.basynya.mantis.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.mantis.appmanager.HttpSessionHelper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSessionHelper session = app.httpSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
