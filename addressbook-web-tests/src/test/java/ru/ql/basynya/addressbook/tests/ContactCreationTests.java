package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("John", "Doe", "test1", "55555", "88005553535", "88000000000", "test1@example.com", "test2@example.com", "test3@ecample.com"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
