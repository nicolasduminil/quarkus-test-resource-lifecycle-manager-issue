package fr.simplex_software.quarkus_test_resource_lifecycle_manager.issue.api.tests;

import fr.simplex_software.quarkus_test_resource_lifecycle_manager.issue.common.tests.*;
import io.quarkus.test.junit.*;
import org.junit.jupiter.api.*;

@QuarkusTest
public class CurrentTimeIT extends AbstractCurrentTimeResource
{
  @BeforeAll
  public static void beforeAll()
  {
    System.out.println(">>> beforeAll(): quarkus.rest-client.baseUrl.url: " + System.getProperty("quarkus.rest-client.baseUrl.url"));
  }

  @Test
  public void test()
  {
    System.out.println(">>> test(): quarkus.rest-client.baseUrl.url: " + BASE_URL);
  }
}
