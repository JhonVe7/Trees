package Uri_1466;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Trees.BinaryNodeExample;
import Trees.BinaryTree;
import LinearDataStructures.List;

public class Uri_1466 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static BinaryTree bt = new BinaryTree();
	static List list = new List();
	static int cont = 0, GNQ = 0;

	public static void treeNumbers(String input) throws IOException {

		String[] charaters = input.split(" ");

		for (int i = 0; i < charaters.length; i++) {
			cont++;
			bt.insert(new BinaryNodeExample(Integer.parseInt(charaters[i])));	
		}
		bt.levels(bt.root);
	}

	public static void main(String[] args) throws IOException {

		// numbers of cases

		int Cases = Integer.parseInt(br.readLine());
		int numbersQuantity = 0;
		String input = "";
		// process with trees

		for (int i = 0; i < Cases; i++) {

			numbersQuantity = Integer.parseInt(br.readLine());
			GNQ = numbersQuantity;

			input = br.readLine();

			while (input != null) {

				treeNumbers(input);

				bw.write("case: " + i);
				bw.flush();

			}
		}

	}
}
