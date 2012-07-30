import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class C
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st = null;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public int nextInt()
		{
			try
			{
				while(st == null || !st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
	}
	
	static class Nadador
	{
		int vFaltantes;
		int tiempo;
		int tiempoAdq;
		int pos;
	}
	
	static LinkedList <Nadador> carril1 = new LinkedList <Nadador> ();
	static LinkedList <Nadador> carril2 = new LinkedList <Nadador> ();
	static LinkedList <Nadador> carril1N = new LinkedList <Nadador> ();
	static LinkedList <Nadador> carril2N = new LinkedList <Nadador> ();
	
	public static int simular()
	{
		int tiempo = 0;
		while(true)
		{
			carril1N.clear();
			Collections.reverse(carril1);
			for(Nadador n : carril1)
			{
				Nadador posible = carril1N.peekFirst();
				if(posible == null)
				{
					n.pos++;
					carril1N.addFirst(n);
					continue;
				}
				int posA = posible.tiempoAdq * (n.pos + 1);
				int posB = n.tiempoAdq * (posible.pos);
				if(posA >= posB)
				{
					n.tiempoAdq = posible.tiempoAdq;
					n.pos = posible.pos;
					carril1N.addFirst(n);
				}
				else
				{
					n.pos++;
					carril1N.addFirst(n);
				}
			}
			carril2N.clear();
			Collections.reverse(carril2);
			for(Nadador n : carril2)
			{
				Nadador posible = carril2N.peekFirst();
				if(posible == null)
				{
					n.pos++;
					carril2N.addFirst(n);
					continue;
				}
				int posA = posible.tiempoAdq * (n.pos + 1);
				int posB = n.tiempoAdq * (posible.pos);
				if(posA >= posB)
				{
					n.tiempoAdq = posible.tiempoAdq;
					n.pos = posB;
					n.pos = posible.pos;
					carril2N.addFirst(n);
				}
				else
				{
					n.pos++;
					carril2N.addFirst(n);
				}
			}
			LinkedList <Nadador> temp = carril1;
			carril1 = carril1N;
			carril1N = temp;			
			temp = carril2;
			carril2 = carril2N;
			carril2N = temp;
			while(!carril1.isEmpty() && carril1.peekLast().pos == carril1.peekLast().tiempoAdq)
			{
				Nadador n = carril1.pollLast();
				n.tiempoAdq = n.tiempo;
				n.pos = 0;
				ListIterator <Nadador> siguiente = carril2.listIterator();
				while(true)
				{
					if(!siguiente.hasNext())
					{
						siguiente.add(n);
						break;
					}
					Nadador sig = siguiente.next();
					if(sig.pos != 0 || sig.tiempoAdq < n.tiempoAdq)
					{
						siguiente.previous();
						siguiente.add(n);
						break;
					}
				}
			}
			while(!carril2.isEmpty() && carril2.peekLast().pos == carril2.peekLast().tiempoAdq)
			{
				Nadador n = carril2.pollLast();
				n.tiempoAdq = n.tiempo;
				n.pos = 0;
				n.vFaltantes--;
				if(n.vFaltantes == 0)
					continue;
				ListIterator <Nadador> siguiente = carril1.listIterator();
				while(true)
				{
					if(!siguiente.hasNext())
					{
						siguiente.add(n);
						break;
					}
					Nadador sig = siguiente.next();
					if(sig.pos != 0 || sig.tiempoAdq < n.tiempoAdq)
					{
						siguiente.previous();
						siguiente.add(n);
						break;
					}
				}
			}
			tiempo++;
			if(carril1.isEmpty() && carril2.isEmpty())
			{
				return tiempo;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			carril1.clear();
			carril2.clear();
			carril1N.clear();
			carril2N.clear();
			for(int i = 0; i < n; i++)
			{
				Nadador nuevo = new Nadador();
				nuevo.tiempo = sc.nextInt();
				nuevo.tiempoAdq = nuevo.tiempo;
				nuevo.vFaltantes = sc.nextInt();
				nuevo.pos = 0;
				ListIterator <Nadador> siguiente = carril1.listIterator();
				while(true)
				{
					if(!siguiente.hasNext())
					{
						siguiente.add(nuevo);
						break;
					}
					Nadador sig = siguiente.next();
					if(sig.pos != 0 || sig.tiempoAdq < nuevo.tiempoAdq)
					{
						siguiente.previous();
						siguiente.add(nuevo);
						break;
					}
				}
			}
			System.out.println(simular());
		}
	}
}
