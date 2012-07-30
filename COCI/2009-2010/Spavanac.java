import java.util.Scanner;


public class Spavanac 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		m -= 45;
		if(m < 0)
		{
			h--;
			if(h < 0)
				h = 23;
			m = 60 + m;
		}
		System.out.println(h + " " + m);
	}

}
