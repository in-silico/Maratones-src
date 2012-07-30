import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class A 
{
	
	public static BigInteger leerNumero(String s)
	{
		while(s.length() > 0 && s.charAt(0) == 'V')
		{
			s = s.substring(1);
		}
		if(s.length() == 0)
			s = "V";
		return new BigInteger(s.replace('V', '0').replace('U', '1').replace('C', '2').replace('D', '3'), 4);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println("COWCULATIONS OUTPUT");
		for(int i = 0; i < n; i++)
		{
			BigInteger val1 = leerNumero(br.readLine());
			BigInteger val2 = leerNumero(br.readLine());
			for(int j = 0; j < 3; j++)
			{
				char posible = br.readLine().charAt(0);
				if(posible == 'A')
				{
					val2 = val2.add(val1);
				}
				else if(posible == 'R')
				{
					val2 = val2.divide(new BigInteger("4"));
				}
				else if(posible == 'L')
				{
					val2 = val2.multiply(new BigInteger("4"));
				}
			}
			BigInteger respuesta = leerNumero(br.readLine());
			if(respuesta.equals(val2))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		System.out.println("END OF OUTPUT");
	}

}
