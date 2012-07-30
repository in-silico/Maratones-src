import java.util.Scanner;


public class E
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int nPaginas = sc.nextInt();
			if(nPaginas == 0)
				return;
			String[] split = sc.next().split(",");
			boolean[] impresa = new boolean[nPaginas + 1];
			for(String s : split)
			{
				if(s.contains("-"))
				{
					int a = Integer.parseInt(s.split("\\-")[0]);
					int b = Integer.parseInt(s.split("\\-")[1]);
					for(int i = a; i <= b && i <= nPaginas; i++)
						impresa[i] = true;
				}
				else
				{
					int a = Integer.parseInt(s);
					if(a <= nPaginas)
						impresa[a] = true;
				}
			}
			int numero = 0;
			for(int i = 1; i <= nPaginas; i++)
				if(impresa[i])
					numero++;
			System.out.println(numero);
		}
	}

}
