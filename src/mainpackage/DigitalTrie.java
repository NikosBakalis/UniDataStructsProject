package mainpackage;

import java.util.HashMap;
import java.util.Scanner;

public class DigitalTrie extends mainClass {

	mainClass mc = new mainClass();

	private TrieNode root;

	public DigitalTrie() {
		root = new TrieNode();
		root.setParent(new TrieNode());
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.getChildren();

		TrieNode p = root;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t = null;

			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
				t.setParent(p);
			}
			p = t;
			children = t.getChildren();

			if (i == word.length() - 1) {
				t.setLeaf(true);
			}
		}
	}

	public boolean delete(String word) {
		TrieNode t = searchNode(word);

		// word is present if t is not null & is leaf as t is a trie node for
		// last character from word
		if (t != null && t.isLeaf()) {

			TrieNode p = t.getParent();
			char c = t.getCharacter();

			// removing children of parent if only one child is present
			while (p.getChildren().size() == 1) {
				p.resetChildren();
				t = p;
				c = t.getCharacter();
				p = t.getParent();
			}

			// removing the remaining character
			char delete = c;
			p.getChildren().entrySet().removeIf(e -> e.getKey().equals(delete));

			return true;
		}
		return false;
	}

	public boolean search(String word) {
		TrieNode t = searchNode(word);

		// word is present if t is not null & is leaf as t is a trie node for
		// last character from word
		if (t != null && t.isLeaf()) {
			return true;
		}

		return false;
	}

	public boolean startsWith(String prefix) {
		HashMap<Character, TrieNode> children = root.getChildren();

		TrieNode t = null;

		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (children.containsKey(c)) {

				t = children.get(c);
				children = t.getChildren();

			} else {
				// character mismatch
				return false;
			}
		}

		// reached the end of the prefix word
		return true;
	}

	// helper method for searching & delete functions
	private TrieNode searchNode(String word) {
		HashMap<Character, TrieNode> children = root.getChildren();

		TrieNode t = null;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (children.containsKey(c)) {

				t = children.get(c);
				children = t.getChildren();

			} else {
				// character mismatch
				return null;
			}
		}

		// reached the end of the search word
		return t;
	}



	@SuppressWarnings("resource")
	String item = "";

	public void CUI() throws Exception{
		Scanner scan = new Scanner(System.in);



		// while (!item.equals("Exit me")) {
		System.out.println("\n\nDigital Trie Menu!");
		System.out.println("Choose 1 to Check items,");
		System.out.println("Choose 2 to Add items,");
		System.out.println("Choose 3 to Delete items.\n");
		System.out.println("Choose '0' to Abort Digital Trie!");

		String choice = scan.nextLine();

		switch (choice) {
		case "0":
			System.out.println("");
			System.out.println("");
			System.out.println("Now you abort Digital Trie!");
			//item = scan.nextLine();
			//return;
			//break;
			String[] arguments = new String[] {""};
			mc.main(arguments);
			break;

		case "1":
			item = scan.nextLine();

			while (!item.equals("Exit me")) {
				System.out.println((search(item)) ? "Found! Enter 'Exit me' to abort Item checking" : "Not found! Enter 'Exit me' to abort Item checking");
				item = scan.nextLine();
			}
			// System.exit(0);
			CUI();
			break;

		case "2":
			item = scan.nextLine();
			while (!item.equals("Exit me")) {
				insert(item);
				System.out.println("Inserted! Enter 'Exit me' to abort Item insertion");
				item = scan.nextLine();
			}
			// System.exit(0);
			CUI();
			break;

		case "3":
			item = scan.nextLine();
			while (!item.equals("Exit me")) {
				delete(item/*.toString()*/);
				System.out.println("Deleted! Enter 'Exit me' to abort Item deletion");
				item = scan.nextLine();
			}
			// System.exit(0);
			CUI();
			break;

		default:
			System.out.println("Invalid input");
			CUI();
			break;
		}
		scan.close();
		// }
		// System.exit(0);
	}
}

class TrieNode {
	private char character;
	private TrieNode parent;
	private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	private boolean leaf;

	public TrieNode() {

	}

	public TrieNode(char character) {
		this.character = character;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public TrieNode getParent() {
		return parent;
	}

	public void setParent(TrieNode parent) {
		this.parent = parent;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void resetChildren() {
		children = new HashMap<Character, TrieNode>();
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
}
