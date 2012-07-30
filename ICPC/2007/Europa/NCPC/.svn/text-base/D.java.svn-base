import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class D
{
	 
	static class Entrada implements Comparable <Entrada>
	{
		int n, g, h;
		
		public Entrada(int nn, int gg, int hh)
		{
			n = nn;
			g = gg;
			h = hh;
		}

		@Override
		public int compareTo(Entrada o) 
		{
			return Integer.valueOf(g + h).compareTo(o.g + o.h);
		}
	}

	static HashSet <String> posiblesIniciales = new HashSet <String> (1000);
	static HashSet <String> actuales = new HashSet <String> (101, 1);
	static StringBuilder sb = new StringBuilder(18);
	static String entrada;
	static String salida;
	static TreeSet <Integer> visitados = new TreeSet <Integer> ();
	static PriorityQueue <Entrada> cola = new PriorityQueue <Entrada> ();
	static String[][] substrings = new String[18][19];
	static int[] dosALa = new int[19];
	static int tamSalida;
	
	public static void llenarPI()
	{
		posiblesIniciales.clear();
		int tamEntrada = entrada.length();
		for(int i = 0; i < tamEntrada; i++)
		{
			for(int j = i; j < tamEntrada; j++)
			{
				String este = entrada.substring(i, j + 1);
				posiblesIniciales.add(este);
				sb.setLength(0);
				sb.append(este);
				posiblesIniciales.add(sb.reverse().toString());
			}
		}
	}
	
	public static void llenarSS()
	{
		for(int i = 0; i < tamSalida; i++)
		{
			for(int j = i + 1; j <= tamSalida; j++)
			{
				substrings[i][j] = salida.substring(i, j);
			}
		}
	}
	public static String substring(int i, int j)
	{
		return substrings[i][j];
	}
	
	static char[] buffer = new char[18];
	
	static int mejor;
	static int objetivo;
	
	public static void llenarNuevos(Entrada aa)
	{
		if(visitados.contains(aa.n))
			return;
		int profundidad = aa.g;
		int tablero = aa.n;
		if(profundidad >= mejor)
			return;
		if(tablero == objetivo)
		{
			mejor = Math.min(profundidad, mejor);
			return;
		}
		for(int i = 0; i < tamSalida; i++)
			buffer[i] = '0';
		int tableroTemp = tablero;
		int actual = tamSalida - 1;
		while(tableroTemp != 0)
		{
			buffer[actual--] = (tableroTemp & 1) == 1 ? '1' : '0';
			tableroTemp >>= 1;
		}
		int i, j;
		actuales.clear();
		for(i = 0; i < tamSalida; i++)
		{
			if(buffer[i] == '0')
				continue;
			for(j = i; j < tamSalida; j++)
			{
				if(buffer[j] == '0')
					break;
				String este = substring(i, j + 1);
				actuales.add(este);
				sb.setLength(0);
				sb.append(este);
				actuales.add(sb.reverse().toString());
			}
		}
		for(i = 0; i < tamSalida; i++)
		{
			if(buffer[i] == '1')
				continue;
			for(j = i; j < tamSalida; j++)
			{
				if(buffer[j] == '1')
					break;
			}
			int maximo = j - 1;
			for(j = maximo; j >= i; j--)
			{
				if(buffer[j] == '1')
					break;
				String este = substring(i, j + 1);
				if(actuales.contains(este) || posiblesIniciales.contains(este))
				{
					for(int a = i; a <= j; a++)
						buffer[a] = '1';
					int numero = 0;
					for(int a = 0; a < tamSalida - 1; a++)
						if(buffer[a] == '0' && buffer[a + 1] == '1')
						{
							numero++;
						}
					int primer = 0;
					for(int a = 0; a < tamSalida; a++)
						if(buffer[a] == '1')
						{
							primer = a;
							break;
						}
					int cuenta = Integer.parseInt(new String(buffer, primer, tamSalida - primer), 2);
					cola.add(new Entrada(cuenta, profundidad + 1, numero));
					for(int a = i; a <= j; a++)
						buffer[a] = '0';
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long actual = System.currentTimeMillis();
		for(int i = 0; i <= 18; i++)
		{
			dosALa[i] = 1 << i;
		}
		for(int caso = 0; caso < n; caso++)
		{
			entrada = br.readLine();
			salida = br.readLine();
			tamSalida = salida.length();
			llenarPI();
			llenarSS();
			objetivo = (1 << tamSalida) - 1;
			cola.clear();
			cola.add(new Entrada(0, 0, tamSalida));
			visitados.clear();
			mejor = tamSalida + 1;
			while(!cola.isEmpty())
			{
				Entrada a = cola.poll();
				llenarNuevos(a);
				visitados.add(a.n);
			}
			System.out.println(mejor == tamSalida + 1 ? "impossible" : mejor);
		}
		System.out.println(System.currentTimeMillis() - actual);
	}

}
