import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class H 
{

	static final int sew = 1;
	static final int turn = 2;
	static final int a = 3;
	static final int b = 4;
	static char[][] mA = new char[][]{ {'/', '/'}, {'/', '+'}};
	static char[][] mB = new char[][]{ {'-', '-'}, {'-', '-'}};
	
	static LinkedList <Integer> arreglo = new LinkedList <Integer> ();
	
	static class Nodo
	{
		int funcion = 0;
		Nodo izquierdo;
		Nodo derecho;
		char[][] matriz;
		
		public static Nodo construirNodo()
		{
			Nodo nuevo = new Nodo();
			int siguiente = arreglo.poll();
			if(siguiente == a)
			{
				nuevo.matriz = mA;
			}
			else if(siguiente == b)
			{
				nuevo.matriz = mB;
			}
			else if(siguiente == sew)
			{
				nuevo.funcion = sew;
				nuevo.izquierdo = construirNodo();
				nuevo.derecho = construirNodo();
			}
			else if(siguiente == turn)
			{
				nuevo.funcion = turn;
				nuevo.izquierdo = construirNodo();
			}
			return nuevo;
		}
		
		public void calcular()
		{
			if(matriz == null)
			{
				if(funcion == sew)
				{
					izquierdo.calcular();
					derecho.calcular();
					char[][] matriz1 = izquierdo.matriz;
					char[][] matriz2 = derecho.matriz;
					if(matriz1.length != matriz2.length)
						throw(new RuntimeException());
					matriz = new char[matriz1.length][matriz1[0].length + matriz2[0].length];
					for(int i = 0; i < matriz1.length; i++)
						for(int j = 0; j < matriz1[0].length; j++)
							matriz[i][j] = matriz1[i][j];
					for(int i = 0; i < matriz2.length; i++)
						for(int j = 0; j < matriz2[0].length; j++)
							matriz[i][j + matriz1[0].length] = matriz2[i][j];
				}
				if(funcion == turn)
				{
					izquierdo.calcular();
					char[][] matriz1 = izquierdo.matriz;
					matriz = new char[matriz1[0].length][matriz1.length];
					for(int i = 0; i < matriz1.length; i++)
						for(int j = 0; j < matriz1[0].length; j++)
						{
							int indice = matriz1.length - 1 - i;
							matriz[j][indice] = matriz1[i][j];
							if(matriz[j][indice] == '/')
								matriz[j][indice] = '\\';
							else if(matriz[j][indice] == '\\')
								matriz[j][indice] = '/';
							else if(matriz[j][indice] == '-')
								matriz[j][indice] = '|';
							else if(matriz[j][indice] == '|')
								matriz[j][matriz1.length - 1 - i] = '-';
						}
				}
			}
			else
				return;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(1000000);
		while(true)
		{
			String linea = br.readLine();
			if(linea == null || linea.equals("*"))
				break;
			else
				sb.append(linea);
		}
		String todo = sb.toString();
		StringTokenizer st = new StringTokenizer(todo.replace(";", " ; "), "(), ");
		int numero = 1;
		while(true)
		{
			if(!st.hasMoreTokens())
				return;
			arreglo.clear();
			while(true)
			{
				String token = st.nextToken();
				if(token.equals("A"))
					arreglo.add(a);
				else if(token.equals("B"))
					arreglo.add(b);
				else if(token.equals("sew"))
					arreglo.add(sew);
				else if(token.equals("turn"))
					arreglo.add(turn);
				else if(token.equals(";"))
					break;
			}
			Nodo raiz = Nodo.construirNodo();
			System.out.println("Quilt " + numero++ + ":");
			try
			{
				raiz.calcular();
				for(int i = 0; i < raiz.matriz.length; i++)
				{
					for(int j = 0; j < raiz.matriz[0].length; j++)
					{
						System.out.print(raiz.matriz[i][j]);
					}
					System.out.println();
				}
			}
			catch(Exception e)
			{
				System.out.println("error");
			}
		}
	}
}
