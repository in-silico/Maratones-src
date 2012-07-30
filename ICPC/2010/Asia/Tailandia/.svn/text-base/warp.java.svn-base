import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class warp 
{
	static Hashtable <String, Integer> reglas;
	static ArrayList <Entrada> entradas[];
	static char[] sequencia;
	static ArrayList <String> soluciones = new ArrayList <String> ();
	
	static class Entrada
	{
		int posicion;
		String valor;
		int costo;
		
		public Entrada(int posicion, String valor, int costo) {
			this.posicion = posicion;
			this.valor = valor;
			this.costo = costo;
		}
		
		
	}
	
	public static boolean existeRegla(String regla)
	{
		if(regla.length() == 1)
			return true;
		else
			return reglas.containsKey(regla);
	}
	
	public static boolean estaLibre(String s)
	{
		for(char a : s.toCharArray())
		{
			if((a <= 'Z' && a >= 'A') || (a <= 'z' && a >= 'a'))
					return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = "";
		reglas = new Hashtable <String, Integer> (10000); 
		entradas = ((ArrayList <Entrada>[])(new ArrayList[500]));
		for(int i = 0; i < 500; i++)
			entradas[i] = new ArrayList <Entrada> ();
		while(!(estaLibre(linea = br.readLine())))
			reglas.put(linea.replaceAll(" ", ""), 1);
		while(((linea = br.readLine()) != null && !estaLibre(linea)))
		{
			soluciones.clear();
			sequencia = linea.replaceAll(" ", "").toCharArray();
			for(int i = 0; i < sequencia.length; i++)
				entradas[i].clear();
			entradas[0].add(new Entrada(-1, sequencia[0] + "", 1));
			for(int i = 1; i < sequencia.length; i++)
			{
				solucionar(i);
			}
			agregarRespuestas("", sequencia.length - 1);
			System.out.println(soluciones.size() + " " + ((ArrayList <Entrada>) entradas[sequencia.length - 1]).get(0).costo);
			Collections.sort(soluciones);
			for(String s : soluciones)
				System.out.println(s.substring(0, s.length() - 1));
			soluciones.clear();
		}
	}
	
	public static void solucionar(int actual)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(sequencia[actual]);
		int menor = ((Entrada)entradas[actual - 1].get(0)).costo + 1;
		entradas[actual].add(new Entrada(actual - 1, sb.toString(), menor));
		for(int i = actual - 1; i >= 0; i--)
		{
			sb.append(sequencia[i]);
			String regla = new StringBuilder(sb.toString()).reverse().toString();
			if(existeRegla(regla))
			{
				if(i == 0)
				{
					int posibleMenor = 1;
					if(posibleMenor <= menor)
					{
						if(posibleMenor < menor)
							entradas[actual].clear();
						menor = posibleMenor;
						entradas[actual].add(new Entrada(i - 1, regla, posibleMenor));
					}
				}
				else
				{
					int posibleMenor = ((Entrada) entradas[i - 1].get(0)).costo + 1;
					if(posibleMenor <= menor)
					{
						if(posibleMenor < menor)
							entradas[actual].clear();
						menor = posibleMenor;
						entradas[actual].add(new Entrada(i - 1, regla, posibleMenor));
					}
				}
			}
		}
	}
	
	public static void agregarRespuestas(String respuestaActual, int pos)
	{
		if(pos <= -1)
			soluciones.add(respuestaActual);
		else
		{
			for(Entrada e : (ArrayList <Entrada>) entradas[pos])
				agregarRespuestas(e.valor + " " + respuestaActual, e.posicion);
		}
	}
}