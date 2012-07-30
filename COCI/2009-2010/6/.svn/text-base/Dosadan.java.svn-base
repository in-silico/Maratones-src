import java.util.Scanner;


public class Dosadan
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			boolean paso = false;
			int valor = sc.nextInt(16);
			int valorA = (char) valor;
			for(char a = '0'; a <= '9'; a++)
			{
				char uno = (char) (a ^ valorA);
				if(uno == '.' || uno == ' ')
				{
					paso = true;
					System.out.print(".");
					break;
				}
			}
			if(!paso)
				System.out.print("-");
		}
		System.out.println();
	}

}
