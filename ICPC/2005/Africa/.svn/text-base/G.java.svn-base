import java.math.BigDecimal;
import java.util.Scanner;


public class G 
{
	static BigDecimal pi = new BigDecimal("3.1415926535897932384626433832795");
	static BigDecimal a = pi.divide(new BigDecimal(6), 100, BigDecimal.ROUND_HALF_EVEN);
	static BigDecimal b = pi.divide(new BigDecimal(360), 100, BigDecimal.ROUND_HALF_EVEN);
	static BigDecimal c = pi.divide(new BigDecimal(21600), 100, BigDecimal.ROUND_HALF_EVEN);
	static BigDecimal d = pi.divide(new BigDecimal(2160000), 100, BigDecimal.ROUND_HALF_EVEN);
	
	
	public static BigDecimal angulo(BigDecimal h, BigDecimal m, BigDecimal s, BigDecimal u)
	{
		return a.multiply(h).add(b.multiply(m)).add(c.multiply(s)).add(d.multiply(u));
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		for(int i = 0; i < d; i++)
		{
			BigDecimal h = sc.nextBigDecimal();
			BigDecimal m = sc.nextBigDecimal();
			BigDecimal s = sc.nextBigDecimal();
			BigDecimal u = sc.nextBigDecimal();
			BigDecimal h_0 = sc.nextBigDecimal();
			BigDecimal m_0 = sc.nextBigDecimal();
			BigDecimal s_0 = sc.nextBigDecimal();
			BigDecimal u_0 = sc.nextBigDecimal();
			BigDecimal uno = angulo(h, m, s, u);
			BigDecimal dos = angulo(h_0, m_0, s_0, u_0);
			BigDecimal radio = sc.nextBigDecimal();
			BigDecimal res = dos.subtract(uno).multiply(radio.multiply(radio)).divide(new BigDecimal(2), 3, BigDecimal.ROUND_HALF_UP);
			System.out.println((i + 1) + ". " + res);
		}
	}

}
