package UVA;
import java.util.Scanner;

public class lookandsay 
{

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String xi = sc.next();
			int i = sc.nextInt();
			int j = sc.nextInt();
			if(xi.equals("0") && i == 0 && j == 0)
				return;
			i--;
			for(int k = 0; k < i; k++)
				xi = siguiente(xi, j > 100 ? ((k + 10) * j / (i + 9)) : j);
			System.out.println(xi.charAt(j - 1));
		}
	}

	private static String siguiente(String xi, int j) 
	{
		String salida = "";
		for(int i = 0; i < xi.length(); i++)
		{
			char actual = xi.charAt(i);
			int contador = 0;
			while(i < xi.length() && xi.charAt(i) == actual)
			{
				i++;
				contador++;
			}
			i--;
			salida += contador + "" + actual;
			if(salida.length() > j + 10)
				break;
		}
		return salida.substring(0, Math.min(1001, salida.length()));
	}
}
