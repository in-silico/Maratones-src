import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Lock
{
	
	static class Loc
	{
		long quien;
		boolean muchos = false;
		boolean exclusivo = false;
		
		public Loc(long q, boolean ex)
		{
			quien = q;
			exclusivo = ex;
		}
		
		public boolean intentar(long q, boolean ex)
		{
			if(exclusivo)
				return quien == q;
			if(ex)
			{
				if(!muchos && quien == q)
				{
					return exclusivo = true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				muchos = muchos || quien != q;
				return true;
			}
		}
	}
	static HashMap <Long, Loc> locks = new HashMap <Long, Loc> (10001);
	static HashMap <Long, Boolean> transactions = new HashMap <Long, Boolean> (10001);
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		while(n-- != 0)
		{
			locks.clear();
			transactions.clear();
			while(true)
			{
				String entrada = br.readLine();
				if(entrada.equals("#"))
				{
					if(n != 0)
					{
						System.out.println();
						br.readLine();
					}
					break;
				}
				String[] pedazos = entrada.split(" ");
				char l = pedazos[0].charAt(0);
				long trid = Long.parseLong(pedazos[1]);
				long item = Long.parseLong(pedazos[2]);
				if(transactions.containsKey(trid))
				{
					System.out.println("IGNORED");
				}
				else if(locks.containsKey(item))
				{
					Loc loc = locks.get(item);
					if(!loc.intentar(trid, l == 'X'))
					{
						System.out.println("DENIED");
						transactions.put(trid, true);
					}
					else
					{
						System.out.println("GRANTED");
					}
				}
				else
				{
					locks.put(item, new Loc(trid, l == 'X'));
					System.out.println("GRANTED");
				}
			}
		}
	}
	

}
