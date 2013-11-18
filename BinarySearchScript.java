import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class BinarySearchScript {
	List<Integer> integerList = new ArrayList<Integer>();
	
	public void launch(int listSize) {
		this.createList(listSize);
		Collections.sort(integerList);
		this.printList();
		if (binarySearch(7, 0, listSize)) {
			System.out.println("7 found");
		} else {
			System.out.println("7 not found");
		}
	}
	
	public boolean binarySearch(int numberToFind, int startIndex, int endIndex) {
		if ((endIndex-startIndex)<=0) {
			// item not found
			return false;
		} else {
			int middleIndex=((endIndex-startIndex)/2)-1;
			int middleInt = integerList.get(middleIndex);
			if (middleInt==numberToFind) {
				return true;
			} else {
				if (middleInt>numberToFind) {
					return binarySearch(numberToFind,startIndex,middleIndex-1);
				} else {
					return binarySearch(numberToFind,middleIndex+1,endIndex);
				}
			}
		}
	}
	
	public void printList() {
		for (int i=0; i<integerList.size();i++) {
			System.out.println(integerList.get(i));
		}
	}

	public static void main(String[] args) {
		BinarySearchScript script = new BinarySearchScript();
		if (args.length>0) script.launch(Integer.parseInt(args[0]));
	}
	
	private void createList(int listSize) {
		for (int i=0; i<listSize; i++) {
			integerList.add((int) Math.abs(listSize*Math.random()));
		}
	}
	
}