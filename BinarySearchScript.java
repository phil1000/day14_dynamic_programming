import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class BinarySearchScript {
	private List<Integer> integerList = new ArrayList<Integer>();
	
	public void launch(int listSize) {
		this.createList(listSize);
		Collections.sort(integerList);
		this.printList(integerList);
		this.find(integerList.get(listSize-2)); // find a high value
		this.find(integerList.get(1)); // find a low value
		this.find(integerList.get(listSize/2)); // find the middle value
		this.find(81772); // test what happens when value not found
	}
	
	private void createList(int listSize) {
		for (int i=0; i<listSize; i++) {
			integerList.add((int) Math.abs(listSize*10*Math.random())); // get fewer duplicates by multiplying listSize by 10
		}
	}
	
	private void find(int value) {
		if (binarySearch(value, integerList)) {
			System.out.println("Value " + value + " found");
		} else {
			System.out.println("Value " + value + " not found");
		}
	}
	
	private boolean binarySearch(int numberToFind, List<Integer> list) {
		System.out.println("trying to find " + numberToFind); 
		if (list.size()<=1) {
			// item not found
			return false;
		} else {
			int middleIndex=list.size()/2;
			int middleInt = list.get(middleIndex);
			System.out.println("list has size="+list.size()+"middle index="+middleIndex+" has value="+middleInt);
			if (middleInt==numberToFind) {
				return true;
			} else {
				if (middleInt>numberToFind) {
					List<Integer> newList = list.subList(0,middleIndex);
					printList(newList);
					return binarySearch(numberToFind, newList);
				} else {
					List<Integer> newList = list.subList(middleIndex,list.size());
					printList(newList);
					return binarySearch(numberToFind,newList);
				}
			}
		}
	}
	
	private void printList(List<Integer> list) {
		for (int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		BinarySearchScript script = new BinarySearchScript();
		if (args.length>0) script.launch(Integer.parseInt(args[0]));
		else System.out.println("enter number of integers");
	}	
}