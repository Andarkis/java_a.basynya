package ru.ql.basynya.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("John", "Doe", "test1", "55555", "88005553535", "88000000000", "test1@example.com", "test2@example.com", "test3@ecample.com"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
