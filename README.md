# brms-cep-twitter-example

Simple CEP example using Twitter as event feed

Configuration
-------------

 * Go to https://dev.twitter.com/ and register your application to get values for consumerKey/consumerSecret/accessToken/accessTokenSecret
 * Copy src/main/resources/twitter4j.properties.orig to src/main/resources/twitter4j.properties
 * Fill twitter4j.properties with those values

Execution
---------

Simply execute

	mvn test
