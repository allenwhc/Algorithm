public class ContainerMaxWater{
	public static int maxArea(int[] height){
		int n=height.length;
		if(n==0) return 0;

		int maxWater=0;
		int i=0, j=n-1;

		while(i<j){
			maxWater=Math.max(maxWater,Math.min(height[i],height[j])*(j-i));
			if(height[i]<height[j]) i++;
			else j--;
		}

		return maxWater;
	}

	public static void main(String[] args) {
		int[] height={5, 2, 7, 9, 1, 6, 3, 8, 4, 10};
		System.out.println("Max water="+maxArea(height));
	}
}