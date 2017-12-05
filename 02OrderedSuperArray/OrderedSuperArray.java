public class OrderedSuperArray extends SuperArray {

	public OrderedSuperArray() {
		super();
	}
	
	public OrderedSuperArray(int capacity) {
		super(capacity);
	}

	public OrderedSuperArray(String [] ary) {
		super(ary.length);
		for (int i=0; i<ary.length; i++) {
			add(ary[i]);
		}
	}
	
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}
	 
	public void add(int index, String value) {
		add(value);
	}

	public boolean add(String value) {
		// add to the correct spot.
		// you may still use super.add(index,value)
		int x = findIndexBinary(value);
		if (x >= size()){
		    super.add(value);
		}
		else {
			super.add(x, value);
		}
		    
		return true;
	}
	
	public int indexOfBinary(String element) {
		if (size() <= 0) {
			return -1;
		}
		int start = 0;
		int end = size()-1;
		int mid;
		while (start!=end) {
			mid=(start+end)/2;
			if (get(mid).compareTo(element)==0) {
				end=mid;
			}
			else if (get(mid).compareTo(element)<0) {
				start=mid+1;
			}
			else {
				end=mid;
			}
		}
		return start;
	}
			
	public int lastIndexOfBinary(String element) {
		if (size() <= 0) {
			return -1;
		}
		int start = indexOfBinary(element);
		int end = size();
		int mid;
		while (start!=end) {
			mid=(start+end)/2;
			if (get(mid).compareTo(element)>0) {
				end=mid;
			}
			else if (get(mid).equals(element)) {
				if (start == size() - 1 || !(get(mid + 1).equals(element))){
				    return mid;
				}
				end = mid;
				start = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		if (get(start) != element){
		    return -1;
		}
		return start;
	}
			
	private int findIndex(String value) {
		int index = size();
		if (size()==0) {
			index = 0;
		}
		for (int i = 0; i < size(); i++) {
			if (value.compareTo(get(i)) >= 0) {
				index = i;
			}
		}
		return index;
	}

	private int findIndexBinary(String value){
		if (size()==0) {
			return 0;
		}
		
		int start = 0;
		int end = size();

		int mid;

		while (start!=end){
			mid = (start+end)/2;
			if (value.compareTo(get(mid))<=0){
				end=mid;
			}
			else {
				start = mid+1;
			}
		}
		
		return start;
	}
	
	public static void main(String[] args){
		OrderedSuperArray a = new OrderedSuperArray();
		a.add("abc");
		a.add("Abc");
		a.add("ABC");
		a.add("abC");
		a.add("aBC");
		a.add("HelLo");
		a.add("blah");
	
		String[] arr = {"abc", "Abc", "ABC", "abC", "aBC", "HelLo", "blah"}; 
		//[ABC, Abc, HelLo, aBC, abC, abc, blah, null, null, null, null, null]

		System.out.println(a);

		System.out.println(a.lastIndexOf(a.get(3)) == a.lastIndexOfBinary(a.get(3)));
		System.out.println(a.lastIndexOf(a.get(4)) + " " + a.lastIndexOfBinary(a.get(4)));
		
		System.out.println(a.findIndex(a.get(2)) == a.findIndexBinary(a.get(2)));
		System.out.println(a.findIndex(a.get(3)) + " " + a.findIndexBinary(a.get(3)));
		
		System.out.println(a.indexOf(a.get(1)) == a.indexOfBinary(a.get(1)));
		System.out.println(a.indexOf(a.get(5)) + " " + a.indexOfBinary(a.get(5)));
		
	}
	
}