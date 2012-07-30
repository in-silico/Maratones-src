package UVA;

import java.text.DecimalFormat;
import java.util.*;

public class rain {
	
	static double l,k, t1, t2, h, a;
	
	static double calcX() {
		double s1, s2;
		s1 = a + k*t1;
		s2 = s1*s1 - 4*k*l*t1;
		return (s1 + Math.sqrt(s2))/2;
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.000000");
		int n;
		double min,max,x;
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		for (int i=0; i<n; i++) {
			l=in.nextDouble();
			k=in.nextDouble();
			t1=in.nextDouble();
			t2=in.nextDouble();
			h=in.nextDouble();
			a = h + t2*k;
			x = calcX();
			min = (h <= l) ? h : x;
			max = (h >= l) ? x : h;
			System.out.println(df.format(min) + " " + df.format(max));
		}
	}
}
