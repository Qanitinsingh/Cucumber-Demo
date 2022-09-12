package learn.java;

import java.util.ArrayList;

public class CollectionPractice {

	// Null will be also included in the array list

	// Null is also allowed in the generic array list

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Nitin");
		list.add("Nikhil");
		list.add("Arti");

		for (String result : list) {

			System.out.println(result);
		}

	}
}
