package UVA;
import java.math.BigInteger;
import java.util.Scanner;


public class gray 
{

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int numero = sc.nextInt();
			String palabra1 = sc.next();
			char[] palabra = palabra1.toCharArray();
			if(numero == 0 && palabra1.equals("0"))
				return;
			for(int i = 1; i < palabra.length; i++)
			{
				if(palabra[i - 1] == '1')
				{
					if(palabra[i] == '0')
						palabra[i] = '1';
					else
						palabra[i] = '0';
				}
			}
			BigInteger b1 = new BigInteger(new String(palabra), 2);
			BigInteger b2 = new BigInteger("2").pow(palabra.length).subtract(BigInteger.ONE);
			if(b2.subtract(b1).compareTo(new BigInteger(numero + "")) < 0)
			{
				numero -= b2.subtract(b1).intValue() + 1;
				numero %= b2.compareTo(new BigInteger(Integer.MAX_VALUE + "")) >= 0 ? Integer.MAX_VALUE : b2.intValue() + 1;
				b1 = BigInteger.ZERO;
			}
			b1 = b1.add(new BigInteger(numero + ""));
			String sn = "";
			while(!b1.equals(BigInteger.ZERO))
			{
				sn = b1.mod(new BigInteger("2")) + "" + sn;
				b1 = b1.shiftRight(1);
			}
			while(sn.length() != palabra.length)
			{
				sn = "0" + sn;
			}
			char[] palabraNueva = new char[palabra.length];
			palabraNueva[0] = sn.charAt(0);
			palabra = sn.toCharArray();
			for(int i = 1; i < palabra.length; i++)
			{
				palabraNueva[i] = ((Integer.parseInt(palabra[i] + "") + Integer.parseInt(palabra[i - 1] + "")) % 2) == 0 ? '0' : '1';
			}
			String salida = new String(palabraNueva);
			System.out.println(salida);
		}
	}
}
