# rpasClient

Graphql client sdk for RPAS using the Apollo Graphql librray.

# Steps to run [POC state]: 

1. Build : mvn clean install
           This will generate the sources for queries and mutations defined under/src/main/graphql/
           
2. Run ClientImpl.main() , modify the url address to hit the appropriate env

# target state :

1. client adds the dependency to their project 
                       ```
		       	
			<dependency>
	
				<groupId>com.intuit.platform.integration</groupId>
				
	                      	<artifactId>rpasClient</artifactId>
				
	                      	<version>0.0.1-SNAPSHOT</version>
				
			</dependency>
			
			```
2. call clientService.query/mutate
