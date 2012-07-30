import java.util.Scanner;

public class C 
{
	public static int iterar(double b, double w, double c)
	{
		double bB = b * 16, wB = 0, bW = 0, wW = w * 16;
		for(int i = 1; true; i++)
		{
			double bDelta = (bB * c) / (bB + wB);
			double wDelta = (wB * c) / (bB + wB);
			bW += bDelta;
			wW += wDelta;
			bB -= bDelta;
			wB -= wDelta;
			bDelta = (bW * c) / (bW + wW);
			wDelta = (wW * c) / (bW + wW);
			bB += bDelta;
			wB += wDelta;
			bW -= bDelta;
			wW -= wDelta;
			if(Math.abs(bB / wB - b / w) <= 0.00001 && Math.abs(bW / wW - b / w) <= 0.00001)
				return i;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int b = sc.nextInt();
			int w = sc.nextInt();
			int c = sc.nextInt();
			if(b == 0 && w == 0 && c == 0)
				return;
			System.out.println(iterar(b, w, c));
		}
	}
}
