import java.util.Deque;
import java.util.LinkedList;
import java.util.HashMap;

public class LRUCache{
	public static class Cache{
		int value;
		int key;
		Cache prev;
		Cache next;

		public Cache(int key, int value){
			this.value=value;
			this.key=key;
			prev=null;
			next=null;
		}
	}

	private static HashMap<Integer,Cache> map=new HashMap<Integer,Cache>();
	private static int capacity;
	private static Cache frontEnd=null;
	private static Cache rearEnd=null;

	public LRUCache(int capacity){
		this.capacity=capacity;
	}

	public static int get(int key){
		if(map.containsKey(key)){
			Cache c=map.get(key);
			detach(c);
			setMRU(c);
			return c.value;
		}
		else return -1;	
	}

	public static void set(int key, int value){
		if(map.containsKey(key)){
			Cache exist_cache=map.get(key);
			exist_cache.value=value;
			detach(exist_cache);
			setMRU(exist_cache);
		}else{
			Cache newCache=new Cache(key, value);
			if(map.size()>=capacity){
				map.remove(rearEnd.key);
				detach(rearEnd);
				setMRU(newCache);
			}
			else
				setMRU(newCache);
			map.put(key,newCache);
			//System.out.println("map size:"+map.size());
		}
	}

	private static void detach(Cache c){
		if(c.prev!=null) c.prev.next=c.next;
		else frontEnd=c.next;

		if(c.next!=null) c.next.prev=c.prev;
		else rearEnd=c.prev;
	}

	private static void setMRU(Cache c){
		c.next=frontEnd;
		c.prev=null;
		if(frontEnd!=null) frontEnd.prev=c;
		frontEnd=c;
		if(rearEnd==null) rearEnd=c;
	}

	public static void printCache(){
		System.out.println("Current data in cache: ");
		for(Integer key:map.keySet()){
			System.out.println(key+": "+map.get(key).value);
		}
		System.out.println("Recently used order(most->least): ");
		Cache head=frontEnd;
		while(head!=null){
			System.out.print(head.value);
			head=head.next;
			if(head!=null) System.out.print("->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache lcu=new LRUCache(2);
		System.out.println(lcu.get(2));
		lcu.set(2,6);
		System.out.println(lcu.get(1));
		lcu.set(1,5);
		lcu.set(1,2);
		System.out.println(lcu.get(1));
		System.out.println(lcu.get(2));
		lcu.printCache();
	}
}