package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;
import ru.ql.basynya.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("John")
              .withLastname("Doe")
              .withAddress("    346885,     Россия, Ростовская область, город Батайск, Половинко, 137   ")
              .withHome("55425")
              .withMobile("8 800 555 35 35")
              .withWork("+7(918)123-54-21")
              .withEmail("email1@example.com")
              .withEmail2("email2@example.com")
              .withEmail3("email2@example.com")
              .withPhoto(new File(String.format("src/test/resources/img1.jpg"))));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListUI();
  }
}
