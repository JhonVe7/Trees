package Uri_1520;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		File file = new File("1520.txt");
		
		Scanner scanner = new Scanner(file);
		List<Integer> integers = new ArrayList<>();
		List<Integer> bt2 = new ArrayList<>();
		ArrayList<Integer> indices = new ArrayList<>();
		int counter = 1;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				integers.add(scanner.nextInt());
			} else {
				scanner.next();
			}
		}
		scanner.close();
		int testcase = Integer.parseInt(integers.get(0).toString());
		int postosearch = testcase * 2 + 1;
		int tosearch = Integer.parseInt(integers.get(testcase * 2 + 1).toString());

		while (postosearch <= integers.size()) {

			for (int i = 0; i < testcase; i++) {
				for (int j = integers.get(counter); j <= integers.get(counter + 1); j++) {
					bt2.add(j);
				}
				counter = counter + 2;
			}

			Collections.sort(bt2);

			for (int i = 0; i < bt2.size(); i++) {
				if (bt2.get(i) == tosearch) {
					indices.add(i);
				}
			}

			if (bt2.contains(tosearch)) {
				bw.write(tosearch + " found from " + indices.get(0) + " to " + indices.get(indices.size() - 1) + "\n");
				bw.flush();
			} else {
				bw.write(tosearch + " not found \n");
				bw.flush();
			}
			indices = new ArrayList<>();
			bt2 = new ArrayList<>();
			counter = postosearch + 2;
			if (counter >= integers.size()) {
				break;
			}
			testcase = Integer.parseInt(integers.get(counter - 1).toString());
			postosearch = testcase * 2 + postosearch + 2;
			tosearch = Integer.parseInt(integers.get(postosearch).toString());
		}
	}

}
