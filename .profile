#!/bin/bash
echo $HOME
echo $JAVA_HOME 
$HOME/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $HOME/.java-buildpack/open_jdk_jre/lib/security/cacerts

$HOME/.java-buildpack/open_jdk_jre/bin/keytool -importcert -trustcacerts -noprompt -keystore $HOME/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit  -alias MyCert -file $HOME/BOOT-INF/classes/base64_hclcnlabs_certificate.cer
echo $HOME
echo $JAVA_HOME 
$HOME/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $HOME/.java-buildpack/open_jdk_jre/lib/security/cacerts
pwd