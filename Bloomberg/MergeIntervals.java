import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

public class MergeIntervals{
	public static class Interval{
		int start;
		int end;
		Interval(){start=0;end=0;}
		Interval(int s, int e){start=s;end=e;};
	}

	public static List<Interval> merge(List<Interval> intervals){
		int n=intervals.size();
		if(n==0) return new ArrayList<Interval>();
		else if(n==1) return intervals;

		Collections.sort(intervals,new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				Integer s1=i1.start;
				Integer s2=i2.start;
				return s1.compareTo(s2);
			}
		});

		List<Interval> result=new ArrayList<Interval>();
		LinkedList<Interval> q=new LinkedList<Interval>();

		q.offer(intervals.get(0));
		for(int i=1; i<intervals.size(); i++){
			Interval curr=intervals.get(i);
			if(q.size()>0){
				Interval prev=q.pollLast();
				if(curr.start<=prev.end){
					prev.end=Math.max(prev.end,curr.end);
					q.addLast(prev);
				}else {
					q.addLast(prev);
					q.addLast(curr);
				}

			}else q.addLast(intervals.get(i));
		}
		while(q.size()>0) result.add(q.poll());
		return result;
	}

	public static void main(String[] args) {
		Interval i1=new Interval(1,3);
		Interval i2=new Interval(8,10);
		Interval i3=new Interval(2,6);
		Interval i4=new Interval(15,18);
		List<Interval> intervals=new ArrayList<Interval>(Arrays.asList(i1,i2,i3,i4));
		for(Interval i:merge(intervals)){
			System.out.print("["+i.start+","+i.end+"],");
		}
		System.out.println();
	}
}