import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Control 
{
	
	
	static char[][] display = new char[10][10];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 0;
		while(true)
		{
			caso++;
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			StringBuilder sb = new StringBuilder(100 * n);
			for(int i = 0; i < n; i++)
				sb.append(br.readLine().replace("\n", ""));
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10; j++)
					display[i][j] = ' ';
			char[] salida = sb.toString().toCharArray();
			boolean modoInsert = false;
			int cursorI = 0;
			int cursorJ = 0;
			for(int i = 0; i < salida.length; i++)
			{
				boolean entro = false;
				if(salida[i] == '^')
				{
					i++;
					entro = true;
					if(salida[i] == '^')
					{
						entro = false;
					}
					else if(salida[i] == 'b')
					{
						cursorJ = 0;
					}
					else if(salida[i] == 'c')
					{
						for(int ii = 0; ii < 10; ii++)
							for(int j = 0; j < 10; j++)
								display[ii][j] = ' ';
					}
					else if(salida[i] == 'd')
					{
						if(cursorI != 9)
							cursorI++;
					}
					else if(salida[i] == 'e')
					{
						for(int j = cursorJ; j < 10; j++)
							display[cursorI][j] = ' ';
					}
					else if(salida[i] == 'h')
					{
						cursorI = cursorJ = 0;
					}
					else if(salida[i] == 'i')
					{
						modoInsert = true;
					}
					else if(salida[i] == 'l')
					{
						if(cursorJ != 0)
							cursorJ--;
					}
					else if(salida[i] == 'o')
					{
						modoInsert = false;
					}
					else if(salida[i] == 'r')
					{
						if(cursorJ != 9)
							cursorJ++;
					}
					else if(salida[i] == 'u')
					{
						if(cursorI != 0)
							cursorI--;
					}
					else
					{
						cursorI = salida[i++] - '0';
						cursorJ = salida[i] - '0';
					}
				}
				if(!entro)
				{
					if(!modoInsert)
					{
						display[cursorI][cursorJ] = salida[i];
					}
					else
					{
						for(int j = 9; j >= cursorJ + 1; j--)
							display[cursorI][j] = display[cursorI][j - 1];
						display[cursorI][cursorJ] = salida[i];
					}
					if(cursorJ != 9)
						cursorJ++;
				}
			}
			System.out.println("Case " + caso);
			System.out.println("+----------+");
			for(int i = 0; i < 10; i++)
			{
				System.out.print("|");
				for(int j = 0; j < 10; j++)
				{
					System.out.print(display[i][j]);
				}
				System.out.println("|");
			}
			System.out.println("+----------+");
		}
	}

}
