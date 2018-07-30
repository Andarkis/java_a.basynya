package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.ContactData;
import ru.ql.basynya.addressbook.model.Contacts;
import ru.ql.basynya.addressbook.model.GroupData;
import ru.ql.basynya.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemovingFromGroupTests extends TestBase {

  @BeforeClass
  public void ensurePreconditions() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test").withFooter("footer").withHeader("header"));
    }

    if (contacts.size() == 0 || !contacts.hasContactWithAnyGroup()) {
      GroupData group = groups.iterator().next();
      app.contact().create(new ContactData()
              .withFirstname("John").withLastname("Doe").withCompany("Company").inGroup(group));
    }
  }

  @DataProvider
  public static Iterator<Object[]> validDataFromDB() {
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.getContactWithAnyGroup();
    GroupData group = contact.getGroups().iterator().next();

    List<Object[]> data = new ArrayList<>();
    data.add(new Object[]{contact , group});
    return data.iterator();
  }

  @Test (dataProvider = "validDataFromDB")
  public void testContactRemovingFromGroup(ContactData contact, GroupData group) {
    app.goTo().homePage();
    Groups before = contact.getGroups();
    app.contact().removeContactFromGroup(contact, group);
    Groups after = app.db().contacts().getContactById(contact.getId()).getGroups();
    assertThat(after.size(), equalTo(before.size()-1));
    assertThat(after, equalTo(before.without(group)));
  }
}
