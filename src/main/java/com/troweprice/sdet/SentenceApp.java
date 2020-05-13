

package com.troweprice.sdet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentenceApp {
	
	protected static final Logger logger = LoggerFactory.getLogger(SentenceApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SentenceDetails s = new SentenceDetails(args[0]);
		logger.info("Longest  : "+s.returnLargestWordDetails());
		logger.info("Shortest : "+s.returnShortestWordDetails());
				
	}

}
