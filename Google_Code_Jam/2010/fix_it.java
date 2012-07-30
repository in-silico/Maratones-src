import java.util.*;
import java.io.*;

/**
 *
 * @author sebastian
 */
public class Test {
    
    static class PathTree {
        String name;
        Hashtable<String,PathTree> subdirs = new Hashtable<String, PathTree>();
    }

    static int solve(Scanner in) {
        int N=in.nextInt(), M=in.nextInt();
        int total=0;
        in.nextLine();
        PathTree root = new PathTree();

        for (int i=0; i<N; i++) {
            String p = in.nextLine();
            StringTokenizer tok = new StringTokenizer(p,"/");
            PathTree act = root;
            while (tok.hasMoreTokens()) {
                String name = tok.nextToken();
                if (!act.subdirs.containsKey(name)) {
                    act.subdirs.put(name, new PathTree());
                }
                act = act.subdirs.get(name);
            }
        }

        for (int i=0; i<M; i++) {
            String p = in.nextLine();
            StringTokenizer tok = new StringTokenizer(p,"/");
            PathTree act = root;
            while (tok.hasMoreTokens()) {
                String name = tok.nextToken();
                if (!act.subdirs.containsKey(name)) {
                    act.subdirs.put(name, new PathTree());
                    total++;
                }
                act = act.subdirs.get(name);
            }
        }

        return total;
    }

    public static void main(String args[]) throws Exception {
    	Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int s = solve(in);
            System.out.printf("Case #%d: %d\n", tc, s);
        }
    }

}
