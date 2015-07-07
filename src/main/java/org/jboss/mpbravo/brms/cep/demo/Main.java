package org.jboss.mpbravo.brms.cep.demo;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	private static final String CEP_STREAM = "TwitterStream";
	

	public static void main(String[] args) {

		LOGGER.info("Initialize KIE.");
		
		KieServices kieServices = KieServices.Factory.get();
		// Load KieContainer from resources on classpath (i.e. kmodule.xml and rules).
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		
		// Initializing KieSession.
		LOGGER.info("Creating KieSession.");
		final KieSession kieSession = kieContainer.newKieSession();
		
		// Start a Thread to fire rules in Drools Fusion
		final EntryPoint ep = kieSession.getEntryPoint(CEP_STREAM);
        new Thread(new Runnable() {

            public void run() {
            	kieSession.fireUntilHalt();
            }
        }).start();
		
		//Initialize Twitter entry point
		StatusListener listener = new TwitterStatusListener(ep);
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(listener);
        twitterStream.sample();
        
	}

}
