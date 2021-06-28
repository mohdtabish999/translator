
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
	