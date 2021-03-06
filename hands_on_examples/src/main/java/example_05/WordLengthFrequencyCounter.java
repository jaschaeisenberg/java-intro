package example_05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WordLengthFrequencyCounter {
	
	private Map<Integer, Integer> frequencyTable = new HashMap<>();
	
	public Map<Integer, Integer> getFrequencyTable() {
		return frequencyTable;
	}

	public void printFrequencyTable() {
		for (Entry<Integer, Integer> entry : new TreeMap<Integer, Integer>(frequencyTable).entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public void calculateFrequencyTableFrom(List<String> wordList) {
		// Iterate over all words of the wordlist and:
		// Check if there is already an entry for the word length in the map.
		// If yes: Increment its counter.
		// If no: Create an entry.
	}

	
}
