#!/usr/bin/env bash

set -e -u -x
cd source-code/
chmod 755 ./mvnw
./mvnw clean package

jar uf target/*.jar .profile

cd ..
#list all files
jar tf source-code/target/*.jar

cp source-code/target/*.jar  build-output/.