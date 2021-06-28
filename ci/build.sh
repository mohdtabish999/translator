#!/usr/bin/env bash

echo $HOME
echo $JAVA_HOME
#Add certificate to remove errors in tests,was able to fetch certificate in running tests, but failed due to ${vcap.application.uris[0]} (PCF)not found
#keytool -importcert -trustcacerts -noprompt -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit  -alias MyCert -file source-code/base64_hclcnlabs_certificate.cer


set -e -u -x

cd source-code/
chmod 755 ./mvnw
./mvnw clean package -DskipTests

jar uf target/*.jar .profile
jar tf target/*.jar

cd ..
cp source-code/target/*.jar  build-output/.