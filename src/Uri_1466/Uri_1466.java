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
	
	static BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
	
	static BinaryTree bt = new BinaryTree();
	static List list = new List();
	static int cont = 0, GNQ = 0 ;
	
	
	public static void treeNumbers(String input) throws IOException {
		
		String [] charaters = input.split(" ") ;

		for (int i = 0; i < charaters.length; i++) {
			cont++;
			bt.insert(new BinaryNodeExample(Integer.parseInt(charaters[i])));
		}
		if (cont != GNQ) {
			bw.write("the size it´s not the same");
			bw.flush();
		}
		else {
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		//numbers of cases
		
		String Cases = br.readLine();
		int	cases = Integer.parseInt(Cases);
		
		String NQ ="", input = "";
		int numbersQuantity = 0;
		
		//process  with trees 
			
		for (int i = 0; i < cases ; i++) {
		
			
		NQ = br.readLine();
		numbersQuantity = Integer.parseInt(NQ);
		GNQ =numbersQuantity;
				
		input = br.readLine();	  
				
			while (input != null) {	
				
				treeNumbers(input);
				
				bw.write("case: "+ i);
				bw.flush();
				
				
			
			}
		}
		
		
	}
}
