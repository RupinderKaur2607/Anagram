package no.rupinderk.anagrams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

	private static final String DICTIONARY_CHARSET = "ISO-8859-1";

	private static final String DICTIONARY = "eventyr.txt";

	public static void main(String[] args) {
		Path path = Paths.get(DICTIONARY);
		try (Stream<String> lines = Files.lines(path, Charset.forName(DICTIONARY_CHARSET))) {
			Map<String, List<String>> groupedBySortedChars = lines
					.collect(Collectors.groupingBy(Anagram::getSortedChars));
			List<String> joinedStrings = getJoinOfStrings(groupedBySortedChars);
			joinedStrings.stream().forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getJoinOfStrings(Map<String, List<String>> groupedStrings) {
		return groupedStrings.entrySet().stream().filter(e -> e.getValue().size() > 1)
				.map(e -> String.join(",", e.getValue())).collect(Collectors.toList());
	}

	public static String getSortedChars(String word) {
		return word.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
	}

}