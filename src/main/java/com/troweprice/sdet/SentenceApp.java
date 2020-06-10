

package com.troweprice.sdet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentenceApp {
	
	protected static final Logger logger = LoggerFactory.getLogger(SentenceApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long timerStart = System.currentTimeMillis();
		SentenceDetails s = new SentenceDetails(args[0]);
		logger.info("Longest  : '{}'",s.returnLargestWordDetails());
		logger.info("Shortest : '{}'",s.returnShortestWordDetails());
		long timerEnd = System.currentTimeMillis();
		logger.info("Total time to find min and max word was : '{}ms'",timerEnd-timerStart);
				
	}

}
