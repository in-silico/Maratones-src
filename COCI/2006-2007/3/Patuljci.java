import java.util.Scanner;


public class Patuljci
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[9];
		for(int i = 0; i < 9; i++)
			numeros[i] = sc.nextInt();
		for(int i = 0; i < 1 << 9; i++)
		{
			if(Integer.bitCount(i) == 7)
			{
				int cuenta = 0;
				for(int j = 0; j < 9; j++)
				{
					if(((i >> j) & 1) == 1)
						cuenta += numeros[j];
				}
				if(cuenta == 100)
				{
					for(int j = 0; j < 9; j++)
					{
						if(((i >> j) & 1) == 1)
							System.out.println(numeros[j]);
					}
					return;
				}
			}
		}
	}
}
