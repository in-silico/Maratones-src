import java.util.Scanner;


public class c 
{
	
	static int lagrange(int numero)
	{
		int limite = (int) Math.round(Math.ceil(Math.sqrt(numero) + 1));
		int cuenta = 0;
		for(int i = 0; i <= limite; i++)
		{
			int suma = i * i;
			try
			{
				if(suma > numero)
					break;
				for(int j = i; j <= limite; j++)
				{
					suma += j * j;
					try
					{
						if(suma > numero)
							break;
						for(int k = j; k <= limite; k++)
						{
							suma += k * k;
							try
							{
								if(suma > numero)
									break;
								for(int l = k; l <= limite; l++)
								{
									suma += l * l;
									try
									{
										if(suma > numero)
											break;
										if(suma == numero)
										{
											cuenta++;
											break;
										}
									}
									finally
									{
										suma -= l * l;
									}
								}
							}
							finally
							{
								suma -= k * k;
							}
						}
					}
					finally
					{
						suma -= j * j;
					}
				}
			}
			finally
			{
				suma -= i * i;
			}
		}
		return cuenta;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int numero = sc.nextInt();
			if(numero == 0)
				return;
			System.out.println(lagrange(numero));
		}
	}

}
