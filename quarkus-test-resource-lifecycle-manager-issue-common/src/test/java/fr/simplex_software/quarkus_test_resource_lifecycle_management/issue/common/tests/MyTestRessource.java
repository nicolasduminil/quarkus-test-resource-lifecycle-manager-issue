package fr.simplex_software.quarkus_test_resource_lifecycle_management.issue.common.tests;

import io.quarkus.test.common.*;
import jakarta.ws.rs.core.*;
import org.slf4j.*;
import org.testcontainers.containers.*;
import org.testcontainers.containers.output.*;
import org.testcontainers.containers.wait.strategy.*;

import java.util.*;

public class MyTestRessource implements QuarkusTestResourceLifecycleManager
{
  private static final String IMG_NAME = "nicolasduminil/quarkus-lifecycle-manager-test:1.0-SNAPSHOT";
  private static final Logger LOG = LoggerFactory.getLogger(MyTestRessource.class);

  private static final GenericContainer<?> quarkus =
    new GenericContainer<>(IMG_NAME)
      .withExposedPorts(8080)
      .withNetwork(Network.newNetwork())
      .withLogConsumer(new Slf4jLogConsumer(LOG))
      .withReuse(true)
      .waitingFor(Wait.forLogMessage(".*Installed features.*", 1));

  @Override
  public Map<String, String> start()
  {
    quarkus.start();
    return Map.of("quarkus.rest-client.baseUrl.url", UriBuilder.fromUri("http://" + quarkus.getHost())
      .port(quarkus.getMappedPort(8080)).build().toString());
  }

  @Override
  public void stop()
  {
  }
}
