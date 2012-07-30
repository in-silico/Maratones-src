package UVA;

import java.io.IOException;
import java.util.Scanner;

public class judge 
{
	
	public static void main(String [] args) throws IOException
	{
			try
			{
				Scanner sc = new Scanner(System.in);
				int n = 0;
				while(sc.hasNextLine())
				{
					int lineas;
					try
					{
						lineas = sc.nextInt();
						sc.nextLine();
					}
					catch(Exception e)
					{
						lineas = 0;
					}
					if(lineas == 0)
						return;
					char correcto [] = new char[13000]; 
					int pos = 0;
					for(int i = 0; i < lineas; i++)
					{
						String linea;
						try
						{
							linea = sc.nextLine();
						}
						catch(Exception e)
						{
							return;
						}
						for(char c : linea.toCharArray())
						{
							correcto[pos++] = c;
						}
						correcto[pos++] = '\n';
					}
					int lineas2;
					try
					{
						lineas2 = sc.nextInt();
						sc.nextLine();
					}
					catch(Exception e)
					{
						return;
					}
					
					char prueba [] = new char[13000];
					int pos2 = 0;
					for(int i = 0; i < lineas2; i++)
					{
						String linea;
						try
						{
							linea = sc.nextLine();
						}
						catch(Exception e)
						{
							return;
						}
						for(char c : linea.toCharArray())
						{
							prueba[pos2++] = c;
						}
						prueba[pos2++] = '\n';
					}
					if(pos == pos2)
					{
						boolean termino = false;
						for(int i = 0; i < pos; i++)
						{
							if(correcto[i] != prueba[i])
							{
								termino = true;
								break;
							}
						}
						if(!termino)
						{
							System.out.println("Run #" + (++n) + ": Accepted");
							continue;
						}
					}
					int posn = -1;
					boolean termino = false;
					char s = correcto[0];
					for(int i = 0; i < pos; s = correcto[++i])
					{
						if(s >= '0' && s <= '9')
						{
							while(posn < pos2 && (prueba[++posn] < '0' || prueba[posn] > '9'));
							if(posn >= pos2)
							{
								System.out.println("Run #" + (++n) + ": Wrong Answer");
								termino = true;
								break;
							}
							if(prueba[posn] != s)
							{
								System.out.println("Run #" + (++n) + ": Wrong Answer");
								termino = true;
								break;
							}
						}
					}
					if(!termino && posn != pos2)
					{
						while(posn < pos2 && (prueba[++posn] < '0' || prueba[posn] > '9'));
						if(posn < pos2)
						{
							System.out.println("Run #" + (++n) + ": Wrong Answer");
							termino = true;
							continue;
						}
					}
					if(!termino)
					{
						System.out.println("Run #" + (++n) + ": Presentation Error");
						termino = true;
					}
				}
		}
		catch(IndexOutOfBoundsException e)
		{
			return;
		}
	}

}
