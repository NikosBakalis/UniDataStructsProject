package mainpackage;

public class MergeSort extends mainClass {
	public void mergeSort(Integer[] array, int l, int h) { // methodos me onoma
															// mergeSort kai
															// orismata array
															// apo integers
															// apo integers l
															// kai h
		int low = l;
		int high = h;
		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2; // orizw to mesaio stixio tou pinaka
		mergeSort(array, low, mid); // gia to 1o miso tou pinaka
		mergeSort(array, mid + 1, high); // gia to 2o miso tou pinaka
		int end_low = mid;
		int start_high = mid + 1;
		while ((l <= end_low) && (start_high <= h)) {   // spaw ton pinaka se
			if (array[low] < array[start_high]) {       // pinakes isous me ta
				low++;                                  // stixia tou arxikoy
			} else {                                    // pinaka
				int Temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) {
					array[k + 1] = array[k];
				}
				array[low] = Temp; //sortarw ton pinaka
				low++;
				end_low++;
				start_high++;
			}
		}
	}
}
