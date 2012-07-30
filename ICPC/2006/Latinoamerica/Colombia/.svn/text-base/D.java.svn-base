import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class D 
{
	static LinkedList <BigInteger> arreglo = new LinkedList <BigInteger> ();
	
	public static void iterar(BigInteger a, BigInteger b)
	{
		if(a.remainder(b).equals(BigInteger.ZERO))
		{
			arreglo.add(a.divide(b).subtract(BigInteger.ONE));
			return;
		}
		arreglo.add(a.divide(b));
		a = a.subtract(b.multiply(a.divide(b)));
		iterar(b, a);
	}
	
	static LinkedList < String > ai = new LinkedList < String > ();
	
	public static void resolver()
	{
		ai.clear();
		ai.add("1");
		ai.add(arreglo.pollLast() + ".+.-");
		ai.add("1");
		while(!arreglo.isEmpty())
		{
			String salida = arreglo.pollLast() + ".+.";
			StringBuilder sb = new StringBuilder(ai.get(ai.size() - 2).length());
			while(sb.length() < ai.get(ai.size() - 2).length())
				sb.append('-');
			salida = salida + sb.toString();
			sb.setLength(0);
			int tamano = ai.get(ai.size() - 2).length() - 1;
			if(tamano % 2 == 1)
				tamano = (tamano / 2) + 1;
			else
				tamano = tamano / 2;
			while(sb.length() < tamano)
			{
				sb.append('.');
			}
			String salida2 = 1 + sb.toString();
			ai.add(salida);
			ai.add(salida2);
		}
		Collections.reverse(ai);
		int tamMaximo = 0;
		for(String s : ai)
		{
			tamMaximo = Math.max(tamMaximo, s.length());
		}
		for(String s : ai)
		{
			int cuenta = s.length();
			while(cuenta++ != tamMaximo)
				System.out.print('.');
			System.out.println(s);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			BigInteger a = sc.nextBigInteger();
			BigInteger b = sc.nextBigInteger();
			if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))
				return;
			System.out.println("Case " + caso++ + ":");
			System.out.println(a + " / " + b);
			iterar(a, b);
			resolver();
		}
	}
}
