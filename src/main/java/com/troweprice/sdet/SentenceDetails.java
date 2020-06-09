package com.troweprice.sdet;

import java.util.*;

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

    private String firstShortestWord = "";
    private Set<String> setOfShortestWords = new TreeSet<>();
    private String firstLongestWord = "";
    private Set<String> setOfLongestWords = new TreeSet<>();
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

    private String formatWord(String word)
    {
        return word.toLowerCase();
    }

    private void processSentence() {

        List<String> words = new ArrayList<String>(Arrays.asList(sentence.split("[^a-zA-Z]+")));

        words.remove("");

        if (words.size() == 0)
            return;

        firstShortestWord = formatWord(words.get(0));
        firstLongestWord = formatWord(words.get(0));

        for (String word : words)
        {
            if (firstShortestWord.length() > word.length())
            {
                firstShortestWord = formatWord(word);
                setOfShortestWords.clear();
                setOfShortestWords.add(firstShortestWord);
            }
            else if (firstShortestWord.length() == word.length())
            {
                setOfShortestWords.add(formatWord(word));
            }

            if (firstLongestWord.length() < word.length())
            {
                firstLongestWord = formatWord(word);
                setOfLongestWords.clear();
                setOfLongestWords.add(formatWord(word));
            }
            else if (firstLongestWord.length() == word.length())
            {
                setOfLongestWords.add(formatWord(word));
            }
        }

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
        return String.format(OUTPUT_FORMAT,firstLongestWord, firstLongestWord.length());
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
        return String.format(OUTPUT_FORMAT,setOfLongestWords, firstLongestWord.length());
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
        return String.format(OUTPUT_FORMAT, firstShortestWord, firstShortestWord.length());
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
        return String.format(OUTPUT_FORMAT, setOfShortestWords, firstShortestWord.length());
    }


}
