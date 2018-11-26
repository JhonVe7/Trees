package Uri_1520;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



public class Uri_1520{
	public static void Main(String[] args){
		int n;
		int m;
		int x;
		int y;
		 BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		while ((scanf("%d", n) == 1)){
			
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> num = new ArrayList<Integer>(101);
			fill(a.iterator(),a.end(),0);
			while (n-- != 0){
				
				String tempVar = br.readLine();
				if (tempVar != null)
				{
					x = Integer.parseInt(tempVar);
				}
				String tempVar2 = br.readLine();
				if (tempVar2 != null)
				{
					y = Integer.parseInt(tempVar2);
				}
				for (int i = x;i <= y;i++)
				{
					a.add(i);
					num.get(i)++;
				}
			}
			Collections.sort(a);
				String tempVar3 = br.readLine();
				if (tempVar3 != null)
				{
					x = Integer.parseInt(tempVar3);
				}
				if (num.get(x) == 0)
				{
				System.out.printf("%d not found\n",x);
				}
				else
				{
					int in;
					for (int i = 0;i < a.size();i++)
					{
						if (a.get(i) == x)
						{
							in = i;
							break;
						}
					}
					System.out.printf("%d found from %d to %d\n",x,in,in + num.get(x) - 1);
				}
		}
	}
}

