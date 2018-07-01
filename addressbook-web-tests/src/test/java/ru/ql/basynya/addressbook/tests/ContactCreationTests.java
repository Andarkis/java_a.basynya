package ru.ql.basynya.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(
            "John",
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
    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() + 1, after.size());
    }
}