package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactInfoTests extends TestBase {
  @BeforeMethod
  public static void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("John")
              .withLastname("Doe")
              .withAddress("    346885,     Россия, Ростовская область, город Батайск, Половинко, 137   ")
              .withHome("55425")
              .withMobile("8 800 555 35 35")
              .withWork("+7(918)123-54-21")
              .withEmail("email1@example.com")
              .withEmail2("   email2@example.com")
              .withEmail3("email3@example.com")
              .withGroup("[none]"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones() {
     ContactData contact = app.contact().all().iterator().next();
     ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
     assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  @Test
  public void testContactAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm
            .getAddress().trim().replaceAll("[ ]{2,}"," ")));
  }

  @Test
  public void testContactEmails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }


  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().map(ContactInfoTests::cleaned)
            .filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail().trim(), contact.getEmail2().trim(), contact.getEmail3().trim())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
