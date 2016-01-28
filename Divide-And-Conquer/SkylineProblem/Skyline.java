import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Skyline{
	public static List<int[]> getSkyline(int[][] buildings){
		int n=buildings.length;
		if(n==0) return new ArrayList<int[]>();

		List<int[]> skyline=findSkyline(buildings,0,n-1);

		for(int i=0; i<skyline.size(); i++){
			if(i>0 && skyline.get(i)[1]==skyline.get(i-1)[1]){
				skyline.remove(i);
				i--;
			}
		}
		return skyline;
	}

	private static List<int[]> findSkyline(int[][] buildings, int l, int r){
		if(l==r){
			List<int[]> skyline=new ArrayList<int[]>();
			skyline.add(new int[]{buildings[l][0],buildings[l][2]});
			skyline.add(new int[]{buildings[l][1],0});
			return skyline;
		}

		int mid=(l+r)/2;
		List<int[]> skyline1=findSkyline(buildings,l,mid);
		List<int[]> skyline2=findSkyline(buildings,mid+1,r);
		return merge(skyline1,skyline2);
	}	

	private static List<int[]> merge(List<int[]> skyline1, List<int[]> skyline2){
		List<int[]> mergedSkyline=new ArrayList<int[]>();
		for(int[] s:skyline1) 
			System.out.print("("+s[0]+","+s[1]+")");
		System.out.println();
		for(int[] s:skyline2) 
			System.out.print("("+s[0]+","+s[1]+")");	
		int m=skyline1.size();
		int n=skyline2.size();
		int h1=0; //current height of buildings from blds1
		int h2=0; //current height of buildings from blds2

		int i=0, j=0;
		while(i<m && j<n){
			if(skyline1.get(i)[0]<skyline2.get(j)[0]){
				h1=skyline1.get(i)[1];
				mergedSkyline.add(new int[]{skyline1.get(i)[0], Math.max(h1,h2)});
				i++;
			}else if(skyline1.get(i)[0]>skyline2.get(j)[0]){
				h2=skyline2.get(j)[1];
				mergedSkyline.add(new int[]{skyline2.get(j)[0], Math.max(h1,h2)});
				j++;
			}else{
				h1=skyline1.get(i)[1];
				h2=skyline2.get(j)[1];
				mergedSkyline.add(new int[]{skyline1.get(i)[0], Math.max(h1,h2)});
				i++;j++;
			}
		}

		while(i<m){ 
			mergedSkyline.add(new int[]{skyline1.get(i)[0],skyline1.get(i)[1]});
			i++;
		}
		while(j<n){
			mergedSkyline.add(new int[]{skyline2.get(j)[0],skyline2.get(j)[1]});
			j++;
		}
		return mergedSkyline;
	}

	public static void main(String[] args) {
		int[][] buildings={{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} };

        System.out.println("Buildinds are: ");
        for(int[] b:buildings){
        	System.out.print("Left: "+b[0]+", ");
        	System.out.print("Right: "+b[1]+", ");
        	System.out.println("Height: "+b[2]);
        }
		List<int[]> skyline=getSkyline(buildings);
		System.out.println("The Skyline is: "+Arrays.deepToString(skyline.toArray()));
	}
}