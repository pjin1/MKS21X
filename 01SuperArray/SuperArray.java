public class SuperArray implements Iterable<String>{
	
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        size = 0;
    }
    
    public SuperArray(int capacity) {
    		data = new String[capacity];
        size = 0;
    }

    public void clear() {
        data = new String[data.length];
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
        size ++;
        return true;
    }
    
    public String toString() {
    	String a = "[";
        for (int i = 0 ; i < data.length ; i++) {
            a += data[i];
            if (i != data.length - 1){
			    a += ", ";
			}
        }
        return a + "]";
    }

    public String get(int index){
    	if (index < 0 || index >= size()) {
    		System.out.println("error");
    		return null;
    	}
        return data[index];
    }

    public String set(int index, String element) {
    	if (index < 0 || index >= size()) {
    		System.out.println("error");
    		return null;
    	}
    	String a = data[index];
    	data[index] = element;
    	if (index >= size){
			size++;
	    }
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
		if (index < 0 || index >= size){
	    	System.out.println("Error");
		}
		if (index == size){
	    	add(element);
		}
		if (index < size){
	    	size++;
	    	resize();
	    	for (int i = size - 1; i > index; i--){
				data[i] = data[i-1];
	    	}
	    	data[index] = element;
		}
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
		int last = -1;
		for (int i = 0; i < size; i++){
	    	if (data[i].equals(element)){
				last = i;
	    	}
		}
		return last;
    }

    public String remove(int index){
		if (index < 0 || index >= size){
	    	System.out.println("Error");
	    	return null;
		}
		String a = data[index];
		String[] temp = new String[size - 1];
		for (int i = 0; i < index; i++){
	    	temp[i] = data[i];
		}
		size--;
		for (int i = index; i < size; i++){
	    	temp[i] = data[i+1];
		}
		data = temp;
		return a;
    }
	
    public boolean remove(String element){
		if (contains(element)){
	    	remove(indexOf(element));
	    	return true;
		}
		return false;
    }
}
    


