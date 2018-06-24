package ru.ql.basynya.addressbook.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("1","2","3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
