import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class B 
{
	public static void main(String[] args) throws IOException
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap <Integer, Integer> mapa = new TreeMap<Integer, Integer> ();
		while(true)
		{
			String[] pedazos = br.readLine().split("\\s+");
			int a = Integer.parseInt(pedazos[0]);
			if(a == 0)
				return;
			else if(a == 2)
			{
				if(mapa.isEmpty())
					System.out.println("0");
				else
				{
					System.out.println(mapa.pollLastEntry().getValue());
				}
			}
			else if(a == 3)
			{
				if(mapa.isEmpty())
					System.out.println("0");
				else
				{
					System.out.println(mapa.pollFirstEntry().getValue());
				}
			}
			else
			{
				mapa.put(Integer.parseInt(pedazos[2]), Integer.parseInt(pedazos[1]));
			}
		}
	}
}