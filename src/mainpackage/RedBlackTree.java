package mainpackage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RedBlackTree {

	private final int RED = 0;
	private final int BLACK = 1;

	private class Node {
		int key = -1, color = BLACK;
		Node left = nil, right = nil, parent = nil;

		Node(int key) {
			this.key = key;
		}
	}

	private final Node nil = new Node(-1);
	private Node root = nil;

	public void createNode(int node) {
		Node Zisis = new Node(0);
		Zisis.key = node;
		Zisis.left = Zisis.right = nil;
		Zisis.color = RED;
		this.insertNode(Zisis);
	}

	public void printTree(Node node) {
		if (node == nil) {
			return;
		}
		printTree(node.left);
		System.out.println(((node.color == RED) ? "Color: Red " : "Color: Black ") + "Key: " + node.key + " Parent: "
				+ node.parent.key);
		printTree(node.right);
	}

	private Node findNode(Node findNode, Node node) {
		if (root == nil) {
			return null;
		}
		if (findNode.key < node.key) {
			if (node.left != nil) {
				return findNode(findNode, node.left);
			}
		} else if (findNode.key > node.key) {
			if (node.left != nil) {
				return findNode(findNode, node.right);
			}
		} else if (findNode.key == node.key) {
			return node;
		}
		return null;
	}

	private void insertNode(Node node) {
		Node temp = root;
		if (root == nil) {
			root = node;
			node.color = BLACK;
			node.parent = nil;
		} else {
			node.color = RED;
			while (true) {
				if (node.key < temp.key) {
					if (temp.left == nil) {
						temp.left = node;
						node.parent = temp;
						break;
					} else {
						temp = temp.left;
					}
				} else if (node.key >= temp.key) {
					if (temp.right == nil) {
						temp.right = node;
						node.parent = temp;
						break;
					} else {
						temp = temp.right;
					}
				}
			}
			fixTree(node);
		}
	}

	private void fixTree(Node node) {
		while (node.parent.color == RED) {
			Node uncle = nil;
			if (node.parent == node.parent.parent.left) {
				uncle = node.parent.parent.right;

				if (uncle != nil && uncle.color == RED) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
					continue;
				}
				if (node == node.parent.right) {
					node = node.parent;
					rotateLeft(node);
				}
				node.parent.color = BLACK;
				node.parent.parent.color = RED;
				rotateRight(node.parent.parent);
			} else {
				uncle = node.parent.parent.left;
				if (uncle != nil && uncle.color == RED) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
					continue;
				}
				if (node == node.parent.left) {
					node = node.parent;
					rotateRight(node);
				}
				node.parent.color = BLACK;
				node.parent.parent.color = RED;
				rotateLeft(node.parent.parent);
			}
		}
		root.color = BLACK;
	}

	void rotateLeft(Node node) {
		if (node.parent != nil) {
			if (node == node.parent.left) {
				node.parent.left = node.right;
			} else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
			node.parent = node.right;
			if (node.right.left != nil) {
				node.right.left.parent = node;
			}
			node.right = node.right.left;
			node.parent.left = node;
		} else {
			Node right = root.right;
			root.right = right.left;
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = nil;
			root = right;
		}
	}

	void rotateRight(Node node) {
		if (node.parent != nil) {
			if (node == node.parent.left) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;
			}

			node.left.parent = node.parent;
			node.parent = node.left;
			if (node.left.right != nil) {
				node.left.right.parent = node;
			}
			node.left = node.left.right;
			node.parent.right = node;
		} else {
			Node left = root.left;
			root.left = root.left.right;
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = nil;
			root = left;
		}
	}

	/*
	 * public void treeChecker() { if (root.color == BLACK && root.left.color ==
	 * BLACK && root.right.color == BLACK) {
	 * System.out.println("Red-Black Tree has loaded correctly!"); } }
	 */

	public void CUI() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int item = -1;
		// while (item != -999) {
		System.out.println("\n\nRed-Black Tree Menu!");
		System.out.println("Choose '1' to Add items,");
		System.out.println("Choose '2' to Check items,");
		System.out.println("Choose '3' to Print tree.\n");
		// System.out.println("4. - Tree Details\n");
		System.out.println("Choose '0' to Abort Red-Black Tree!");

		int choice = scan.nextInt();

		// int item;
		Node node;
		switch (choice) {
		case 0:
			System.out.println("");
			System.out.println("");
			System.out.println("Now you abort Red-Black Tree!");
			return;
		case 1:
			System.out.println("You choose '1' so as to add numbers to current Tree.");
			System.out.println("Add as many numbers as you want,");
			System.out.println("to abort adding numbers type the number '-999'");
			System.out.println("and you will return to Red-Black Tree Menu!");
			item = scan.nextInt();
			while (item != -999) {
				node = new Node(item);
				insertNode(node);
				System.out.println("Number: " + item + " successfully added!");
				System.out.println("Add another number or type '-999' to abort");
				item = scan.nextInt();
			}
			System.out.println("As you added numbers the Tree has changed.");
			System.out.println("Now the Tree will reload!");
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
			printTree(root);
			System.out.println("\n\nThis is the new Tree with the numbers you just added");
			break;
		case 2:
			System.out.println("You choose '2' so as to check numbers on the current Tree.");
			System.out.println("Check as many numbers as you want,");
			System.out.println("to abort checking numbers type the number '-999'");
			System.out.println("and you will return to Red-Black Tree Menu!");
			item = scan.nextInt();
			while (item != -999) {
				long startRBT = System.nanoTime();
				node = new Node(item);
				System.out.println((findNode(node, root) != null) ? "found" : "not found");
				long endRBT = System.nanoTime();
				long timeInMillisRBT = TimeUnit.MILLISECONDS.convert(endRBT - startRBT, TimeUnit.MILLISECONDS);
				System.out.println("Time spend in ns: " + timeInMillisRBT);
				System.out.println("Check another number or type '-999' to abort");
				item = scan.nextInt();
			}
			break;
		case 3:
			printTree(root);
			break;
		/*
		 * case 4:
		 * System.out.println("Check if Red-Black Tree has loaded correctly");
		 * System.out.print("Answer: "); treeChecker();
		 * System.out.println("And check the Root of the sorted Red-Black Tree"
		 * ); System.out.print("Answer: "); System.out.println(root.key); break;
		 */
		default:
			System.out.println("Invalid input");
			break;
		}
		// }
	}

	public void randomCUI(int e) {
		Node node = new Node(e);
		System.out.println((findNode(node, root) != null) ? "found" : "not found");
	}
}
