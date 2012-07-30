package UVA;

import java.util.*;

public class alarm {

	public static void main(String[] args) {
		int h1,m1,h2,m2;
		int t1,t2;
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			h1=in.nextInt(); m1=in.nextInt(); h2=in.nextInt(); m2=in.nextInt();
			if (h1 == h2 && h2==m1 && m1==m2 && m2==0) break;
			t1=h1*60 + m1;
			t2=h2*60 + m2;
			if (t1 > t2)
				t2 += 60*24;
			System.out.println(t2-t1);
		}
	}

}
