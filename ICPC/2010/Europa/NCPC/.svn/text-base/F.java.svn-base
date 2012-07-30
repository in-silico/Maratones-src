import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class F {
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.valueOf(rd.readLine());
		String cadena;
		for(int i=0;i<T;i++)
		{
			cadena=rd.readLine();
			if (cadena.equals("P=NP"))
				System.out.println("skipped");
			else if (cadena.contains("+"))
			{
				String[] cadenas=cadena.split("\\+");
				System.out.println(Integer.valueOf(cadenas[0])+Integer.valueOf(cadenas[1]));
			}
		}
	}

}
