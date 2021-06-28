#!/usr/bin/env bash

echo $HOME
echo $JAVA_HOME
#Add certificate to remove errors in tests
keytool -importcert -trustcacerts -noprompt -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit  -alias MyCert -file source-code/base64_hclcnlabs_certificate.cer


set -e -u -x

cd source-code/
chmod 755 ./mvnw
./mvnw clean package

jar uf target/*.jar .profile

cd ..
#list all files
jar tf source-code/target/*.jar

cp source-code/target/*.jar  build-output/.