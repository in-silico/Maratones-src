import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class F 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static int t1, t2;
	static String a1, a2, a3;
	
	static class Persona
	{
		ArrayList <Persona> amigos = new ArrayList <Persona> ();
		String nombre;
		boolean visitado = false;
		String atributos = "";
		
		void visitar()
		{
			if(visitado)
				return;
			visitado = true;
			int nAmigos = amigos.size();
			if(nAmigos < t1)
				atributos += a1;
			else if(nAmigos >= t2)
				atributos += a3;
			else
				atributos += a2;
			atributos += " ";
			for(Persona a : amigos)
				a.visitar();
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
			Persona[] personas = new Persona[n + 1];
			for(int i = 1; i <= n; i++)
				personas[i] = new Persona();
			for(int i = 1; i <= n; i++)
			{
				while(true)
				{
					int amigo = sc.nextInt();
					if(amigo == 0)
						break;
					personas[i].amigos.add(personas[amigo]);
				}
			}
			while(true)
			{
				int p = sc.nextInt();
				if(p == 0)
					break;
				t1 = sc.nextInt();
				t2 = sc.nextInt();
				a1 = sc.next();
				a2 = sc.next();
				a3 = sc.next();
				for(int i = 1; i <= n; i++)
					personas[i].visitado = false;
				personas[p].visitar();
				for(int i = 1; i <= n; i++)
					if(!personas[i].visitado)
						personas[i].atributos += a1 + " ";
			}
			for(int i = 1; i <= n; i++)
				System.out.println(sc.next() + ": " + personas[i].atributos);
		}
	}

}
