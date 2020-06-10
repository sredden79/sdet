package com.troweprice.sdet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SentenceDetailsTest {

	@Test
	public void testSentenceWithGivenExample() {
		
		SentenceDetails s = new SentenceDetails("The cow jumped over the moon.");
		assertEquals("jumped,6", s.returnLargestWordDetails());
		assertEquals("The,3", s.returnShortestWordDetails());
		
	}
	
	@Test
	public void testSentenceWithOneWord() {
		
		SentenceDetails s = new SentenceDetails("word");
		assertEquals("word,4", s.returnLargestWordDetails());
		assertEquals("word,4", s.returnShortestWordDetails());
		
	}
	
	@Test
	public void testSentenceWithNull() {
		
		SentenceDetails s = new SentenceDetails(null);
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals(",0", s.returnShortestWordDetails());
		
	}
	
	@Test
	public void testSentenceWithEmptyString() {
		
		SentenceDetails s = new SentenceDetails("");
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals(",0", s.returnShortestWordDetails());	
		
	}

	@Test
	public void testSentenceWithNoWords() {
		
		SentenceDetails s = new SentenceDetails("1+2=3");
		assertEquals(",0", s.returnLargestWordDetails());
		assertEquals(",0", s.returnShortestWordDetails());
		
	}

	@Test
	public void testSentenceStartWithNotAWord() {
		
		SentenceDetails s = new SentenceDetails("£1 was all he paid at the shops!");
		assertEquals("shops,5", s.returnLargestWordDetails());
		assertEquals("he,2", s.returnShortestWordDetails());
		
	}
	
	@Test
	public void testSentenceStartWithShortWord() {
		
		SentenceDetails s = new SentenceDetails("a long");
		assertEquals("long,4", s.returnLargestWordDetails());
		assertEquals("a,1", s.returnShortestWordDetails());
		
	}
	
	@Test
	public void testSentenceStartWithLongWord() {
		
		SentenceDetails s = new SentenceDetails("long b");
		assertEquals("long,4", s.returnLargestWordDetails());
		assertEquals("b,1", s.returnShortestWordDetails());
		
	}

	@Test
	public void testSentenceStartWithDoubleNonWordGaps() {

		SentenceDetails s = new SentenceDetails("This is a double gap  followed by numbers 1234! What will happen?");
		assertEquals("followed,8", s.returnLargestWordDetails());
		assertEquals("a,1", s.returnShortestWordDetails());

	}

}
