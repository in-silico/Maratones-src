import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class e 
{
	static class Entrada
	{
		int inicio;
		int fin;
		char cabana;
		
		public Entrada(int in, int fi, char c) 
		{
			inicio = in;
			fin = fi;
			cabana = c;
		}
	}
	
	static class Respuesta
	{
		ArrayList <Entrada> respuesta = new ArrayList <Entrada> ();

		public Respuesta(Entrada e)
		{
			respuesta.add(e);
		}

		public Respuesta(Respuesta value, Entrada e) 
		{
			for(Entrada e1 : value.respuesta)
				respuesta.add(e1);
			respuesta.add(e);
		}	
	}

	static char[] diaA = new char[101];
	static char[] diaB = new char[101];

	private static Respuesta mejor(Respuesta respuesta, Respuesta respuesta2, int inicio) 
	{
		for(int i = 0; i < 101; i++)
		{
			diaA[i] = diaB[i] = 'Z';
		}
		for(Entrada e : respuesta.respuesta)
		{
			for(int i = e.inicio; i <= e.fin; i++)
				diaA[i] = diaA[i] < e.cabana ? diaA[i] : e.cabana;
		}
		for(Entrada e : respuesta2.respuesta)
		{
			for(int i = e.inicio; i <= e.fin; i++)
				diaB[i] = diaB[i] < e.cabana ? diaB[i] : e.cabana;
		}
		for(int i = 0; i < 101; i++)
		{
			if(diaA[i] < diaB[i])
				return respuesta;
			else if(diaA[i] > diaB[i])
				return respuesta2;
		}
		return respuesta;
	}

	static LinkedList <Entrada> entradas = new LinkedList <Entrada> ();
	
	static SortedMap <Integer, Respuesta> simular(int inicio, int fin)
	{
		TreeMap <Integer, Respuesta> actuales = new TreeMap <Integer, Respuesta> ();
		for(Entrada e : entradas)
		{
			if(e.inicio <= inicio)
			{
				if(actuales.containsKey(e.fin))
				{
					actuales.put(e.fin, mejor(actuales.get(e.fin), new Respuesta(e), inicio));
				}
				else
				{
					actuales.put(e.fin, new Respuesta(e));
				}
			}
		}
		while(true)
		{
			if(actuales.isEmpty())
				return null;
			if(!actuales.subMap(fin, 10000).isEmpty())
				return actuales.subMap(fin, 10000);
			TreeMap <Integer, Respuesta> nuevas = new TreeMap <Integer, Respuesta> ();
			for(Entry<Integer, Respuesta> a : actuales.entrySet())
			{
				for(Entrada e : entradas)
				{
					if(a.getKey() + 1 >= e.inicio && a.getKey() + 1 <= e.fin)
					{
						if(nuevas.containsKey(e.fin))
						{
							nuevas.put(e.fin, mejor(nuevas.get(e.fin), new Respuesta(a.getValue(), e), inicio));
						}
						else
						{
							nuevas.put(e.fin, new Respuesta(a.getValue(), e));
						}
					}
				}
			}
			actuales = nuevas;
		}
	}

	static StringBuilder[] buffers = new StringBuilder[30];
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		for(int i = 0; i < 30; i++)
			buffers[i] = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean inicioB = false;
		int caso = 1;
		while(true)
		{
			String[] pedazos = br.readLine().split("\\s+");
			int m = Integer.parseInt(pedazos[0]);
			int n = Integer.parseInt(pedazos[1]);
			if(m == 0 && n == 0)
				return;
			if(inicioB)
				System.out.println();
			else 
				inicioB = true;
			System.out.println("Case " + caso++ + ":");
			System.out.println();
			for(int i = 0; i < 30; i++)
				buffers[i].setLength(0);
			for(int i = 0; i < m; i++)
			{
				int j = 0;
				for(char c : br.readLine().toCharArray())
				{
					buffers[j++].append(c);
				}
			}
			entradas.clear();
			for(int i = 0; i < n; i++)
			{
				char[] este = buffers[i].toString().toCharArray();
				int inicio = -1;
				for(int j = 1; j <= m; j++)
				{
					if(inicio == -1 && este[j - 1] == 'O')
					{
						inicio = j;
					}
					if(este[j - 1] == 'X' && inicio != -1)
					{
						entradas.add(new Entrada(inicio, j - 1, (char) ('A' + i)));
						inicio = -1;
					}
				}
				if(inicio != -1)
				{
					entradas.add(new Entrada(inicio, m, (char) ('A' + i)));
				}
			}
			pedazos = br.readLine().split("\\s+");
			int inicio = Integer.parseInt(pedazos[0]);
			int fin = Integer.parseInt(pedazos[1]);
			SortedMap <Integer, Respuesta> respuesta = simular(inicio, fin - 1);
			if(respuesta == null)
			{
				System.out.println("Not available");
			}
			else
			{
				Respuesta mejor = null;
				for(Respuesta e : respuesta.values())
				{
					if(mejor == null)
						mejor = e;
					else
					{
						mejor = mejor(mejor, e, inicio);
					}
				}
				for(int i = 0; i < 101; i++)
				{
					diaA[i] = 'Z';
				}
				for(Entrada e : mejor.respuesta)
				{
					for(int i = e.inicio; i <= e.fin; i++)
						diaA[i] = diaA[i] < e.cabana ? diaA[i] : e.cabana;
				}
				int anterior = inicio;
				char cabanaAnterior = diaA[inicio];
				for(int i = inicio; i < fin; i++)
				{
					if(cabanaAnterior != diaA[i])
					{
						System.out.println(cabanaAnterior + ": " + anterior + "-" + i);
						anterior = i;
						cabanaAnterior = diaA[i];
					}
				}
				System.out.println(cabanaAnterior + ": " + anterior + "-" + fin);
			}
		}
	}
}