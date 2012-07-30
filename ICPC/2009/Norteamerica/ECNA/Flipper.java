import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Flipper 
{
	static class Carta
	{
		int n;
		boolean up;
		
		public Carta(int nn)
		{
			n = nn;
		}
		
		@Override
		public String toString() {
			return n + " " + (up ? "U" : "D");
		}
	}
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("c.in"));
		System.setOut(new PrintStream("csa.out"));
		Carta[] cartas = new Carta[101];
		for(int i = 1; i < 101; i++)
			cartas[i] = new Carta(i);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nPila = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			int act = 1;
			for(char c : br.readLine().toCharArray())
			{
				cartas[act++].up = c == 'U';
			}
			LinkedList < LinkedList <Carta> > pilas = new LinkedList < LinkedList <Carta> > ();
			for(int i = 1; i <= n; i++)
			{
				LinkedList <Carta> actual = new LinkedList <Carta> ();
				actual.add(cartas[i]);
				pilas.add(actual);
			}
			for(char c : br.readLine().toCharArray())
			{
				if(c == 'R')
				{
					ListIterator < LinkedList <Carta> > it = pilas.listIterator(pilas.size() - 1);
					LinkedList <Carta> anterior = it.previous();
					it.next();
					LinkedList <Carta> actual = it.next();
					while(!actual.isEmpty())
					{
						anterior.push(actual.pollFirst());
						anterior.getFirst().up = !anterior.getFirst().up;
					}
					it.remove();
				}
				else
				{
					ListIterator < LinkedList <Carta> > it = pilas.listIterator();
					LinkedList <Carta> actual = it.next();
					LinkedList <Carta> anterior = it.next();
					while(!actual.isEmpty())
					{
						anterior.push(actual.pollFirst());
						anterior.getFirst().up = !anterior.getFirst().up;
					}
					it.previous();
					it.previous();
					it.remove();
				}
			}
			System.out.println("Pile " + nPila++);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int i = 0; i < m; i++)
			{
				int iActual = Integer.parseInt(st.nextToken());
				int indice = 1;
				for(Carta c : pilas.get(0))
				{
					if(indice == iActual)
					{
						if(c.up)
							System.out.println("Card " + iActual + " is a face up " + c.n + ".");
						else
							System.out.println("Card " + iActual + " is a face down " + c.n + ".");
						break;
					}
					indice++;
				}
					
			}
		}
	}
}
