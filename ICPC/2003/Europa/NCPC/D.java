import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class D 
{
	
	static BigDecimal cien = new BigDecimal(100);
	
	public static boolean intentar(BigDecimal bd, BigDecimal i, int n)
	{
		return BigDecimal.valueOf(n).multiply(cien).divide(i, 10, RoundingMode.HALF_UP).setScale(bd.scale(), RoundingMode.HALF_UP).compareTo(bd) == 0;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			System.out.print("Case " + caso++ + ": ");
			ArrayList <BigDecimal> valores = new ArrayList <BigDecimal> (n);
			for(int i = 0; i < n; i++)
			{
				valores.add(sc.nextBigDecimal());
			}
			boolean termino = false;
			for(int i = 1; i < 10000; i++)
			{
				BigDecimal bi = new BigDecimal(i);
				TreeSet <Integer> anteriores = new TreeSet <Integer> ();
				TreeSet <Integer> siguientes = new TreeSet <Integer> ();
				anteriores.add(0);
				for(BigDecimal bd : valores)
				{
					int posible = bd.multiply(bi).divide(cien, 10, RoundingMode.HALF_UP).intValue();
					siguientes.clear();
					if(intentar(bd, bi, posible))
					{
						for(int a : anteriores)
						{
							siguientes.add(a + posible);
						}
					}
					for(int a = posible - 1; a >= 0; a--)
					{
						if(intentar(bd, bi, a))
						{
							for(int b : anteriores)
							{
								siguientes.add(b + a);
							}
						}
						else
							break;
					}
					for(int a = posible + 1; a < 10000; a++)
					{
						if(intentar(bd, bi, a))
						{
							for(int b : anteriores)
							{
								siguientes.add(b + a);
							}
						}
						else
							break;
					}
					TreeSet <Integer> temp = anteriores;
					anteriores = siguientes;
					siguientes = temp;
				}
				if(anteriores.contains(i))
				{
					System.out.println(i);
					termino = true;
					break;
				}
			}
			if(!termino)
				System.out.println("error");
		}
	}

}
