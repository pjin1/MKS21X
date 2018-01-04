import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int current, last;
    private SuperArray ary;
	
    public SuperArrayIterator(SuperArray arr, int start, int end){
    		current = start;
		last = end;
    		ary = arr;
    }
    
    public boolean hasNext(){
    		return current <= last;
	}
    
    public String next(){
	    	if(hasNext()) {
	    	    current++;
	    	}
	    	else {
	    	    System.exit(0);
	    	}
	    	return data[current - 1];
    }
    
    public void remove(){
    		throw new UnsupportedOperationException();
    }
 }
 	
 
