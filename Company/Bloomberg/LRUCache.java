import java.util.HashMap;

public class LRUCache{
	public static class Cache{
		int val;
		int key;
		Cache next, prev;
		public Cache(int k, int v){
			val=v;
			key=k;
			prev=null; next=null;
		}
	}

	private static HashMap<Integer, Cache> map;
	private static int c;
	private static Cache head;
	private static Cache end;

	public LRUCache(int capacity){
		c=capacity;
		head=null; end=null;
		map=new HashMap<Integer,Cache>();
	}

	public static int get(int key){
		if(map.containsKey(key)){
			delete(map.get(key));
			add(map.get(key));
			return map.get(key).val;
		}else return -1;
	}

	public static void set(int key, int value){
		Cache new_data=new Cache(key,value);
		if(map.containsKey(key)){
			delete(map.get(key));
			add(new_data);
			map.put(key,new_data);

		}else{
			if(map.size()<c){
				add(new_data);
				map.put(key,new_data);
			}else{
				map.remove(end.key);
				delete(end);
				add(new_data);
				map.put(key,new_data);
			}
		}
		
	}

	private static void delete(Cache cache){
		Cache prev=cache.prev;
		Cache next=cache.next;

		if(prev!=null) prev.next=next;
		else head=next;

		if(next!=null) next.prev=prev;
		else end=prev;
	}

	private static void add(Cache cache){
		cache.next=head;
		cache.prev=null;
		if(head!=null) head.prev=cache;
		head=cache;
		if(end==null) end=cache;
	}

	public static void main(String[] args) {
		LRUCache lru=new LRUCache(2);
		lru.set(2,1);
		System.out.println(lru.get(2));
	}
}