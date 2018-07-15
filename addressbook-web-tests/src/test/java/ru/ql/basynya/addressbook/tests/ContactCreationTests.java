package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;
import ru.ql.basynya.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("John")
            .withLastname("Doe")
            .withAddress("    346885,     Россия, Ростовская область, город Батайск, Половинко, 137   ")
            .withHome("55425")
            .withMobile("8 800 555 35 35")
            .withWork("+7(918)123-54-21")
            .withEmail("email1@example.com")
            .withEmail2("email2@example.com")
            .withEmail3("email2@example.com")
            .withGroup("[none]");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}