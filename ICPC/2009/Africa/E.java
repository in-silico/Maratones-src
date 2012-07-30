import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class E 
{
	
	static HashSet <String> visitados = new HashSet <String> (100000);
	
	public static class Tablero
	{
		int posRana;
		char[] tablero;
		String tableroS;
		int numero;
		
		
		public Tablero(char[] t, int i, int n) 
		{
			tablero = t;
			posRana = i;
			tableroS = new String(tablero);
			numero = n;
		}

		void generarHijos(List <Tablero> aDonde)
		{
			if(numero == 9)
				return;
			if(posRana >= 1)
			{
				char[] hijo = tablero.clone();
				hijo[posRana] = hijo[posRana - 1];
				hijo[posRana - 1] = 'F';
				Tablero tableroH = new Tablero(hijo, posRana - 1, numero + 1);
				if(!visitados.contains(tableroH.tableroS))
					aDonde.add(tableroH);
			}
			if(posRana < tablero.length - 1)
			{
				char[] hijo = tablero.clone();
				hijo[posRana] = hijo[posRana + 1];
				hijo[posRana + 1] = 'F';
				Tablero tableroH = new Tablero(hijo, posRana + 1, numero + 1);
				if(!visitados.contains(tableroH.tableroS))
					aDonde.add(tableroH);
			}
			if(posRana >= 2)
			{
				char[] hijo = tablero.clone();
				hijo[posRana] = hijo[posRana - 2] == 'B' ? 'W' : 'B';
				hijo[posRana - 2] = 'F';
				Tablero tableroH = new Tablero(hijo, posRana - 2, numero + 1);
				if(!visitados.contains(tableroH.tableroS))
					aDonde.add(tableroH);
			}
			if(posRana < tablero.length - 2)
			{
				char[] hijo = tablero.clone();
				hijo[posRana] = hijo[posRana + 2] == 'B' ? 'W' : 'B';
				hijo[posRana + 2] = 'F';
				Tablero tableroH = new Tablero(hijo, posRana + 2, numero + 1);
				if(!visitados.contains(tableroH.tableroS))
					aDonde.add(tableroH);
			}
		}

		public boolean esSolucion() 
		{
			int ultimaB = -1;
			int primeraB = -1;
			for(int i = tablero.length - 1; i >= 0; i--)
			{
				if(tablero[i] == 'B')
				{
					ultimaB = i;
					break;
				}
			}
			for(int i = 0; i < tablero.length; i++)
			{
				if(tablero[i] == 'B')
				{
					primeraB = i;
					break;
				}
			}
			if(ultimaB == -1 || primeraB == -1)
				return true;
			for(int i = primeraB; i <= ultimaB; i++)
			{
				if(tablero[i] == 'W')
					return false;
			}
			return true;
		}
	}
	
	public static int bfs(Tablero inicial)
	{
		visitados.clear();
		LinkedList <Tablero> porVisitar = new LinkedList <Tablero> ();
		porVisitar.add(inicial);
		while(!porVisitar.isEmpty())
		{
			Tablero actual = porVisitar.pollFirst();
			visitados.add(actual.tableroS);
			if(actual.esSolucion())
				return actual.numero;
			actual.generarHijos(porVisitar);
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = 1;
		while(true)
		{
			String lineaActual = br.readLine();
			if(lineaActual.contains("-"))
				return;
			char[] inicial = lineaActual.toCharArray();
			int posInicial = 0;
			for(int i = 0; i < inicial.length; i++)
			{
				if(inicial[i] == 'F')
					posInicial = i;
			}
			Tablero tInicial = new Tablero(inicial, posInicial, 0);
			System.out.println(k++ + ". " + bfs(tInicial));
		}
	}

}
