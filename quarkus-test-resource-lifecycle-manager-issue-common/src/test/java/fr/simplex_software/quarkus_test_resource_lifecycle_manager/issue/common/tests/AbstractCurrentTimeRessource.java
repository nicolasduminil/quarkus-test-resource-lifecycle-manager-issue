package fr.simplex_software.quarkus_test_resource_lifecycle_manager.issue.common.tests;

import io.quarkus.test.common.*;
import io.quarkus.test.junit.*;
import org.eclipse.microprofile.config.*;
import org.junit.jupiter.api.*;

@QuarkusTest
@QuarkusTestResource(value = MyTestRessource.class, restrictToAnnotatedClass = true)
public abstract class AbstractCurrentTimeRessource
{
  protected static final String BASE_URL = ConfigProvider.getConfig()
    .getValue("quarkus.rest-client.baseUrl.url", String.class);

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
