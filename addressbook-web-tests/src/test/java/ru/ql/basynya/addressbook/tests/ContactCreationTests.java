package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    ContactData contactData = new ContactData(
            "Jhon",
            "Doe",
            "test1",
            "55555",
            "88005553535",
            "88000000000",
            "email1@example.com",
            "emai2@example.com",
            "email3@ecample.com",
            "[none]"
    );
    app.getContactHelper().createContact(contactData);
  }

}