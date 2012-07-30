import java.util.Scanner;


public class Kino
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean antesLove = false;
		int cuenta = 2;
		int i = 0;
		for(char c : sc.next().toCharArray())
		{
			if(++i == n)
				break;
			if(c == 'L')
			{
				if(antesLove)
				{
					cuenta++;
					antesLove = false;
				}
				else
					antesLove = true;
			}
			else
			{
				antesLove = false;
				cuenta++;
			}	
		}
		System.out.println(Math.min(n, cuenta));
	}

}
