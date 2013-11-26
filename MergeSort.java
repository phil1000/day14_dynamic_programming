public class MergeSort {

	public void launch() {
		int[] array = {41,75,5,66,3,3,7,2,9,1,88};
		this.printArray(array);
		this.mergeSortArray(array);
		this.printArray(array);
	}
	
	public void mergeSortArray(int[] array) {
		//this program edits the incoming array in situ i.e. it destroys its input
		// would normally try to avoid this
		if (array.length<=1) {
			return;
		} else {
			int[] leftArray = splitArray(0, array.length/2, array);
			int[] rightArray = splitArray(array.length/2,array.length, array);
			mergeSortArray(leftArray);
			mergeSortArray(rightArray);
			merge(array, leftArray, rightArray);
		}
	}
	
	public void merge(int[] array, int[] leftArray, int[] rightArray) {
		int a=0; // to navigate array
		int l=0; // to navigate leftArray
		int r=0; // to navigate rightArray
		
		while (a<array.length) {
			if ( (l<leftArray.length) && (r<rightArray.length) ) { 
				// have elements remaining in both arrays so move smallest to target array
				if (leftArray[l]<rightArray[r]) {
					array[a] = leftArray[l];
					l++;
				} else {
					array[a] = rightArray[r];
					r++;
				}
				a++;
			} else {
				if (l<leftArray.length) {
					// only left array elements remain so just insert them into target in order
					while (l<leftArray.length) {
						array[a]=leftArray[l];
						a++;
						l++;
					}
				} else {
					// only right array elements remain so just insert them into target in order
					while (r<rightArray.length) {
						array[a]=rightArray[r];
						a++;
						r++;
					}
				}
			}
		}
	}
	
	public int[] splitArray(int start, int end, int[] array) {
		//System.out.print("S:" + start + " E:" + end + " ");
		int newSize = end-start;
		int[] newArray = new int[newSize];
		for (int i=0; i<newSize;i++) {
			newArray[i]=array[start+i];
			//System.out.print(newArray[i]+",");
		}
		//System.out.println("");
		return newArray;
	}
	
	public void printArray(int[] array) {
		if (array.length>0)
			System.out.print(array[0]);
			
		for (int i=1;i<array.length;i++) {
			System.out.print("," + array[i]);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		MergeSort mySort = new MergeSort();
		mySort.launch();
	}

}