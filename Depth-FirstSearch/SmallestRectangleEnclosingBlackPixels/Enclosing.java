import java.util.Arrays;

public class Enclosing{
	public static int minArea(char[][] image, int x, int y){
		int m=image.length;
		if(m==0) return 0;
		int n=image[0].length;
		if(n==0) return 0;

		int[] bound=new int[4];
		bound[1]=m-1;
		bound[3]=n-1;

		bfs(image,x,y,bound);
		return (bound[0]-bound[1]+1)*(bound[2]-bound[3]+1);		
	}

	private static void bfs(char[][] image, int x, int y, int[] bound){
		int m=image.length;
		int n=image[0].length;

		if(x<0 || x>=m || y<0 || y>=n) return;
		if(image[x][y]=='0') return;

		image[x][y]='0';
		bound[0]=Math.max(bound[0],x);
		bound[1]=Math.min(bound[1],x);
		bound[2]=Math.max(bound[2],y);
		bound[3]=Math.min(bound[3],y);

		bfs(image,x+1,y,bound);
		bfs(image,x-1,y,bound);
		bfs(image,x,y+1,bound);
		bfs(image,x,y-1,bound);
	}

	public static void main(String[] args) {
		char[][] image={{'0','0','1','0'},
  						{'0','1','1','0'},
  						{'0','1','0','0'}};
  		int x=0;
  		int y=2;
  		System.out.println("The image is: ");
  		for(char[] c:image)
  			System.out.println(Arrays.toString(c));
  		System.out.println("The area enclosing pixel at ("+x+","+y+") is: "+minArea(image,x,y));
	}
}