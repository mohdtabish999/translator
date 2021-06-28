#!/usr/bin/env bash

set -e -u -x
cd source-code/
chmod 755 ./mvnw
./mvnw clean package

jar uf target/*.jar .profile

cd ..
#list all files
jar tf source-code/target/*.jar

#Instead of .profile, lets add certificate from here and check ?
$HOME/.java-buildpack/open_jdk_jre/bin/keytool -importcert -trustcacerts -noprompt -keystore $HOME/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit  -alias MyCert -file $HOME/BOOT-INF/classes/base64_hclcnlabs_certificate.cer

cp source-code/target/*.jar  build-output/.