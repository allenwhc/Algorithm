import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom{
	public static class Interval{
		int start;
		int end;
		Interval(){start=0;end=0;}
		Interval(int s,int e){start=s;end=e;}
	}

	public static int minMeetingRooms(Interval[] intervals){
		int n=intervals.length;
		sortByStart(intervals);
		PriorityQueue<Interval> queue=new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				Integer e1=i1.end;
				Integer e2=i2.end;
				return e1.compareTo(e2);
			}
		});

		for(int i=0; i<n; i++){
			if(queue.size()==0) queue.offer(intervals[i]);
			else{
				Interval prev_meeting=queue.poll();
				if(intervals[i].start<prev_meeting.end) queue.offer(intervals[i]);
				else prev_meeting.end=intervals[i].end;
				queue.offer(prev_meeting);
			}
		}
		return queue.size();
	}

	private static void sortByStart(Interval[] intervals){
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				Integer s1=i1.start;
				Integer s2=i2.start;
				return s1.compareTo(s2);
			}
		});
	}

	public static void main(String[] args) {
		Interval i1=new Interval(0,30);
		Interval i2=new Interval(15,20);
		Interval i3=new Interval(5,10);
		Interval[] intervals={i1,i2,i3};
		System.out.println("Minimum meeting rooms: "+minMeetingRooms(intervals));
	}
}