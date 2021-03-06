package org.jboss.mpbravo.brms.cep.demo;

import org.kie.api.runtime.rule.EntryPoint;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;


public class TwitterStatusListener implements StatusListener {
	
	private EntryPoint ep;
	
	public TwitterStatusListener(EntryPoint ep) {
        this.ep = ep;
    }

	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Insert tweets into the entry point
	 */
	@Override
	public void onStatus(Status arg0) {
		ep.insert( arg0 );
		
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
