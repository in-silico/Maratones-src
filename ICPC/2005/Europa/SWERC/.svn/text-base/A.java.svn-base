import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class A 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader("a.in"));
		}
		
		public int nextInt() throws IOException
		{

				if(st == null || !st.hasMoreElements())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
		}
	}
	
	static class Nodo
	{
		ArrayList <Integer> vecinos = new ArrayList <Integer> ();
		int n;
		boolean visitado = false;
		
		public Nodo(int nn)
		{
			n = nn;
		}
	}
	
	static class Entrada
	{
		int n;
		int ruta;
		
		public Entrada(int n, int ruta)
		{
			this.n = n;
			this.ruta = ruta;
		}
	}

	static Nodo[] todos = new Nodo[100001];
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i <= n; i++)
				todos[i] = new Nodo(i);
			for(int i = 0; i < n; i++)
			{
				int este = sc.nextInt();
				int numero = sc.nextInt();
				for(int j = 0; j < numero; j++)
					todos[este].vecinos.add(sc.nextInt());
			}
			int a = sc.nextInt();
			int b = sc.nextInt();
			LinkedList <Entrada> lista = new LinkedList <Entrada> ();
			lista.add(new Entrada(a, 0));
			while(true)
			{
				Entrada actual = lista.poll();
				todos[actual.n].visitado = true;
				if(actual.n == b)
				{
					System.out.println(a + " " + b + " " + (actual.ruta - 1));
					break;
				}
				for(int i : todos[actual.n].vecinos)
				{
					if(!todos[i].visitado)
					{
						todos[i].visitado = true;
						lista.add(new Entrada(i, actual.ruta + 1));
					}
				}
			}
		}
	}

}
