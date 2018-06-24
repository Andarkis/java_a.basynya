package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    ContactData contactData = new ContactData(
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
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(contactData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}