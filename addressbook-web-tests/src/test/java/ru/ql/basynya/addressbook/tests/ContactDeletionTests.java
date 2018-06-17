package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactDeletionAlert();
  }

}
