package com.troweprice.sdet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SentenceDetailsTest {

	@Test
	public void testSentenceWithGivenExample() {

		SentenceDetails s = new SentenceDetails("The cow jumped over the moon.");
		assertEquals("jumped,6", s.returnLargestWordDetails());
		assertEquals("[jumped],6", s.returnAllLargestWordsDetails());
		assertEquals("the,3", s.returnShortestWordDetails());
		assertEquals("[cow, the],3", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceWithOneWord() {

		SentenceDetails s = new SentenceDetails("word");
		assertEquals("word,4", s.returnLargestWordDetails());
		assertEquals("[word],4", s.returnAllLargestWordsDetails());
		assertEquals("word,4", s.returnShortestWordDetails());
		assertEquals("[word],4", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceWithNull() {

		SentenceDetails s = new SentenceDetails(null);
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals("[],0", s.returnAllLargestWordsDetails());
		assertEquals(",0", s.returnShortestWordDetails());
		assertEquals("[],0", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceWithEmptyString() {

		SentenceDetails s = new SentenceDetails("");
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals("[],0", s.returnAllLargestWordsDetails());
		assertEquals(",0", s.returnShortestWordDetails());
		assertEquals("[],0", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceWithNoWords() {

		SentenceDetails s = new SentenceDetails("1+2=3");
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals("[],0", s.returnAllLargestWordsDetails());
		assertEquals(",0", s.returnShortestWordDetails());
		assertEquals("[],0", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceStartWithNotAWord() {

		SentenceDetails s = new SentenceDetails("£1 was all he paid at the shops!");
		assertEquals("shops,5", s.returnLargestWordDetails());
		assertEquals("[shops],5", s.returnAllLargestWordsDetails());
		assertEquals("he,2", s.returnShortestWordDetails());
		assertEquals("[at, he],2", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceStartWithShortWord() {

		SentenceDetails s = new SentenceDetails("a c b long");
		assertEquals("long,4", s.returnLargestWordDetails());
		assertEquals("[long],4", s.returnAllLargestWordsDetails());
		assertEquals("a,1", s.returnShortestWordDetails());
		assertEquals("[a, b, c],1", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceStartWithLongWord() {

		SentenceDetails s = new SentenceDetails("long b word");
		assertEquals("long,4", s.returnLargestWordDetails());
		assertEquals("[long, word],4", s.returnAllLargestWordsDetails());
		assertEquals("b,1", s.returnShortestWordDetails());
		assertEquals("[b],1", s.returnAllShortestWordsDetails());

	}

	@Test
	public void testSentenceStartWithDoubleNonWordGaps() {

		SentenceDetails s = new SentenceDetails("This is a double gap  followed by numbers 1234! What will happen?");
		assertEquals("followed,8", s.returnLargestWordDetails());
		assertEquals("a,1", s.returnShortestWordDetails());

	}

}
