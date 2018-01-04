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
    		try{
    			current++;
    			return ary.get(current-1);;
    		}catch(NoSuchElementException e){
    			throw e;
    		}
    }
    
    public void remove(){
    		throw new UnsupportedOperationException();
    }
 }
 	
 
