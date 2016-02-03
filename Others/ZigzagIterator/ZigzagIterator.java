import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ZigzagIterator {

	static Iterator<Integer> it1;
	static Iterator<Integer> it2;
	static Iterator<Integer> it;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1=v1.iterator();
        it2=v2.iterator();
    }

    public static int next() {
    	if(it1.hasNext()){
    		it=it1;
    		it1=it2;
    		it2=it;
    	}
    	return it2.next();
    }

    public static boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }

    public static void main(String[] args) {
    	List<Integer> v1=new ArrayList<Integer>(Arrays.asList(1,2));
    	List<Integer> v2=new ArrayList<Integer>(Arrays.asList(3,4,5,6));
    	ZigzagIterator z=new ZigzagIterator(v1,v2);
    	while(z.hasNext())
    		System.out.print(z.next()+" ");
    	System.out.println();
    }
}