import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetectPangram {
	
	public static void main(String[] args) {
		System.out.println(new DetectPangram().withListMethods("'A', 'B', 'C', 'D', 'E', 'F', 'g', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'"));
		System.out.println(new DetectPangram().check("'A', 's', 'C', 'D', 'E', 'F', 'g', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'"));
		System.out.println(new DetectPangram().withListMethodsAlternative("d', 'B', 'C', 'D', 'E', 'F', 'g', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'"));
		System.out.println(new DetectPangram().check2("A', 'B', 'C', 'D', 'E', 'F', 'g', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'"));
	}
	
	public boolean check(String sentence) {
		return new HashSet<>(Arrays.asList(sentence.toUpperCase().replaceAll("[^A-Z]","").split(""))).size()==26;
	}
	
	public boolean check2(String sentence) {
		List<Character> alphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
		ListIterator<Character> alphabetIterator;
		char[] upperCaseChars = sentence.toUpperCase().toCharArray();
		
		for (char charFromSentence : upperCaseChars) {
			alphabetIterator = alphabet.listIterator();
			while (alphabetIterator.hasNext()) {
				if (alphabetIterator.next().equals(charFromSentence)) {
					alphabetIterator.remove();
					break;
				}
			}
			if (alphabet.size() == 0) return true;
		}
		return false;
	}
	public boolean withListMethods(String sentence) {
		List<Character> charsCounter = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
		for (char character : sentence.toUpperCase().toCharArray()) {
			if (charsCounter.contains(character)) {
				charsCounter.remove((Character) character);
			}
			if (charsCounter.size() == 0) return true;
		}
		return false;
	}
	public boolean withListMethodsAlternative(String sentence) {
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char[] sentenceChars = sentence.toUpperCase().toCharArray();
		for (char alphabetCharacter : alphabet) {
			for (int i = 0; i < sentenceChars.length; i++) {
				if (sentenceChars[i] == alphabetCharacter) {
					break;
				} else if (i == sentenceChars.length - 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
