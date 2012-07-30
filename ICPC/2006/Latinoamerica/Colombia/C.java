import java.util.Scanner;


public class C 
{
	static int babilon(int a, int b, int c)
	{
		int t = Math.abs(c - a);
		int r = t / (b * 3);
		if(((b * 2) == t) || (b == t))
			return 1;
		if((b * 3 * r == t))
			return r;
		else if(((b * 3 * r) + b) == t)
		{
			r++;
			return r;
		}
		else if(((b * 3 * r) + 2 * b) == t)
		{
			r++;
			return r;
		}
		else
			return -1;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 0 && b == 0 && c == 0)
				return;
			int respuesta = babilon(a, b, c);
			if(respuesta == -1)
				System.out.println("No accounting tablet");
			else
				System.out.println(respuesta);
		}
	}
}
