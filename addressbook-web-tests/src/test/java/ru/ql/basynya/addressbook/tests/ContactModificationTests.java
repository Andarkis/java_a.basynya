package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    ContactData contactModificationData = new ContactData(
            null,
            null,
            null,
            "t55555",
            null,
            "t88000000000",
            "t1@example.com",
            "t2@example.com",
            "t3@ecample.com",
            null
    );

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "Jhon",
              "Doe",
              "test1",
              "55555",
              "88005553535",
              "88000000000",
              "email1@example.com",
              "emai2@example.com",
              "email3@ecample.com",
              "[none]"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(contactModificationData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}