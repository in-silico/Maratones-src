import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Alpha
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea = br.readLine()) != null)
		{
			System.out.println(linea.split(" ")[1].charAt(linea.split(" ")[1].length() - 1));
		}
	}

}
