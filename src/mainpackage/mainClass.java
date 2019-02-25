package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainClass {

	public static void main(String[] args) throws Exception {
		MergeSort ms = new MergeSort();

		SerialSearch ss = new SerialSearch();
		BinarySearch bs = new BinarySearch();
		InterpolationSearch is = new InterpolationSearch();

		RedBlackTree rbt = new RedBlackTree();

		DigitalTrie dt = new DigitalTrie();

		PrintWriter outSerial = new PrintWriter("Serial.txt");
		PrintWriter outBinary = new PrintWriter("Binary.txt");
		PrintWriter outInterpolation = new PrintWriter("Interpolation.txt");
		PrintWriter outRedBlack = new PrintWriter("RedBlack.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader("integers.txt"));
			List<Integer> lines = new ArrayList<Integer>();
			String line;

			while ((line = br.readLine()) != null) {
				lines.add(Integer.parseInt(line));
			}
			br.close();

			BufferedReader brTxt = new BufferedReader(new FileReader("words.txt"));
			List<String> linesTxt = new ArrayList<String>();
			String lineTxt;

			while ((lineTxt = brTxt.readLine()) != null) {
				linesTxt.add(lineTxt);
			}
			brTxt.close();

			Integer[] inputArray = lines.toArray(new Integer[lines.size()]); // ìåôáôñåðåé
																				// ôï
																				// ArrayList
																				// óå
																				// Array

			ms.mergeSort(inputArray, 0, inputArray.length - 1);

			System.out.println("Waiting to print integers.txt");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			for (Integer i : inputArray) {
				System.out.println(i);
			}

			String[] inputArrayTxt = linesTxt.toArray(new String[linesTxt.size()]);

			System.out.println("");
			System.out.println("");
			System.out.println("Now waiting to print words.txt");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(".");

			try {
				Thread.sleep(2000);

			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			for (String iTxt : inputArrayTxt) {
				System.out.println(iTxt);
			}

			System.out.println("");
			System.out.println("");
			System.out.println("Print has ended");

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String item = "";

			while (!item.equals("Exit me")/*item != -999*/) {
				String choise = "";
				System.out.println("");
				System.out.println("         Main Menu!");
				System.out.println("Choose '1' for Serial Search,");
				System.out.println("Choose '2' for Binary Search,");
				System.out.println("Choose '3' for Interpolation Search,");
				System.out.println("Choose '4' for Red-Black Tree,");
				System.out.println("Choose '5' for Digital Trie,");
				System.out.println("Choose '6' for 1000 Random Searches Menu.");
				System.out.println("");
				System.out.println("Choose '0' to end the program!");
				//@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				choise = input.nextLine();

				switch (choise) {

					case "0":
						System.out.println("");
						System.out.println("");
						System.out.println("Now the program will end!");

						try {
							Thread.sleep(2000);

						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}

						System.out.println(".");

						try {
							Thread.sleep(2000);

						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}

						System.out.println(".");

						try {
							Thread.sleep(2000);

						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}

						System.out.println(".");

						try {
							Thread.sleep(2000);

						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}
						System.out.println("! ! ! END OF PROGRAM ! ! !");
						return;

					case "1":
						System.out.println("Go with Serial Search!");
						System.out.println("");
						System.out.println("(Enter 1 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						//item = scan.nextInt();
						item = scan.nextLine();
						while (item.equals("1")) {
							long start1 = System.nanoTime();
							ss.serialSearch(inputArray, inputArray.length);
							long end1 = System.nanoTime();
							long timeInMillis1 = TimeUnit.MILLISECONDS.convert(end1 - start1, TimeUnit.NANOSECONDS);
							System.out.println("Time spend in ms: " + timeInMillis1);
							System.out.println("");
							System.out.println("");
							System.out.println("(Enter 1 to Continue with Serial Search)");
							System.out.println("(Enter any other number to Abort!!!)");
							//item = scan.nextInt();
							item = scan.nextLine();
						}
						System.out.println("Choose to abort Serial Search.");
						System.out.println("");
						System.out.println("");
						break;

					case "2":
						System.out.println("Go with Binary Search!");
						System.out.println("");
						System.out.println("(Enter 2 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						//item = scan.nextInt();
						item = scan.nextLine();
						while (item.equals("2")) {
							long start2 = System.nanoTime();
							bs.binarySearch(inputArray, inputArray.length);
							long end2 = System.nanoTime();
							long timeInMillis2 = TimeUnit.MILLISECONDS.convert(end2 - start2, TimeUnit.NANOSECONDS);
							System.out.println("Time spend in ms: " + timeInMillis2);
							System.out.println("");
							System.out.println("");
							System.out.println("(Enter 2 to Continue with  Binary Search)");
							System.out.println("(Enter any other number to Abort!!!)");
							//item = scan.nextInt();
							item = scan.nextLine();
						}
						System.out.println("Choose to abort Binary Search.");
						System.out.println("");
						System.out.println("");
						break;

					case "3":
						System.out.println("Go with Interpolation Search!");
						System.out.println("");
						System.out.println("(Enter 3 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						//item = scan.nextInt();
						item = scan.nextLine();
						while (item.equals("3")) {
							long start3 = System.nanoTime();
							is.interpolationSearch(inputArray, inputArray.length);
							long end3 = System.nanoTime();
							long timeInMillis3 = TimeUnit.MILLISECONDS.convert(end3 - start3, TimeUnit.NANOSECONDS);
							System.out.println("Time spend in ms: " + timeInMillis3);
							System.out.println("");
							System.out.println("");
							System.out.println("(Enter 3 to Continue with Interpolation Search)");
							System.out.println("(Enter any other number to Abort!!!)");
							//item = scan.nextInt();
							item = scan.nextLine();
						}
						System.out.println("Choose to abort Interpolation Search.");
						System.out.println("");
						System.out.println("");
						break;

					case "4":
						for (Integer i : inputArray) {
							rbt.createNode(i);
						}
						System.out.println("Go with Red-Black Tree!");
						System.out.println("");
						System.out.println("(Enter 4 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						//item = scan.nextInt();
						item = scan.nextLine();
						while (item.equals("4")) {
							// long start4 = System.nanoTime();
							rbt.CUI();
							// long end4 = System.nanoTime();
							// long timeInMillis4 =
							// TimeUnit.MILLISECONDS.convert(end4 - start4,
							// TimeUnit.NANOSECONDS);
							// System.out.println("Time spend in ms: " +
							// timeInMillis4);
							System.out.println("");
							System.out.println("");
							System.out.println("(Enter 4 to Continue with Red-Black Tree)");
							System.out.println("(Enter any other number to Abort!!!)");
							//item = scan.nextInt();
							item = scan.nextLine();
						}
						System.out.println("Choose to abort Red-Black Tree.");
						System.out.println("");
						System.out.println("");
						break;

					case "5":
						for (String i : inputArrayTxt) {
							dt.insert(i);
						}
						System.out.println("Go with Digital Trie!");
						System.out.println("");
						System.out.println("(Enter 5 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						//item = scan.nextInt();
						item = scan.nextLine();
						while (item.equals("5")) {
							dt.CUI();
							System.out.println("");
							System.out.println("");
							System.out.println("(Enter 5 to Continue with Digital Trie)");
							System.out.println("(Enter any other number to Abort!!!)");
							//item = scan.nextInt();
							item = scan.nextLine();
						}
						System.out.println("Choose to abort Digital Trie.");
						System.out.println("");
						System.out.println("");
						break;

					case "6":
						Random rand = new Random();
						System.out.println("Go with 1000 Random Searches!");
						System.out.println("");
						System.out.println("(Enter 6 again to Continue)");
						System.out.println("(Enter any other number to Abort!!!)");
						int item2 = -1;
						int choise2;
						item2 = scan.nextInt();
						while (item2 == 6) {
							System.out.println("");
							System.out.println("");
							System.out.println("         1000 Random Searches Menu!");
							System.out.println("Choose '1' for 1000 Random Searches on Serial Search,");
							System.out.println("Choose '2' for 1000 Random Searches on Binary Search,");
							System.out.println("Choose '3' for 1000 Random Searches on Interpolation Search,");
							System.out.println("Choose '4' for 1000 Random Searches on Red-Black Tree.");
							System.out.println("");
							@SuppressWarnings("resource")
							Scanner input2 = new Scanner(System.in);
							choise2 = input2.nextInt();
							switch (choise2) {
								case 1:
									for (int b = 0; b < 1000; b++) {
										item2 = rand.nextInt(1000000);
										long start5 = System.nanoTime();
										ss.randomSerialSearch(inputArray, inputArray.length, item2);
										long end5 = System.nanoTime();
										long timeInMillis5 = TimeUnit.MILLISECONDS.convert(end5 - start5,
												TimeUnit.MILLISECONDS);
										System.out.println("Time spend in ns: " + timeInMillis5);

										outSerial.println("Random number: " + item2 + " Time: " + timeInMillis5);
									}
									outSerial.close();
									break;

								case 2:
									for (int b = 0; b < 1000; b++) {
										item2 = rand.nextInt(1000000);
										long start6 = System.nanoTime();
										bs.randomBinarySearch(inputArray, inputArray.length, item2);
										long end6 = System.nanoTime();
										long timeInMillis6 = TimeUnit.MILLISECONDS.convert(end6 - start6,
												TimeUnit.MILLISECONDS);
										System.out.println("Time spend in ns: " + timeInMillis6);

										outBinary.println("Random number: " + item2 + " Time: " + timeInMillis6);
									}
									outBinary.close();
									break;

								case 3:
									for (int b = 0; b < 1000; b++) {
										item2 = rand.nextInt(1000000);
										long start7 = System.nanoTime();
										is.randomInterpolationSearch(inputArray, inputArray.length, item2);
										long end7 = System.nanoTime();
										long timeInMillis7 = TimeUnit.MILLISECONDS.convert(end7 - start7,
												TimeUnit.MILLISECONDS);
										System.out.println("Time spend in ns: " + timeInMillis7);

										outInterpolation.println("Random number: " + item2 + " Time: " + timeInMillis7);
									}

									outInterpolation.close();
									break;

								case 4:
									for (Integer i : inputArray) {
										rbt.createNode(i);
									}
									for (int b = 0; b < 1000; b++) {
										item2 = rand.nextInt(1000000);
										long start8 = System.nanoTime();
										rbt.randomCUI(item2);
										long end8 = System.nanoTime();
										long timeInMillis8 = TimeUnit.MILLISECONDS.convert(end8 - start8,
												TimeUnit.MILLISECONDS);
										System.out.println("Time spend in ns: " + timeInMillis8);

										outRedBlack.println("Random number: " + item2 + " Time: " + timeInMillis8);
									}
									outRedBlack.close();
							}
						}
						System.out.println("Choose to abort 1000 Random Searches.");
						System.out.println("");
						System.out.println("");
						break;
					default:
						System.out.println("Invalid input");
						break;
				}
			}

		} catch (

		IOException ie) {
			System.out.print(ie.getMessage());
		}
	}





}
