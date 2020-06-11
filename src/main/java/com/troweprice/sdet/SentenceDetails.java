package com.troweprice.sdet;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Keeps details of the first occurring shortest and longest word for the provided sentence.
 * Where a word is any sequence of letters [a-zA-Z] separated by any other character.
 * 
 * @author Scott Redden
 *
 */
public class SentenceDetails {
	
	protected static final Logger logger = LoggerFactory.getLogger(SentenceDetails.class);

    List<String> words = null;
    private String shortestWord = "";
    private List<String> setShortestWords = null;
    private String longestWord = "";
    private List<String> setLongestWords = null;


    private String OUTPUT_FORMAT = "%s,%d";

    /**
     * Splits the sentence into words [a-zA-Z]+ tracking the shortest and longest.
     *
     * @param sentence to extract details from
     */
    SentenceDetails(String sentence)
    {
    	logger.info(sentence);
        if (sentence != null) {
            words = new ArrayList<String>(Arrays.asList(sentence.split("[^a-zA-Z]+")));
            words.remove("");
            if (words.size() != 0) {
                processSentence();
            }
        }
    }

    /**
     * Finds the first shortest and longest word which appears in the sentence
     * (converted to lowercase)
     */
    private void processSentence() {

        shortestWord = words.get(0);
        longestWord = words.get(0);

        for (String word : words)
        {
            if (shortestWord.length() > word.length())
            {
                shortestWord = word;
            }

            if (longestWord.length() < word.length())
            {
                longestWord = word;
            }
        }

        shortestWord = formatWord(shortestWord);
        longestWord = formatWord(longestWord);

    }

    private String formatWord(String word)
    {
        return word.toLowerCase();
    }

    /**
     *
     * @param wordLength the length of the word wanted to be extracted from sentence
     * @return a alphabetically ordered unique list of words of given length from the sentence
     */
    private List<String> findAllWordsOfLength(int wordLength)
    {
        if (wordLength == 0)
        {
            return new ArrayList<String>();
        }
        
        Set<String> wordsOfRequiredLength = new TreeSet<String>(String::compareTo);

        for (String word : words)
        {
            if (word.length() == wordLength)
            {
                wordsOfRequiredLength.add(formatWord(word));
            }
        }

        List<String> orderedWords = new ArrayList<String>();
        orderedWords.addAll(wordsOfRequiredLength);

        return orderedWords;
    }

    /**
     * 
     * @return The longest word in the sentence and its length separated by a comma
     *         "word,word.length"
     *          A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnLargestWordDetails()
    {
        return String.format(OUTPUT_FORMAT,longestWord, longestWord.length());
    }

    /**
     *
     * @return The longest words in the sentence (lower case and, sorted alphabetically)
     *         and its length separated by a comma
     *         "[word1, word2],word.length"
     *         A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnAllLargestWordsDetails()
    {
        if (setLongestWords == null)
        {
            setLongestWords = findAllWordsOfLength(longestWord.length());
        }
        return String.format(OUTPUT_FORMAT, setLongestWords, longestWord.length());
    }

    /**
     * 
     * @return The shortest word in the sentence and its length separated by a comma
     *         "word,word.length"
     *          A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnShortestWordDetails()
    {
        return String.format(OUTPUT_FORMAT, shortestWord, shortestWord.length());
    }

    /**
     *
     * @return The shortest words in the sentence (lower case and, sorted alphabetically)
     *         and its length separated by a comma
     *         "[word1, word2],word.length"
     *         A sentence which does not contain any valid words will return ",0"
     *
     */
    public String returnAllShortestWordsDetails()
    {
        if (setShortestWords == null)
        {
            setShortestWords = findAllWordsOfLength(shortestWord.length());
        }
        return String.format(OUTPUT_FORMAT, setShortestWords, shortestWord.length());
    }


}
