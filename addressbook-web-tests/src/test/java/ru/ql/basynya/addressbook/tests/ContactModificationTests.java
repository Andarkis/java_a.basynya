package ru.ql.basynya.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeTest
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
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
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(
            before.get(index).getId(),
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
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}