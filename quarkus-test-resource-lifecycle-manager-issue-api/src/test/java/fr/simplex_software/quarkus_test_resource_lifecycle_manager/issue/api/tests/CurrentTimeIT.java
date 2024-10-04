package fr.simplex_software.quarkus_test_resource_lifecycle_manager.issue.api.tests;

import fr.simplex_software.quarkus_test_resource_lifecycle_management.issue.common.tests.*;
import io.quarkus.test.junit.*;
import org.eclipse.microprofile.config.inject.*;
import org.junit.jupiter.api.*;

@QuarkusTest
public class CurrentTimeIT extends AbstractCurrentTimeRessource
{
  @ConfigProperty(name = "quarkus.rest-client.baseUrl.url")
  String baseUrl;

  @BeforeAll
  public static void beforeAll()
  {
    System.out.println(">>> beforeAll(): quarkus.rest-client.baseUrl.url: " + System.getProperty("quarkus.rest-client.baseUrl.url"));
  }

  @Test
  public void test()
  {
    System.out.println(">>> test(): quarkus.rest-client.baseUrl.url: " + baseUrl);
  }
}
