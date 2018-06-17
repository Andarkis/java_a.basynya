package ru.ql.basynya.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends ApplicationManager {

  @BeforeMethod
  public void setUp() throws Exception {
    init();
  }

  @AfterMethod
  public void tearDown() {
    stop();
  }

}
