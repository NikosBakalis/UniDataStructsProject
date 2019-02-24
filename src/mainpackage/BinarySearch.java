package mainpackage;

import java.util.Scanner;

public class BinarySearch {
	public void binarySearch(Integer[] array, int n) {

		int search = -1;
		int mid;
		int first = 0;
		int last = array.length - 1;

		@SuppressWarnings("resource")
		Scanner bsInput = new Scanner(System.in);
		System.out.println("Now enter the number you want to search: ");
		search = bsInput.nextInt();

		mid = (first + last) / 2;

		while (first <= last) {
			if (array[mid] < search)
				first = mid + 1;
			else if (array[mid] == search) {
				System.out.println(search + " found at location " + (mid + 1) + ".");
				break;
			} else
				last = mid - 1;

			mid = (first + last) / 2;
		}
		if (first > last)
			System.out.println(search + " isn't present in the list.\n");
	}

	public void randomBinarySearch(Integer[] array, int n, int search) {

		int mid;
		int first = 0;
		int last = array.length - 1;

		mid = (first + last) / 2;

		while (first <= last) {
			if (array[mid] < search)
				first = mid + 1;
			else if (array[mid] == search) {
				System.out.println(search + " found at location " + (mid + 1) + ".");
				break;
			} else
				last = mid - 1;

			mid = (first + last) / 2;
		}
		if (first > last)
			System.out.println(search + " isn't present in the list.\n");
	}
}
