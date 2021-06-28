#!/bin/bash
$HOME/app/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $HOME/app/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit | grep 'Your keystore contains'

$HOME/app/.java-buildpack/open_jdk_jre/bin/keytool -importcert -trustcacerts -noprompt -keystore $HOME/app/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit  -alias MyCert -file $HOME/app/BOOT-INF/classes/base64_hclcnlabs_certificate.cer

$HOME/app/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $HOME/app/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit | grep 'Your keystore contains'



$PWD/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $PWD/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit | grep 'Your keystore contains'
$PWD/.java-buildpack/open_jdk_jre/bin/keytool -importcert -trustcacerts -noprompt -keystore $PWD/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit  -alias MyCert -file $PWD/BOOT-INF/classes/base64_hclcnlabs_certificate.cer
$PWD/.java-buildpack/open_jdk_jre/bin/keytool -list -v -keystore $PWD/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit | grep 'Your keystore contains'
