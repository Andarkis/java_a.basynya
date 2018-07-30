package ru.ql.basynya.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  public Contacts (Collection<ContactData> contacts) {
    this.delegate = new HashSet<ContactData>(contacts);
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

  public boolean hasContactThatIsNotInAll(Groups groups) {
    Boolean result = false;
    for (ContactData contact : this) {
      if (contact.getGroups().size() < groups.size()) result = true;
    }
    return result;
  }

  public ContactData getContactThatIsNotInAll(Groups groups) {
    ContactData result = null;
    for (ContactData contact : this) {
      if (contact.getGroups().size() < groups.size()) result = contact;
    }
    return result;
  }

  public ContactData getContactById(int id) {
    ContactData result = null;
    for (ContactData contact : this) {
      if (contact.getId() == id) result = contact;
    }
    return result;
  }

  public boolean hasContactWithAnyGroup() {
    Boolean result = false;
    for (ContactData contact : this) {
      if (contact.getGroups().size() > 0) result = true;
    }
    return result;
  }

  public ContactData getContactWithAnyGroup() {
    ContactData result = null;
    for (ContactData contact : this) {
      if (contact.getGroups().size() > 0) result = contact;
    }
    return result;
  }
}
