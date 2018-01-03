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
	
		if (this.size() == 0){
		    super.add(0, value);
		}
		else{
		    super.add(this.findIndexBinary(value), value);
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
			if (super.get(mid).compareTo(element)==0) {
				end=mid;
			}
			else if (super.get(mid).compareTo(element)<0) {
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
			if (super.get(mid).compareTo(element)>0) {
				end=mid;
			}
			else if (super.get(mid).equals(element)) {
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
			if (value.compareTo(super.get(i)) >= 0) {
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
			if (value.compareTo(super.get(mid))<=0){
				end=mid;
			}
			else {
				start = mid+1;
			}
		}
		
		return start;
	}
	//Crystal helped me debug!
	
}