import java.util.*;
import java.io.*;

public class SuperArrayIterator implements Iterator<String>{
    private int i;
    private SuperArray a;
	
    public SuperArrayIterator(SuperArray arr){
    		a = new SuperArray(arr.size());
    		for (int j = 0; j < arr.size(); j++){
    			a.add(arr.get(j));
    		}
    		i = 0;
    }
    
    public boolean hasNext(){
    		return a.size() != 0;
	}
    
    public String next(){
    		try{
    			i+=1;
    			return a.remove(0);
    		}catch(NoSuchElementException e){
    			throw e;
    		}
    }
    
    public void remove(){
    		throw new UnsupportedOperationException();
    }
 }
 	
 
