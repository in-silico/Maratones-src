import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class A 
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] partes = br.readLine().split(" ");
			if(partes[0].equals("0") && partes[1].equals("0"))
				return;
			char a = partes[0].charAt(0);
			String bigInt = partes[1].replace(a + "", "");
			while(bigInt.length() > 0 && bigInt.charAt(0) == '0')
				bigInt = bigInt.substring(1);
			if(bigInt.length() == 0)
				System.out.println("0");
			else
				System.out.println(new BigInteger(bigInt));
		}
	}
}
