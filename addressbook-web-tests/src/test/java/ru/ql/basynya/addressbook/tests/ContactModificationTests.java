package ru.ql.basynya.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "John",
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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(
            before.get(before.size() - 1).getId(),
            "Modify John",
            "Modify Doe",
            "Modify Address",
            "Modify t55555",
            "Modify mobile",
            "Modify 88000000000",
            "Modify t1@example.com",
            "Modify t2@example.com",
            "Modify t3@ecample.com",
            null
    );
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}