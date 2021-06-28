
https://community.pivotal.io/s/article/how-to-tell-application-containers-running-java-apps-to-trust-self-signed-certs-or-a-private-or-internal-ca?language=en_US

mvn clean  install -DskipTests

----------------------------Add Certificate----------------------

Add .profile file in root folder of sprigboot application using below command

	>jar uf target\translator-0.0.1-SNAPSHOT.jar .profile

List all files 

	> jar tf target\your-app.jar

Now push to PCF

	>cf push translator2 -p target\translator-0.0.1-SNAPSHOT.jar

	
------------------------Add Certificate command----------------------

	keytool -import -noprompt -trustcacerts -alias hclLabs -file der_hclcnlabs_certificate.cer -keystore C:\Program Files\Java\jdk1.8.0_181\jre\lib\security\cacerts\keystore.jks -storepass changeit
	keytool -importcert -trustcacerts -noprompt -keystore $HOME/.java-buildpack/open_jdk_jre/lib/security/cacerts -storepass changeit  -alias MyCert -file $HOME/BOOT-INF/classes/base64_hclcnlabs_certificate.cer
	
------------------------------------Commands------------------------------

	> cf login -a https://api.sys.tas.uat.xyzz.xyz.com -u modhtabish -p yourpassword --skip-ssl-validation
	> cf help
	> cf push <app-name> -p <path-to-executable-file-jar file>
	> cf push wrapper-service -p target/wrapper-service-0.0.1-SNAPSHOT.jar
	> cf push wrapper-service --docker-image mohdtabish99/wrapper-service:latest     (If doesnt work, use below command with usewrname)
	> set CF_DOCKER_PASSWORD=yourpassword 
	> cf push translator-service --docker-image mohdtabish99/translator --docker-username mohdtabish99
	> cf logs wrapper-service --recent
	> cf delete -r wrapper-service 
	
	> fly --target tutorial login --concourse-url http://127.0.0.1:8080 -u test -p test
	> fly -t dev pipelines
	> fly -t dev set-pipeline -p translate-svc-pipeline -c pipeline.yml -l pipeline-secrets.yml
	> fly -t dev destroy-pipeline -p hello-world