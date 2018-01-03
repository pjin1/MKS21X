import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int current, last;
    private SuperArray ary;
	
    public SuperArrayIterator(SuperArray arr, int start, int end){
    		current = start;
		last = end;
    		ary = new SuperArray(arr.size());
    		for (int i = 0; i < arr.size(); i++){
    			ary.add(arr.get(i));
    		}
    }
    
    public boolean hasNext(){
    		return current <= last;
	}
    
    public String next(){
    		try{
    			current++;
    			return ary.remove(0);
    		}catch(NoSuchElementException e){
    			throw e;
    		}
    }
    
    public void remove(){
    		throw new UnsupportedOperationException();
    }
 }
 	
 
