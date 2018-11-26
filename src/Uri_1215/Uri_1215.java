
package Uri_1215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import Trees.BinaryTree;
import Trees.BinaryNodeExample;
public class Uri_1215{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
	
	static BinaryTree bt = new BinaryTree();

	public static void readText(String text) {
		
		String aux = "";
		String [] letters = text.split(" ") ;
		
		for(int i = 0 ; i <= letters.length ;i++) {
			aux = letters[i];
			bt.insert(new BinaryNodeExample(aux));
		}	
	}
	
	public static void printLettersTree() {
		bt.inorder(bt.root);
	}
	public static void main(String[] args) {
		
		try {
			
			// enter the text and convert it to lowercase. 
			bw.write("Ex (* $ a # .mpl.e:");
			bw.flush();
			String input = br.readLine();
			String text = input.toLowerCase(); 
			bw.write(text);
		
			while (text != null) {
				readText(text);	
				printLettersTree();
			}
			
		} catch (Exception ex) {}
	}
}
