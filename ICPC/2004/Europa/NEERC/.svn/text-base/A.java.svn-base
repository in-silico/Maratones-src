import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class A 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String a = br.readLine();
			if(a == null)
				return;
			String b = br.readLine();
			int[] letrasA = new int[26];
			int[] letrasB = new int[26];
			for(char c : a.toCharArray())
				letrasA[c - 'A']++;
			for(char c : b.toCharArray())
				letrasB[c - 'A']++;
			Arrays.sort(letrasA);
			Arrays.sort(letrasB);
			System.out.println(Arrays.equals(letrasA, letrasB) ? "YES" : "NO");
		}
	}
}