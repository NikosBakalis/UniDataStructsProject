package mainpackage;

import java.util.Scanner;

public class InterpolationSearch {
	public void interpolationSearch(Integer[] array, int n) {

		int search = -1;
		int mid;
		int first = 0;
		int last = array.length - 1;

		@SuppressWarnings("resource")
		Scanner isInput = new Scanner(System.in);
		System.out.println("Now enter the number you want to search: ");
		search = isInput.nextInt();

		mid = (search - first) / (last - first);

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

	public void randomInterpolationSearch(Integer[] array, int n, int search) {

		int mid;
		int first = 0;
		int last = array.length - 1;

		mid = (search - first) / (last - first);

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
