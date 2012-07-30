import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class C 
{	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException
	{
		int caso = 1;
		while(true)
		{
			String s = br.readLine();
			if(s.trim().equals("0.00 0.00 0"))
				return;
			String[] pedazos = s.split(" ");
			BigDecimal actual = new BigDecimal(pedazos[0]);
			BigDecimal interes = new BigDecimal(pedazos[1]).divide(new BigDecimal("100"), 100, BigDecimal.ROUND_DOWN);
			int intervalos = Integer.parseInt(pedazos[2]);
			interes = interes.divide(new BigDecimal(intervalos), 100, BigDecimal.ROUND_DOWN);
			for(int i = 0; i < intervalos; i++)
			{
				BigDecimal siguiente = actual.multiply(interes).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_DOWN);
				actual = actual.add(siguiente);
			}
			System.out.println("Case " + caso++ + ". $" + pedazos[0] + " at " + pedazos[1] + "% APR compounded " + intervalos + " times yields $" + actual);
		}
	}
}

