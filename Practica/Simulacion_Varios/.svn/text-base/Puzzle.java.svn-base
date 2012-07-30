import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Puzzle 
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int act = 1;
		while(true)
		{
			char[][] tablero = new char[5][];
			for(int i = 0; i < 5; i++)
			{
				String linea = br.readLine();
				if(linea.replace(" ", "").equals("Z") && i == 0)
					return;
				tablero[i] = linea.toCharArray();
			}
			if(act != 1)
				System.out.println();
			int vacioI = 0;
			int vacioJ = 0;
			for(int i = 0; i < 5; i++)
			{
				boolean termino = false;
				for(int j = 0; j < 5; j++)
				{
					if(tablero[i][j] == ' ')
					{
						vacioI = i;
						vacioJ = j;
						termino = true;
						break;
					}
				}
				if(termino)
					break;
			}
			StringBuilder lineaF = new StringBuilder(br.readLine().replace(" ", ""));
			while(lineaF.lastIndexOf("0") == -1)
			{
				lineaF.append(br.readLine().replace(" ", ""));
			}
			System.out.println("Puzzle #" + act++ + ":");
			String salida = lineaF.toString();
			salida = salida.substring(0, salida.length() - 1);
			try
			{
				for(char c : salida.toCharArray())
				{
					if(c == 'A')
					{
						tablero[vacioI][vacioJ] = tablero[vacioI - 1][vacioJ];
						vacioI--;
						tablero[vacioI][vacioJ] = ' ';
					}
					else if(c == 'B')
					{
						tablero[vacioI][vacioJ] = tablero[vacioI + 1][vacioJ];
						vacioI++;
						tablero[vacioI][vacioJ] = ' ';
					}
					else if(c == 'R')
					{
						tablero[vacioI][vacioJ] = tablero[vacioI][vacioJ + 1];
						vacioJ++;
						tablero[vacioI][vacioJ] = ' ';
					}
					else if(c == 'L')
					{
						tablero[vacioI][vacioJ] = tablero[vacioI][vacioJ - 1];
						vacioJ--;
						tablero[vacioI][vacioJ] = ' ';
					}
					else
					{
						throw(new RuntimeException());
					}
				}
				for(int i = 0; i < 5; i++)
				{
					System.out.print(tablero[i][0]);
					for(int j = 1; j < 5; j++)
						System.out.print(" " + tablero[i][j]);
					System.out.println();
				}
			}
			catch(Exception e)
			{
				System.out.println("This puzzle has no final configuration.");
			}
		}
	}
}
