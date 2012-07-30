import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class C 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ntc = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < ntc; tc++)
		{
			int x = Integer.parseInt(br.readLine());
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]) + 2;
			int m = Integer.parseInt(pedazos[1]);
			char[][] anterior = new char[n][];
			char[][] nuevo = new char[n][m];
			HashSet <Integer> anteriores = new HashSet <Integer> (n * m);
			HashSet <Integer> nuevos = new HashSet <Integer> (n * m);
			for(int i = 0; i < n; i++)
			{
				anterior[i] = br.readLine().toCharArray();
			}
			int inicio = 0;
			int objetivo = 0;
			for(int i = 0; i < m; i++)
			{
				if(anterior[0][i] == 'G')
				{
					anterior[0][i] = 'O';
					objetivo = i;
				}
				if(anterior[n - 1][i] == 'F')
				{
					anterior[n - 1][i] = 'O';
					inicio = (n - 1) * m + i;
				}
			}
			anteriores.add(inicio);
			int turno;
			for(turno = 0; turno < x; turno++)
			{
				for(int i = 0; i < n; i++)
				{
					boolean derecha = ((n - i) % 2) == 0;
					if(derecha)
					{
						nuevo[i][0] = anterior[i][m - 1];
						for(int j = 1; j < m; j++)
						{
							nuevo[i][j] = anterior[i][j - 1];
						}
					}
					else
					{
						nuevo[i][m - 1] = anterior[i][0];
						for(int j = m - 2; j >= 0; j--)
						{
							nuevo[i][j] = anterior[i][j + 1];
						}
					}
//					System.out.println(nuevo[i]);
				}
//				System.out.println();
				nuevos.clear();
				for(int i : anteriores)
				{
					int fila = i / m;
					int columna = i % m;
					if(fila != 0)
					{
						if(nuevo[fila - 1][columna] != 'X')
						{
							nuevos.add((fila - 1) * m + columna);
						}
					}
					if(fila != n - 1)
					{
						if(nuevo[fila + 1][columna] != 'X')
						{
							nuevos.add((fila + 1) * m + columna);
						}
					}
					if(columna != 0)
					{
						if(nuevo[fila][columna - 1] != 'X')
						{
							nuevos.add(fila * m + columna - 1);
						}
					}
					if(columna != m - 1)
					{
						if(nuevo[fila][columna + 1] != 'X')
						{
							nuevos.add(fila * m + columna + 1);
						}
					}
					if(nuevo[fila][columna] != 'X')
					{
						nuevos.add(fila * m + columna);
					}
				}
				HashSet <Integer> temp = anteriores;
				anteriores = nuevos;
				nuevos = temp;
				char[][] cTemp = anterior;
				anterior = nuevo;
				nuevo = cTemp;
				if(anteriores.contains(objetivo))
					break;
			}
			if(turno == x)
			{
				System.out.println("The problem has no solution.");
			}
			else
			{
				System.out.println("The minimum number of turns is " + ++turno + ".");
			}
		}
	}
}
