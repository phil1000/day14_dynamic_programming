import java.util.ArrayList;

public class AnagramScript {
	
	ArrayList<String> palindromeList = new ArrayList<String>();
	ArrayList<String> anagramList = new ArrayList<String>();
	
	public void launch(String inStr) {
		//first generate and print palindromes for the incoming string
		//palindromeList=getPalindromes(inStr);
		//printList(palindromeList);
		//now generate and print all anagrams (assume all letters have to be used, otherwise could also invoke the palindrome creator)
		anagramList=getAnagrams(inStr);
		printList(anagramList);
	}

	public void printList(ArrayList<String> list) {
		for (int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public ArrayList<String> getAnagrams(String inStr) {
		
		if (inStr.length()==1)	{
			anagramList.add(inStr);
			return anagramList;
		} else {
			anagramList.add(inStr);
			getAnagrams(inStr.substring(1));
			anagramList.add(inStr.substring(1)+inStr.substring(0,1));
			return anagramList;
		}
	}
	
	public ArrayList<String> getPalindromes(String inStr) {
		
		if (inStr.length()<=2)	{
			String newString = "";
			for (int i=0; i<inStr.length();i++) {
				newString=newString+inStr.charAt(inStr.length() -1 - i);
			}
			palindromeList.add(inStr);
			return palindromeList;
		} else {
			palindromeList.add(inStr);
			getPalindromes(inStr.substring(1));
			palindromeList.add(inStr);  // only have this line if you want a pyramid effect on output
			return palindromeList;
		}
	}
	
	public static void main(String[] args) {
		AnagramScript myScript = new AnagramScript();
		
		if (args.length>0) {
			myScript.launch(args[0]);
		}
		else {
			System.out.println("Provide a string as a parameter please");
		}
	}
}