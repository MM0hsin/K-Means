import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Coderunner {

	public static void main(String[] args) {
		
		int g[][] = {
				{0,1,0,0,1},
				{1,0,1,0,0},
				{0,1,0,1,1},
				{0,0,1,0,0},
				{1,0,1,0,0}
				};
		

		
		System.out.println(MDGCheck(g));
		System.out.println(MDGCheck(p36()));

		System.out.println(cluster36());
		System.out.println(fitness(cluster36(),p36()));
	}
	
	public static int[][] p36(){
		
		
		int[][]p36=new int[36][36];
		
		try {
			Scanner fil = new Scanner(new File("./src/Perfect36.txt"));
			while(fil.hasNextLine()) {
		         for (int i=0; i<p36.length; i++) {
		            String[] line = fil.nextLine().trim().split(" ");
		            for (int j=0; j<line.length; j++) {
		               p36[i][j] = Integer.parseInt(line[j]);
		            }
		         }
		      }
			System.out.println(Arrays.deepToString(p36));
			
		} catch (FileNotFoundException e) {
			System.out.println("invalid file path");
			e.printStackTrace();
			return p36;
		}
		
		
		return p36;
		
	}
	
	public static ArrayList<Integer> cluster36(){
		
		int[] n = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8};
		ArrayList<Integer> cluster36 = new ArrayList<Integer>();
		
		
		for (int i = 0; i< n.length;i++) {
			cluster36.add(n[i]);
		}
		return cluster36;
		
	}
	
	
	public static boolean MDGCheck(int g[][]) {
		
		int r = g.length;
		int c = g[0].length;
		System.out.println("r " + r + " c " + c);
		
		int flag = 1;

		int[][] transpose = new int[r][c];
		
		for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                transpose[j][i] = g[i][j];
            }
        }
		
		
		if (r == c) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j] != transpose[i][j]) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) {
                   return false;
                }
            }
            if (flag == 1) {
                return true;
            }
        }
 
        else {
 
            return false;
        }
		return false;
	}
	
	public static ArrayList<Integer> cluster() {
		
		ArrayList<Integer> cluster = new ArrayList<Integer>();
		
		int n = 5;
		
		for(int i = 0; i <= n; i++) {
			cluster.add(i);
		}
		return  cluster;
	}
	
	public static double fitness(ArrayList<Integer> cluster, int g[][]) {
		
		
		int n = g.length;
		double EVM = 0;
		
		for(int j = 0; j < (n-1); j++) {
			for(int k = (j+1); k < n; k++) {
				
				int c1 = cluster.get(j);
				int c2 = cluster.get(k);
				
				if(c1==c2) {
					EVM = EVM + 2*(g[j][k]) -1;
				}
				
			}
		}
		return EVM;
	}
	
	public static ArrayList<Integer> rndCluster(ArrayList<Integer> cluster){
		
		ArrayList<Integer> cluster2= new ArrayList<Integer>();
		int rand = (int) ((Math.random() * ((cluster.size())-0) + 0));
		
		
		
		return cluster2;
	}
}
