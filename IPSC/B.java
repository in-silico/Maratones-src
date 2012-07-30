import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class B 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for(int i = 0; i < t; i++)
		{
			br.readLine();
			int n = Integer.valueOf(br.readLine());
			BigInteger cuenta = BigInteger.ZERO;
			for(int j = 0; j < n; j++)
				cuenta = cuenta.add(new BigInteger(br.readLine()));
			System.out.println(cuenta.mod(new BigInteger("" + n)).equals(BigInteger.ZERO) ? "YES" : "NO");
		}
	}

}
