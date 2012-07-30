import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class E
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class Respuesta
	{
		int cuenta;
		int cuantos;
		
		public Respuesta(int cu, int cua)
		{
			cuenta = cu;
			cuantos = cua;
		}
	}
	
	static class Nodo
	{
		int nConexiones;
		Nodo[] conexiones = new Nodo[3];
		Integer inicio;
		Respuesta[] respuestas = new Respuesta[3];
		boolean trampa;
		Boolean quedan;
		
		public int visitarInicio(Nodo anterior) 
		{
			if(inicio != null)
				return inicio;
			if(anterior == null)
				return conexiones[0].visitarInicio(this);
			if(trampa)
				return inicio = 0;
			if(nConexiones == 1)
				return 1;
			int indice = 0;
			for(int i = 0; i < nConexiones; i++)
				if(conexiones[i] == anterior)
					indice = i;
			if(nConexiones == 2)
				return inicio = conexiones[(indice + 1) % 2].visitarInicio(this);
			Nodo izquierdo = conexiones[(indice + 1) % 3];
			Nodo derecho = conexiones[(indice + 2) % 3];
			int cuentaA = izquierdo.visitarInicio(this);
			int cuentaB = derecho.visitarInicio(this);
			int peorCuenta = cuentaA + cuentaB;
			Respuesta posible = visitar(anterior, 2);
			if(posible.cuenta == -1)
				return inicio = peorCuenta;
			else
				return inicio = posible.cuantos + 1;

		}

		public Respuesta visitar(Nodo anterior, int cuenta)
		{
			if(respuestas[cuenta] != null)
				return respuestas[cuenta];
			if(trampa)
				return respuestas[cuenta] = new Respuesta(-1, 0);
			if(nConexiones == 1)
				return new Respuesta(cuenta, 0);
			int indice = 0;
			for(int i = 0; i < nConexiones; i++)
				if(conexiones[i] == anterior)
					indice = i;
			if(nConexiones == 2)
				return respuestas[cuenta] = conexiones[(indice + 1) % 2].visitar(this, cuenta);
			Nodo izquierdo = conexiones[(indice + 1) % 3];
			Nodo derecho = conexiones[(indice + 2) % 3];
			if(cuenta == 1)
			{
				Respuesta cuentaDerechoB = derecho.visitar(this, 1);
				Respuesta cuentaIzquierdo = izquierdo.visitar(this, 1);
				if(cuentaDerechoB.cuenta == -1 || cuentaIzquierdo.cuenta == -1)
					return respuestas[cuenta] = new Respuesta(-1, 0);
				return respuestas[cuenta] = new Respuesta(1, 0);
			}
			else
			{
				Respuesta cuentaIzquierdo = izquierdo.visitar(this, 2);
				if(cuentaIzquierdo.cuenta == -1)
				{
					if(derecho.visitar(this, 1).cuenta == -1)
						return respuestas[cuenta] = new Respuesta(-1, 0);
					return respuestas[cuenta] = new Respuesta(1, izquierdo.visitarInicio(this));
				}
				Respuesta cuentaDerecho = derecho.visitar(this, cuentaIzquierdo.cuenta);
				if(cuentaDerecho.cuenta == -1)
				{
					if(izquierdo.visitar(this, 1).cuenta == -1)
						return respuestas[cuenta] = new Respuesta(-1, 0);
					return respuestas[cuenta] = new Respuesta(1, derecho.visitarInicio(this));
				}
				return respuestas[cuenta] = new Respuesta(cuentaDerecho.cuenta, cuentaIzquierdo.cuantos + cuentaDerecho.cuantos);
			}
		}
	}

	static Nodo[] nodos = new Nodo[50010];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		for(int i = 1; i < 50010; i++)
			nodos[i] = new Nodo();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 1; i <= n; i++)
			{
				nodos[i].nConexiones = sc.nextInt();
				for(int j = 0; j < nodos[i].nConexiones; j++)
					nodos[i].conexiones[j] = nodos[sc.nextInt()];
				for(int j = 0; j < 3; j++)
					nodos[i].respuestas[j] = null;
				nodos[i].trampa = false;
				nodos[i].inicio = null;
			}
			for(int i = 0; i < m; i++)
				nodos[sc.nextInt()].trampa = true;
			int respuesta = nodos[1].visitarInicio(null);
			System.out.println(respuesta);
		}
	}
}