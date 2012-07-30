package UVA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class playfair 
{

	@SuppressWarnings("unchecked")
	public static void main(String [] args)
	{
		ArrayList <Character> letrasAlfabetoG = new ArrayList <Character> (25);
		for(char i = 'a'; i < ('z' + 1); i++)
			if(i != 'q')
				letrasAlfabetoG.add(i);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++)
		{
			ArrayList <Character> letrasAlfabeto = (ArrayList <Character>) letrasAlfabetoG.clone();
			String key = sc.nextLine().replace(" ", "");
			String text = sc.nextLine().replace(" ", "");
			LinkedList <Character> keyTableA = new LinkedList <Character> ();
			for(char a : key.toCharArray())
			{
				if(keyTableA.size() == 25)
					break;
				if(!keyTableA.contains(a))
				{
					keyTableA.add(a);
					letrasAlfabeto.remove((Character)a);
				}
			}
			for(int j = 0; keyTableA.size() < 25; j++)
			{
				keyTableA.add(letrasAlfabeto.get(j));
			}
			char[][] keyTable = new char[5][5];
			for(int j = 0; j < 5; j++)
				for(int k = 0; k < 5; k++)
				{
					keyTable[j][k] = keyTableA.poll();
				}
			char[][] keyTable1 = new char[6][6];
			for(int j = 0; j < 6; j++)
				for(int k = 0; k < 6; k++)
				{
					if(j == 5 && k == 5)
						break;
					if(j == 5)
					{
						keyTable1[j][k] = keyTable[0][k];
					}
					else if(k == 5)
					{
						keyTable1[j][k] = keyTable[j][0];
					}
					else
					{
						keyTable1[j][k] = keyTable[j][k];
					}
				}
			
			LinkedList <Character> clave = new LinkedList <Character> ();
			for(char a : text.toCharArray())
				clave.add(a);
			ArrayList <Character> resultado = new ArrayList <Character> (2000);
			for(int j = 0; j < clave.size();)
			{
				char primera = clave.get(j);
				if(j == clave.size() - 1)
				{
					clave.add('x');
					continue;
				}
				char segunda = clave.get(j + 1);
				if(primera == segunda)
				{
					clave.add(j + 1, 'x');
					continue;
				}
				long filaColumnaP = filaColumna(keyTable, primera);
				long filaColumnaS = filaColumna(keyTable, segunda);
				int filaP = (int) filaColumnaP;
				int columnaP = (int) (filaColumnaP >> 32);
				int filaS = (int) filaColumnaS;
				int columnaS = (int) (filaColumnaS >> 32);
				if(filaP == filaS)
				{
					resultado.add(keyTable1[filaP][columnaP + 1]);
					resultado.add(keyTable1[filaS][columnaS + 1]);
				}
				else if(columnaP == columnaS)
				{
					resultado.add(keyTable1[filaP + 1][columnaP]);
					resultado.add(keyTable1[filaS + 1][columnaS]);
				}
				else
				{
					resultado.add(keyTable1[filaP][columnaS]);
					resultado.add(keyTable1[filaS][columnaP]);
				}
				j += 2;
			}
			char[] caracteres1 = new char[resultado.size()];
			int j = 0;
			for(Character c : resultado)
				caracteres1[j++] = (char) ('A' + (c - 'a'));
			System.out.println(new String(caracteres1));
		}
	}

	private static long filaColumna(char[][] keyTable, char primera) 
	{
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				if(keyTable[i][j] == primera)
					return (long)i | ((long)j << 32);
			}
		return 0;
	}
}
