package GoogleCode;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class base 
{

	
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("b.in"));
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++)
		{
			String s = sc.nextLine();
			String primero = s;
			HashSet <Character> set = new HashSet <Character> ();
			for(char a : s.toCharArray())
			{
				set.add(a);
			}
			int baseMinima = set.size();
			if(baseMinima == 1)
			{
				baseMinima = 2;
			}
			int numeroInicial = 1;
			ArrayList <String> ar = new ArrayList <String> ();
			char inicial = s.charAt(0);
			set.remove(inicial);
			ar.add(numeroInicial + " " + inicial);
			s = s.substring(1);
			numeroInicial = 0;
			for(int j = 0; j < s.length(); j++)
			{
				if(set.contains(s.charAt(j)))
				{
					set.remove(s.charAt(j));
					ar.add(numeroInicial + " " + s.charAt(j));
					numeroInicial++;
					if(numeroInicial == 1)
						numeroInicial = 2;
				}
			}
			BigInteger acumulado = new BigInteger("0");
			for(int a = 0; a < primero.length(); a++)
			{
				for(String b : ar)
				{
					if(b.endsWith(primero.charAt(a) + ""))
					{
						acumulado = acumulado.add(new BigInteger(b.split(" ")[0]).multiply(new BigInteger("" + (baseMinima)).pow(primero.length() - a - 1)));
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + acumulado);
		}
	}
}
