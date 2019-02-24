package mainpackage;

import java.util.Scanner;

public class SerialSearch {
	public void serialSearch(Integer[] array, int n) { // methodos me onoma
														// serialSearch kai
														// orismata array apo
														// integers kai n to
														// stixio pou psaxnw

		int search = -1;
		int c;
		@SuppressWarnings("resource")
		Scanner ssInput = new Scanner(System.in);
		System.out.println("Now enter the number you want to search: ");
		search = ssInput.nextInt();

		for (c = 0; c < n; c++) {
			if (array[c].equals(search)) {
				System.out.println(search + " is present at location " + (c + 1) + ".");
				break;
			}
		}
		if (c == n) {
			System.out.println(search + " isn't present in array.");
		}
	}

	public void randomSerialSearch(Integer[] array, int n, int search) {

		int c;
		for (c = 0; c < n; c++) {
			if (array[c].equals(search)) {
				System.out.println(search + " is present at location " + (c + 1) + ".");
				break;
			}
		}
		if (c == n)
			System.out.println(search + " isn't present in array.");
	}
}