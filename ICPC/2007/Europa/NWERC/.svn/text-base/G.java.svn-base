import java.io.IOException;
import java.util.Scanner;


public class G 
{
	
	public static String slump(String entrada)
	{
		try
		{
			if(entrada.charAt(0) == 'D' || entrada.charAt(0) == 'E')
			{
				if(entrada.charAt(1) == 'F')
				{
					int indice;
					for(indice = 1; indice < entrada.length(); indice++)
					{
						if(entrada.charAt(indice) != 'F')
							break;
					}
					if(entrada.charAt(indice) == 'G' && indice + 1 == entrada.length())
						return entrada;
					if(slump(entrada.substring(indice)).length() != 0)
						return entrada;
					return "";
				}
				else
				{
					return "";
				}
			}
			else
			{
				return "";
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public static String slimp(String entrada)
	{
		try
		{
			if(entrada.equals("AH"))
				return entrada;
			if(entrada.charAt(0) == 'A')
			{
				if(entrada.charAt(1) == 'B')
				{
					if(entrada.charAt(entrada.length() - 1) == 'C' && slimp(entrada.substring(2, entrada.length() - 1)).length() > 0)
						return entrada;
					return "";
				}
				else if(entrada.charAt(entrada.length() - 1) == 'C' && slump(entrada.substring(1, entrada.length() - 1)).length() > 0)
				{
					return entrada;
				}
				else
				{
					return "";
				}
			}
			else
			{
				return "";
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	static String slurpy(String entrada)
	{
		try
		{
			if(entrada.substring(0, 2).equals("AH"))
			{
				if(slump(entrada.substring(2)).length() > 0)
					return entrada;
				return "";
			}
			if(entrada.charAt(0) == 'A')
			{
				int indice = 0;
				for(char c : entrada.toCharArray())
				{
					try
					{
						if(c == 'C' && slimp(entrada.substring(0, indice + 1)).length() > 0 && slump(entrada.substring(indice + 1)).length() > 0)
							return entrada;
					}
					catch(Exception e)
					{
					}
					indice++;
				}
				return "";
			}
			else
			{
				return "";
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("SLURPYS OUTPUT");	
		for(int i = 0; i < n; i++)
		{
			if(slurpy(sc.next()).length() > 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		System.out.println("END OF OUTPUT");
	}
}
