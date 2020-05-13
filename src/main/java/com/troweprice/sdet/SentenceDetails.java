package com.troweprice.sdet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Keeps details of the shortest and longest word for provided sentence.
 * Where a word is any sequence of letters [a-zA-Z] seperated by any other character. 
 * 
 * @author Scott Redden
 *
 */
public class SentenceDetails {
	
	protected static final Logger logger = LoggerFactory.getLogger(SentenceDetails.class);
	
    private String sortestWord = "";
    private String longestWord = "";
    private String sentence = "";

    private String OUTPUT_FORMAT = "%s,%d";

    /**
     *
     * @param sentence to extract details from
     */
    SentenceDetails(String sentence)
    {
    	logger.info(sentence);
        if (sentence != null) {
            this.sentence = sentence;
            processSentence();
        }
    }

    private void processSentence() {

        List<String> words = new ArrayList<String>(Arrays.asList(sentence.split("[^a-zA-Z]+")));

        words.remove("");

        if (words.size() == 0)
            return;

        sortestWord = words.get(0);
        longestWord = words.get(0);

        for (String word : words)
        {
            if (sortestWord.length() > word.length())
            {
                sortestWord = word;
            }

            if (longestWord.length() < word.length())
            {
                longestWord = word;
            }
        }

    }

    /**
     * 
     * @return The longest word in the sentence and its length seperated by a comma
     *         "[word],[word.length]"
     *          A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnLargestWordDetails()
    {
        return String.format(OUTPUT_FORMAT,longestWord, longestWord.length());
    }

    /**
     * 
     * @return The shortest word in the sentence and its length seperated by a comma
     *         "[word],[word.length]"
     *          A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnShortestWordDetails()
    {
        return String.format(OUTPUT_FORMAT, sortestWord, sortestWord.length());
    }


}
