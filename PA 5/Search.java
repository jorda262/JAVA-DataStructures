
public class Search {

	public static boolean has33(int[] data, int start, int end) {
		int target = 33;
		if (start >= end) {
			return false;
		}

		int middle = ((start + end) / 2);

		if ((data[middle]) == target) {
			return true;
		} else if (data[middle] < target) {
			return (has33(data, middle + 1, end));
		} else {
			return (has33(data, start, middle));
		}

	}

	public static void main(String[] args) {
		int[] array1 = {0, 4, 7, 18, 35, 51};
		int[] array2 = {0, 3, 7, 31, 33, 45};

	
		
		 System.out.println("Array 1" + " contains the value 33 " +has33(array1, 0, array1.length)); 
		 System.out.println("Array 2" + " contains the value 33 " + has33(array2, 0, array2.length));
		 
	}

}
