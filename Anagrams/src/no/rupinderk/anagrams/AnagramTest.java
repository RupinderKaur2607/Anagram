package no.rupinderk.anagrams;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void testGetJoinOfStrings() {
		  Map<String, List<String>> groupedStrings = new HashMap<>();
	        List<String> ListValue1 = Arrays.asList("Sorting1", "List1", "first", "test1");
	        List<String> ListValue2 = Arrays.asList("Sorting2", "List2", "second", "test2");
	        groupedStrings.put("a", ListValue1);
	        groupedStrings.put("b", ListValue2);
	        List<String> concatenated = Anagram.getJoinOfStrings(groupedStrings);
	        assertEquals("First list item should be ListValue1 concatenated", "Sorting1,List1,first,test1", concatenated.get(0));
	        assertEquals("Second list item should be ListValue2 concatenated", "Sorting2,List2,second,test2", concatenated.get(1));
	}

	@Test
	public void testGetSortedChars() {
		assertEquals("Result should be sorted", "abc", Anagram.getSortedChars("cab"));
	}

}
