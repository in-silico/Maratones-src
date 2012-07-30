import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class a 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			String neck = br.readLine();
			int mejor = Integer.MIN_VALUE;
			for(int i = 0; i <= neck.length(); i++)
			{
				String posible = neck.substring(i, neck.length()) + neck.substring(0, i);
				int cuenta = 0;
				char color = posible.charAt(0);
				if(color == 'w')
					for(int j = 0; j < neck.length(); j++)
					{
						if(posible.charAt(j) != 'w')
						{
							color = posible.charAt(j);
							break;
						}
					}
				for(int j = 0; j < neck.length(); j++)
				{
					if(posible.charAt(j) == color || posible.charAt(j) == 'w')
						cuenta++;
					else
						break;
				}
				color = posible.charAt(posible.length() - 1);
				if(color == 'w')
					for(int j = posible.length() - 1; j >= 0; j--)
					{
						if(posible.charAt(j) != 'w')
						{
							color = posible.charAt(j);
							break;
						}
					}
				for(int j = posible.length() - 1; j >= 0; j--)
				{
					if(posible.charAt(j) == color || posible.charAt(j) == 'w')
						cuenta++;
					else
						break;
				}
				if(cuenta >= neck.length())
				{
					cuenta = neck.length();
				}
				mejor = Math.max(mejor, cuenta);
			}
			System.out.println(mejor);
		}
	}

}
