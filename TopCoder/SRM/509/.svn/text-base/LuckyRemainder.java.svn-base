import java.util.Scanner;


public class LuckyRemainder 
{		
	int[] numeros = new int[51];
	
	public int getLuckyRemainder(String X)
	{
		for(int i = 0; i < X.length(); i++)
			numeros[i] = X.charAt(i) - '0';
		long potencia = 1L << X.length() - 1;
		potencia %= 9;
		int acum = 0;
		for(int i = 0; i < X.length(); i++)
		{
			acum += numeros[i] * potencia;
			acum %= 9;
		}
		return acum % 9;
	}
	
	public static void  main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(new LuckyRemainder().getLuckyRemainder(sc.next()));
		}
	}
}
