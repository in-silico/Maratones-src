import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Maze
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCasos = Integer.parseInt(br.readLine().trim());
		boolean empezo = false;
		while(nCasos-- != 0)
		{
			br.readLine();
			if(empezo)
				System.out.println();
			else
				empezo = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int filas = Integer.parseInt(st.nextToken());
//			int columnas = Integer.parseInt(st.nextToken());
			char[][] mapa = new char[filas][];
			for(int i = 0; i < filas; i++)
				mapa[i] = br.readLine().toCharArray();
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			i--;
			j--;
			String s = "";
			while(true)
			{
				String nuevo = br.readLine();
				s += nuevo;
				if(nuevo.contains("Q"))
					break;
			}
			int direccion = 0;
			for(char c : s.toCharArray())
			{
				if(c == 'F')
				{
					if(direccion == 0)
						i--;
					else if(direccion == 1)
						j++;
					else if(direccion == 2)
						i++;
					else
						j--;
					if(mapa[i][j] == '*')
					{
						if(direccion == 0)
							i++;
						else if(direccion == 1)
							j--;
						else if(direccion == 2)
							i--;
						else
							j++;
					}
				}
				if(c == 'L')
				{
					direccion--;
					if(direccion == -1)
						direccion = 3;
				}
				if(c == 'R')
				{
					direccion++;
					if(direccion == 4)
						direccion = 0;
				}
				if(c == 'Q')
					break;
			}
			String dir = "";
			if(direccion == 0)
				dir = "N";
			else if(direccion == 1)
				dir = "E";
			else if(direccion == 2)
				dir = "S";
			else
				dir = "W";
			System.out.println((i + 1) + " " + (j + 1) + " " + dir);
		}
	}

}
