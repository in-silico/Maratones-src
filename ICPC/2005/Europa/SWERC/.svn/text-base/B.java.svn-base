import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class B 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader("b.in"));
		}
		
		public int nextInt() throws IOException
		{

				if(st == null || !st.hasMoreElements())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
		}
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		LinkedList <Integer> lista = new LinkedList <Integer> ();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int l = sc.nextInt();
			lista.clear(); 
			for(int i = 0; i < n; i++)
				lista.add(sc.nextInt());
			Collections.sort(lista);
			int q = 0;
			while(lista.size() > 1)
			{
				int mayor = lista.pollLast();
				int menor = lista.pollFirst();
				if(mayor + menor > l)
				{
					q++;
					lista.addFirst(menor);
				}
				else
					q++;
			}
			q += lista.size();
			System.out.println(q);
		}
	}
}