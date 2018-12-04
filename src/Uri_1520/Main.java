package Uri_1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import LinearDataStructures.ExampleNode;
import LinearDataStructures.List;
import Trees.BinaryTree;
import Uri_1520.BinaryNodeExample;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List list = new List();
	static BinaryTree bt = new BinaryTree();

	public static void campos(int min, int max) {
		for (int i = min; i <= max; i++) {
			list.insertAtBegin(new ExampleNode(i));
			list.indexOf(new ExampleNode(i));
		}
	}

	public static void main(String[] args) {

		try {
			int min = 0;
			int max = 0;
			String input = "";
			String numbs[];
			int cases = Integer.parseInt(br.readLine());
			for (int i = 0; i < cases; i++) {

				input = br.readLine();
				numbs = input.split(" ");
				min = Integer.parseInt(numbs[0]);
				max = Integer.parseInt(numbs[1]);
				bt.insert(new BinaryNodeExample(min, max));
				campos(min, max);
			}
			list.quickSort(list);
			list.printList();
		} catch (IOException e) {
		}
	}

}
