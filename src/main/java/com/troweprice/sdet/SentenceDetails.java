package com.troweprice.sdet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Keeps details of the shortest and longest word for provided sentence.
 * Where a word is any sequence of letters [a-zA-Z] separated by any other character.
 *
 * @author Scott Redden
 *
 */
public class SentenceDetails {

    protected static final Logger logger = LoggerFactory.getLogger(SentenceDetails.class);

    private String shortestWord = "";
    private List<String> shortestWords = new ArrayList<String>();
    private String longestWord = "";
    private List<String> longestWords = new ArrayList<String>();
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

        Set<String> setOfShortestWords = new HashSet<String>();
        Set<String> setOfLongestWords = new HashSet<String>();

        words.remove("");

        if (words.size() == 0)
            return;

        shortestWord = words.get(0);
        longestWord = words.get(0);

        for (String word : words)
        {
            if (shortestWord.length() > word.length())
            {
                shortestWord = word;
                setOfShortestWords.clear();
                setOfShortestWords.add(shortestWord.toLowerCase());

            }
            else if (shortestWord.length() == word.length())
            {
                setOfShortestWords.add(word.toLowerCase());
            }

            if (longestWord.length() < word.length())
            {
                longestWord = word;
                setOfLongestWords.clear();
                setOfLongestWords.add(longestWord.toLowerCase());
            }
            else if (longestWord.length() == word.length())
            {
                setOfLongestWords.add(word.toLowerCase());
            }
        }

        shortestWords.addAll(setOfShortestWords);
        Collections.sort(shortestWords);
        longestWords.addAll(setOfLongestWords);
        Collections.sort(longestWords);

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
        return String.format(OUTPUT_FORMAT,longestWords, longestWord.length());
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
        return String.format(OUTPUT_FORMAT, shortestWords, shortestWord.length());
    }


}
