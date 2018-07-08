package ru.ql.basynya.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("John")
            .withLastname("Doe")
            .withAddress("test1")
            .withMobile("88005553535")
            .withEmail("email1@example.com")
            .withGroup("[none]");

    app.contact().create(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(before.size() + 1, after.size());

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}