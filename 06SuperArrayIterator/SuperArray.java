import java.util.*;

public class SuperArray implements Iterable<String> {
	
    private String[] data;
    private int size = 0;
    private int start, end;
    
    public SuperArray() {
        data = new String[10];
    }
    
    public SuperArray(int capacity) {
    		data = new String[capacity];
    }

    public void clear() {
        data = new String[10];
		size = 0;
    }

    public int size() {
        return size;
    }
	
	public boolean isEmpty(){
		return size == 0;
    }

    public boolean add(String element) {
        if (data.length == size) {
            resize();
        }
        data[size] = element;
        size++;
        return true;
    }
    
    public String toString() {
	    	if (size == 0){
	    	    return "[]";
	    	}
    		String a = "[";
        for (int i = 0 ; i < size() - 1 ; i++) {
            a += data[i];
            a += ", ";	
        }
        return a + data[size()-1] + "]";
    }

    public String get(int index){
	    	if (index < 0 || index >= size()) {
	    		throw new IndexOutOfBoundsException();
	    	}
	        return data[index];
    }

    public String set(int index, String element) {
    		if (index < 0 || index >= size()) {
    			throw new IndexOutOfBoundsException();
	    	}
	    	String a = data[index];
	    	data[index] = element;
	   
	    	return a;
    }
    
    private void resize(){
    		String[] a = new String[size * 2];
		for (int i = 0; i < size; i++){
	    		a[i] = data[i];
		}
		data = a;
    }
    
    public boolean contains(String element){
		for (int i = 0; i < size; i++){
		    	if (data[i].equals(element)){
				return true;
		    	}
		}
		return false;
    }
    
    public void add(int index, String element){
    		if(data.length == size) {
    			resize();
    		}
    		String[] temp = new String[data.length];
    	
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		if (data.length == size){
	    		resize();
		}
		
		for (int i = 0; i < index; i++){
			temp[i] = data[i];
		}
		temp[index] = element;
		for (int i=index; i<size; i++){
		    temp[i+1] = data[i];
		}
		data = temp;
		size+=1;
    }
    
    public int indexOf(String element){
		for (int i = 0; i < size; i++){
		    	if (data[i].equals(element)){
					return i;
		    	}
		}
		return -1;
    }

    public int lastIndexOf(String element){
		for (int i = size-1 ; i >= 0 ; i--){
		    	if (data[i].equals(element)){
					return i;
		    	}
		}
		return -1;
    }

    public String remove(int index){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		String a = data[index];
		String[] temp = new String[size - 1];
		for (int i = 0; i < index; i++){
			temp[i] = data[i];
		}
		for (int i = index; i < size - 1 ; i++){
	    		temp[i] = data[i+1];
		}
		data = temp;
		size -= 1;
		return a;
    }
	
    public boolean remove(String element){
		if (contains(element)){
	    		remove(indexOf(element));
	    		return true;
		}
		return false;
    }
   
    public Iterator<String> iterator(){
    		return new SuperArrayIterator(this,0, size() - 1);
    }

}
    


