import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Date 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int month = Integer.parseInt(pedazos[0]);
			int day = Integer.parseInt(pedazos[1]);
			int year = Integer.parseInt(pedazos[2]);
			if(month == 0 && day == 0 && year == 0)
				return;
			month -= 1;
			GregorianCalendar gc = new GregorianCalendar();
			if(year > 1752 || (year == 1752 && month > 8) || (year == 1752 && month == 8 && day > 2))
				gc.setGregorianChange(new java.util.Date(Long.MIN_VALUE));
			else
				gc.setGregorianChange(new java.util.Date(Long.MAX_VALUE));
			gc.set(year, month, day);
			if(gc.get(GregorianCalendar.DAY_OF_MONTH) != day || gc.get(GregorianCalendar.MONTH) != month || (year == 1752 && month == 8 && day > 2 && day < 14))
			{
				System.out.println((month + 1) + "/" + day + "/" + year + " is an invalid date.");
			}
			else
			{
				System.out.println(gc.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.US) + " " + day + ", " + year + " is a " + gc.getDisplayName(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.LONG, Locale.US));
			}
		}
	}

}
