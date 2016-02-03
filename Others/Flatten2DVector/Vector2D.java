import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Vector2D{
	static Iterator<List<Integer>> listIt;
	static Iterator<Integer> it;

	public Vector2D(List<List<Integer>> vec2d) {
        listIt=vec2d.iterator();
    }

    public int next() {
        hasNext();
        return it.next();
    }

    public boolean hasNext() {
    	while((it==null || !it.hasNext()) && listIt.hasNext())
    		it=listIt.next().iterator();
        return it!=null && it.hasNext();
    }

    public static void main(String[] args) {
    	List<List<Integer>> vec2d=new ArrayList<List<Integer>>();
    	vec2d.add(new ArrayList<Integer>(Arrays.asList(1,2)));
    	vec2d.add(new ArrayList<Integer>(Arrays.asList(3)));
    	vec2d.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));

    	System.out.println("Original 2D vector: ");
    	for(List<Integer> list: vec2d)
    		System.out.println(Arrays.deepToString(list.toArray()));

    	System.out.println("Flattened 1D vector");
    	Vector2D v=new Vector2D(vec2d);
    	while(v.hasNext())
    		System.out.print(v.next()+" ");
    	System.out.println();
    }
}