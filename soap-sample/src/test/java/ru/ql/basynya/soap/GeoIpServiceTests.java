package ru.ql.basynya.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.58.250");
    assertTrue(ipLocation.contains("<Country>RU</Country>"));
  }

  @Test
  public void testInvalidIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.58.xxx");
    assertTrue(ipLocation.contains("<Country>RU</Country>"));
  }
}
