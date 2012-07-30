import java.util.Scanner;


public class E 
{
	static int[] orden = new int[501];
	static int[] salida = new int[501];
	static int n;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				orden[i] = sc.nextInt();
			for(int i = 0; i < n; i++)
				salida[i] = -1;
			for(int i = 0; i < n; i++)
			{
				int cuenta = 0;
				int donde = 0;
				for(int j = 0; j < n; j++)
				{
					if(salida[j] != -1)
					{
						continue;
					}
					else
					{
						donde = j;
						cuenta++;
						if(cuenta > orden[i])
							break;		
					}
				}
				salida[donde] = i + 1;
			}
			boolean inicio = false;
			for(int i = 0; i < n; i++)
			{
				if(!inicio)
					inicio = true;
				else
					System.out.print(",");
				System.out.print(salida[i]);
			}
			System.out.println();
		}
	}
}
