package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Item {

	private String name;
	private int amount;

	public Item(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

	public static Item random() {
		LinkedList<String> adjectives = new LinkedList<String>();
		LinkedList<String> swords = new LinkedList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("rsc/words/adjectives.txt"));
		while(scanner.hasNext())
			adjectives.add(scanner.nextLine());
		scanner.close();
		scanner = new Scanner(new File("rsc/words/swords.txt"));
		while(scanner.hasNext())
			swords.add(scanner.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();
		return new Item(adjectives.get((int) (Math.random() * adjectives.size())) + " " + swords.get((int) (Math.random() * swords.size())), 1);
	}

	@Override
	public String toString() {
		return name + " " + (amount > 1 ? amount : "");
	}
}
