# Goal
Build and deploy a dependency JAR (`com.azure.spring:spring-cloud-autoconfigure`) containing a Spring Boot 3.x-compatible `com.azure.spring.cloud.autoconfigure.jms.properties.AzureServiceBusJmsProperties.class` for use in HYAS's `pub-sub-core` library.

# History
This version of the Azure SDK for Java was chosen for it's support of Spring Boot 3.x and is based on tag `spring-cloud-azure-starter-servicebus_5.9.1` from Azure's main repository. `<repositories>`, `<pluginRepositories>`, and `<dependencyManagement>` elements have been added to this package's `pom.xml` to support HYAS deployment. If you are having issues deploying thsi project, ensure your `~/.m2/settings.xml` includes the HYAS repository details.

# Build and Deploy
* Update `sdk/spring/spring-cloud-azure-autoconfiguration/pom.xml` version (must be unique from past published versions)
* Build locally
```
mvn install -Dcheckstyle.skip=true -Dcodesnippet.skip -Denforcer.skip -Djacoco.skip=true -Dmaven.javadoc.skip=true -Drevapi.skip=true -DskipTests -Dspotbugs.skip=true -f sdk/spring/spring-cloud-azure-autoconfiguration/pom.xml
```
* Deploy to HYAS repository
```
mvn deploy -Dcheckstyle.skip=true -Dcodesnippet.skip -Denforcer.skip -Djacoco.skip=true -Dmaven.javadoc.skip=true -Drevapi.skip=true -DskipTests -Dspotbugs.skip=true -f sdk/spring/spring-cloud-azure-autoconfigure/pom.xml
```
