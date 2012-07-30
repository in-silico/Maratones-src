import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class A 
{
	public static int solve(int w, int h, String[] words)
	{
		int size = 0;
		out: 
		for(int i = 1; true; i++)
		{
			int currentWidth = 0;
			int currentHeight = 0;
			for(int j = 1; j < words.length; j++)
			{
				if(currentWidth != 0)
					currentWidth += i;
				currentWidth += words[j].length() * i;
				if(currentWidth > w)
				{
					currentWidth = 0;
					currentHeight += i;
					j--;
				}
				if(currentHeight > h)
					break out;
			}
			currentHeight += i;
			if(currentHeight > h)
				break;
			size = i;
		}
		return size;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("billboards.txt"));
		System.setOut(new PrintStream("billboards.out"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++)
			System.out.println("Case #" + i + ": " + solve(sc.nextInt(), sc.nextInt(), sc.nextLine().split(" ")));
	}

}
