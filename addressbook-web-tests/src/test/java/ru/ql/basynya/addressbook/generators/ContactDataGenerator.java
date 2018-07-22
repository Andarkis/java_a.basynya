package ru.ql.basynya.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.ql.basynya.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    switch (format) {
      case "xml":
        saveAsXml(contacts, new File(file));
        break;
      case "json":
        saveAsJson(contacts, new File(file));
        break;
      default:
        System.out.println("Unrecognized format " + format);
        break;
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json =  gson.toJson(contacts);
    try (Writer writer = new FileWriter(file);) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData()
              .withFirstname(String.format("firstname %s",i))
              .withLastname(String.format("lastname %s",i))
              .withAddress(String.format("address %s",i))
              .withHome(String.format("home %s",i))
              .withMobile(String.format("mobile %s",i))
              .withWork(String.format("work %s",i))
              .withEmail(String.format("%semail@gmail.com",i))
              .withEmail2(String.format("%semail2@gmail.com",i))
              .withEmail3(String.format("%semail3@gmail.com",i))
              .withGroup("[none]")
              .withPhoto(new File(String.format("src/test/resources/img%s.jpg",i % 3))));
    }
    return contacts;
  }
}
