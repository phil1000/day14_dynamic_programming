import java.util.ArrayList;

public class AnagramScript {
	
	ArrayList<String> palindromeList = new ArrayList<String>();
	ArrayList<String> anagramList = new ArrayList<String>();
	
	public void launch(String inStr) {
		
		palindromeList=getPalindromes(inStr);
		
		for (int i=0; i<palindromeList.size();i++) {
			System.out.println(palindromeList.get(i));
		}
		
		anagramList=getAnagrams(inStr);
		
		for (int i=0; i<anagramList.size();i++) {
			System.out.println(anagramList.get(i));
		}
		
	}

	public ArrayList<String> getAnagrams(String inStr) {
		
		if (inStr.length()==1)	{
			anagramList.add(inStr);
			return anagramList;
		} else {
			anagramList.add(inStr);
			getAnagrams(inStr.substring(1));
			anagramList.add(inStr);
			return anagramList;
		}
	}
	
	public ArrayList<String> getPalindromes(String inStr) {
		
		if (inStr.length()==1)	{
			palindromeList.add(inStr);
			return palindromeList;
		} else {
			palindromeList.add(inStr);
			getPalindromes(inStr.substring(1));
			palindromeList.add(inStr);
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