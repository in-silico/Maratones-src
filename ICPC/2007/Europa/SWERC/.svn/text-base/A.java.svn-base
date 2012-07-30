import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class A 
{	
	static HashMap <String, Integer> actuales = new HashMap <String, Integer> (20000);
	
	static class Instruccion
	{
		int tipo;
		int salto;
		String saltoS;
		
		public Instruccion(int esta, String s)
		{
			String[] pedazos = s.split(" ");
			for(int i = 0; i < pedazos.length; i++)
				pedazos[i] = pedazos[i].trim();
			actuales.put(pedazos[0], esta);
			if(pedazos[1].equals("BRTRUE"))
				tipo = 0;
			else if(pedazos[1].equals("JMP"))
				tipo = 1;
			else if(pedazos[1].equals("RET1"))
				tipo = 2;
			else
				tipo = 3;
			if(tipo < 2)
				saltoS = pedazos[2];
			else
				saltoS = null;
		}
	}
	
	static class Nodo
	{
		boolean termina;
		boolean valor;
		Nodo izquierdo;
		Nodo derecho;
		
		public Nodo(boolean termina, boolean valor, Nodo izquierdo, Nodo derecho)
		{
			this.termina = termina;
			this.valor = valor;
			this.izquierdo = izquierdo;
			this.derecho = derecho;
		}
		
		static Nodo uno = new Nodo(true, true, null, null);
		static Nodo dos = new Nodo(true, false, null, null);
		static Instruccion[] arreglo;
		static Nodo[] dp = new Nodo[20001];
		
		public static Nodo darNodo(int actual)
		{
			Instruccion esta = arreglo[actual];
			if(esta.tipo == 2)
				return dp[actual] = uno;
			else if(esta.tipo == 3)
				return dp[actual] = dos;
			else if(esta.tipo == 1)
				return dp[actual] = darNodo(esta.salto);
			else
			{
				Nodo izquierdo = darNodo(esta.salto);
				Nodo derecho = darNodo(actual + 1);
				if(izquierdo.termina && derecho.termina && izquierdo.valor == derecho.valor)
					return dp[actual] = izquierdo.valor ? uno : dos;
				else
					return dp[actual] = new Nodo(false, false, izquierdo, derecho);
			}
		}
		
		public boolean igual(Nodo otro)
		{
			if(otro.termina)
				return termina && valor == otro.valor;
			else if(termina)
				return otro.termina && valor == otro.valor;
			return izquierdo.igual(otro.izquierdo) && derecho.igual(otro.derecho);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Instruccion[] a = new Instruccion[20005];
		Instruccion[] b = new Instruccion[20005];
		int n = Integer.parseInt(br.readLine());
		for(int ds = 0; ds < n; ds++)
		{
			br.readLine();
			if(ds != 0)
				System.out.println();
			int p = Integer.parseInt(br.readLine());
			for(int caso = 0; caso < p; caso++)
			{
				br.readLine();
				actuales.clear();
				int i = 0;
				while(true)
				{
					String actual = br.readLine().trim();
					if(actual.equals("END"))
						break;
					a[i] = new Instruccion(i++, actual);
				}
				for(int j = 0; j < i; j++)
				{
					if(a[j].tipo < 2)
						a[j].salto = actuales.get(a[j].saltoS);
					Nodo.dp[j] = null;
				}
				actuales.clear();
				boolean vacio = i == 0;
				i = 0;
				while(true)
				{
					String actual = br.readLine().trim();
					if(actual.equals("END"))
						break;
					b[i] = new Instruccion(i++, actual);
				}
				for(int j = 0; j < i; j++)
					if(b[j].tipo < 2)
						b[j].salto = actuales.get(b[j].saltoS);
				if(i == 0 || vacio)
					System.out.println(i == 0 && vacio ? "1" : "0");
				else
				{
					Nodo.arreglo = a;
					Nodo uno = Nodo.darNodo(0);
					for(int j = 0; j < i; j++)
						Nodo.dp[j] = null;
					Nodo.arreglo = b;
					Nodo dos = Nodo.darNodo(0);
					System.out.println(uno.igual(dos) ? "1" : "0");
				}
			}
		}
	}
}