import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AddParentheses{
	public static List<Integer> diffWaysToCompute(String input) {
        return divideAndConquer(input,0,0);
    }

    private static List<Integer> divideAndConquer(String input, int idx, int value){
    	List<Integer> result=new ArrayList<Integer>();
    	//idx=0;
    	for(; idx<input.length() && Character.isDigit(input.charAt(idx)); idx++)
    		value=value*10+input.charAt(idx)-'0';
    	if(idx==input.length()){
    		List<Integer> num=new ArrayList<Integer>();
    		num.add(value);
    		return num;
    	}

    	for(int i=0; i<input.length(); i++){
    		if(!Character.isDigit(input.charAt(i))){
	    		List<Integer> left=divideAndConquer(input.substring(0,i),0,0);
	    		List<Integer> right=divideAndConquer(input.substring(i+1),0,0);
	    		for(int j=0; j<left.size(); j++){
	    			for(int k=0; k<right.size(); k++){
						switch (input.charAt(i)) {
							case '+':
								result.add(left.get(j)+right.get(k));
								break;
							case '-':
								result.add(left.get(j)-right.get(k));
								break;
							case '*':
								result.add(left.get(j)*right.get(k));
								break;
							default:
								break;
							
						}
	    			}
	    		}
    		 }
    	}
    	return result;
    }

    public static void main(String[] args) {
    	String input="2*3-4*5";
    	System.out.println("All results of '"+input+"' are: ");
    	System.out.println(Arrays.deepToString(diffWaysToCompute(input).toArray()));
    }
}