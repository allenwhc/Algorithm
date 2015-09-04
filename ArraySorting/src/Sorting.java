import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
	//Bubble Sort, O(n^2), constant space
	public static int[] bubbleSort(int[] nums){
		int n=nums.length;
		int[] res=nums;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(res[i]>res[j]){
					int temp=res[i];
					res[i]=res[j];
					res[j]=temp;
				}
			}
		}
		
		return res;
	}
	
	//Quick Sort, O(nlogn), constant space
	public static int[] quickSort(int[] nums, int left, int right){
		//int n=nums.length;
		int[] res=nums;
		int i=left, j=right;
		int temp=0;
		int pivot=res[(left+right)/2];
		while(i<=j){
			while(res[i]<pivot) i++;
			while(res[j]>pivot) j--;
			if(i<=j){
				temp=res[j];
				res[i]=res[j];
				res[j]=temp;
				i++;
				j--;
			}
		}
		return res;
	}
	
	//Merge sort, O(nlogn) time complexity, O(n) space
	public static int[] mergeSort(int[] nums){
		int n=nums.length;
		int[] res=nums;
		if(n>1){
			int firstHalfLen=n/2;
			int secondHalfLen=n-firstHalfLen;
			int[] arr1=new int[firstHalfLen];
			int[] arr2=new int[secondHalfLen];
			for(int i=0; i<firstHalfLen; i++) arr1[i]=nums[i];
			for(int i=firstHalfLen; i<n; i++) arr2[i-firstHalfLen]=nums[i];
			
			//Recursively divides the array into two halves
			arr1=mergeSort(arr1);
			arr2=mergeSort(arr2);
			
			int i=0;	//Stores the index of the main array
			int j=0;	//Stores the index of the current first-half array
			int k=0;	//Stores the index of the current second-half array
			
			while(j!=arr1.length && k!=arr2.length){
				if(arr1[j]<arr2[k]){
					res[i]=arr1[j];
					i++;
					j++;
				}
				else{
					res[i]=arr2[k];
					i++;
					k++;
				}
			}
			while(arr1.length!=j){
				res[i]=arr1[j];
				i++;
				j++;
			}
			while(arr2.length!=k){
				res[i]=arr2[k];
				i++;
				k++;
			}
		}
		
		return res;
	}
	
	//Bucket Sort, O(n) time complexity, O(n) space
	public static int[] bucketSort(int[] nums){
		int n=nums.length;
		int maxValue=Integer.MIN_VALUE;
		int minValue=Integer.MAX_VALUE;
		for(int i:nums){
			maxValue=Math.max(maxValue, i);
			minValue=Math.min(minValue, i);
		}
		
		int bucketSize=(maxValue-minValue)/(n-1)+1;
		int noBuckets=(maxValue-minValue)/bucketSize+1;
		//System.out.println(bucketSize+","+noBuckets);
		
		List<List<Integer>> bucket=new ArrayList<List<Integer>>();
		for(int i=0; i<noBuckets; i++)
			bucket.add(new ArrayList<Integer>());
		for(int i=0; i<n; i++){
			int index=(nums[i]-minValue)/bucketSize;
			bucket.get(index).add(nums[i]);
		}
		
		List<Integer> sortResult=new ArrayList<>();
		for(List<Integer> l:bucket){
			if(l.isEmpty()) continue;
			for(int i:l){
				sortResult.add(i);
			}
		}
		int[] result=new int[sortResult.size()];
		for(int i=0; i<sortResult.size(); i++)
			result[i]=sortResult.get(i);
		return result;
	}
	
	//Main
	public static void main(String[] args){
		int[] nums={14,1,2,7,3,2,5,4,8,6,0,11,17};
		System.out.println("The unsorted array is: "+Arrays.toString(nums));
		long startTime1=System.nanoTime();
		System.out.println("The bubble sort result is:"+Arrays.toString(bubbleSort(nums)));
		long endTime1=System.nanoTime();
		System.out.println("Bubble sort takes "+(double)(endTime1-startTime1)/1000+" ms");
		long startTime2=System.nanoTime();
		System.out.println("The quick sort result is:"+Arrays.toString(quickSort(nums, 0, nums.length-1)));
		long endTime2=System.nanoTime();
		System.out.println("Quick sort takes "+(double)(endTime2-startTime2)/1000+" ms");
		long startTime3=System.nanoTime();
		System.out.println("The merge sort result is:"+Arrays.toString(mergeSort(nums)));
		long endTime3=System.nanoTime();
		System.out.println("Merge sort takes "+(double)(endTime3-startTime3)/1000+" ms");
		long startTime4=System.nanoTime();
		System.out.println("The bucket sort result is:"+Arrays.toString(bucketSort(nums)));
		long endTime4=System.nanoTime();
		System.out.println("Bucket sort takes "+(double)(endTime4-startTime4)/1000+" ms");
	}
}
