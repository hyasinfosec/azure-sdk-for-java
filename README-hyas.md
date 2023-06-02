What I did:

#GIT

Added azure-sdk-for-java as a fork.  

Branched off of tag spring-cloud-azure-starter-servicebus_4.6.0 and made branch spring-cloud-azure-starter-servicebus_4.6.0-hyas

#Version

Changed version to 4.6.0-hyas

Edit eng/versioning/version_client.txt and change last version

Run: python eng/versioning/update_versions.py --ut library --bt client
Checkin new files.

#Deploy

Modified:  

sdk/parents/azure-client-sdk-parent/pom.xml - put in our rep

Modified ~/.m2/setting.xml to have my personal deployment 

Run:

mvn install -Dcheckstyle.skip=true   -Dcodesnippet.skip   -Denforcer.skip   -Djacoco.skip=true   -Dmaven.javadoc.skip=true   -Drevapi.skip=true   -DskipTests   -Dspotbugs.skip=true -f sdk/spring/pom.xml

mvn deploy -Dcheckstyle.skip=true   -Dcodesnippet.skip   -Denforcer.skip   -Djacoco.skip=true   -Dmaven.javadoc.skip=true   -Drevapi.skip=true   -DskipTests   -Dspotbugs.skip=true -f sdk/spring/pom.xml
