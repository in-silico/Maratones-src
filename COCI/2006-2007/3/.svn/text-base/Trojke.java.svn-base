import java.util.Scanner;


public class Trojke
{
	static int GCD(int a, int b)
	{
	   if (b==0) return a;
	   return GCD(b, a % b);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[][] tablero = new char[n][];
		for(int i = 0; i < n; i++)
			tablero[i] = sc.nextLine().trim().toCharArray();
		long cuenta = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			{
				if(tablero[i][j] == '.')
					continue;
				for(int k = i; k < n; k++)
				{
					for(int l = k == i ? j + 1 : 0; l < n; l++)
					{
						if(tablero[k][l] == '.')
							continue;
						int diffI = k - i;
						int diffJ = l - j;
						if(diffI == 0 || diffJ == 0)
						{
							if(diffI == 0)
								diffJ = 1;
							else
								diffI = 1;
						}
						else
						{
							int gcd = GCD(Math.abs(diffI), Math.abs(diffJ));
							diffI /= gcd;
							diffJ /= gcd;
						}
						int indiceI = k;
						int indiceJ = l;
						indiceI += diffI;
						indiceJ += diffJ;
						while(indiceI >= 0 && indiceI < n && indiceJ >= 0 && indiceJ < n)
						{
							if(tablero[indiceI][indiceJ] != '.')
								cuenta++;
							indiceI += diffI;
							indiceJ += diffJ;
						}
					}
				}
			}
		System.out.println(cuenta);
	}

}
