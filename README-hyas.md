Goal: Build and deploy (via HYAS Maven feed) a JAR for 'com.azure.spring:spring-cloud-autoconfigure:5.9.1-hyas' containing a Spring 3.x-compatible com.azure.spring.cloud.autoconfigure.jms.properties.AzureServiceBusJmsProperties.class.

Steps taken:
1. Check out Spring Boot 3.x from main repository: git checkout spring-cloud-azure-starter-servicebus_5.9.1
2. Create a HYAS branch: git checkout -b spring-cloud-azure-starter-servicebus_5.9.1-hyas
3. Create a HYAS version: vi eng/versioning/version_client.txt; 1,$ s/;5.9.1$/;5.9.1-hyas/; python3 eng/versioning/update_versions.py --ut library --bt client
4. Update 'distribution_management' in eng/scripts/pom_helper.py (NOTE: no mention of running this in the prior README-hyas, probably not be necessary with picky-choose repo updates)
5. Update 'repositories', 'pluginRepositories', and 'distributionManagement' in sdk/parent/azure-client-sdk-parent/pom.xml; sdk/spring/spring-cloud-azure-starter/pom.xml; sdk/spring/spring-cloud-azure-starter-servicebus-jms/pom.xml
6. Install step 1: mvn clean install -f eng/code-quality-reports/pom.xml
7. Install step 2: mvn install -Dcheckstyle.skip=true -Dcodesnippet.skip -Denforcer.skip -Djacoco.skip=true -Dmaven.javadoc.skip=true -Drevapi.skip=true -DskipTests -Dspotbugs.skip=true -f sdk/spring/pom.xml
8. Deploy from main directory: mvn deploy -Dcheckstyle.skip=true -Dcodesnippet.skip -Denforcer.skip -Djacoco.skip=true -Dmaven.javadoc.skip=true -Drevapi.skip=true -DskipTests -Dspotbugs.skip=true -f sdk/spring/pom.xml
Result: [ERROR] Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy (default-deploy) on project spring-cloud-azure-core: Failed to deploy artifacts: Could not transfer artifact com.azure.spring:spring-cloud-azure-core:jar:5.9.1-hyas from/to HYAS (https://pkgs.dev.azure.com/hyas-devops/HYAS/_packaging/HYAS/maven/v1/): transfer failed for https://pkgs.dev.azure.com/hyas-devops/HYAS/_packaging/HYAS/maven/v1/com/azure/spring/spring-cloud-azure-core/5.9.1-hyas/spring-cloud-azure-core-5.9.1-hyas.jar, status: 409 Conflict - The feed 'HYAS' already contains file 'spring-cloud-azure-core-5.9.1-hyas.jar' in package 'com.azure.spring:spring-cloud-azure-core:5.9.1-hyas'. (DevOps Activity ID: E4972C8B-1E54-41F9-9D4A-8E2856E52600) -> [Help 1]
