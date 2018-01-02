public abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    
    public LibraryBook(String author, String title, String ISBN, String callNumber){
    		super(author, title, ISBN);
    		this.callNumber = callNumber;
    }
    
    public String getCallNumber(){
        return callNumber;
    }
    
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    
    public int compareTo(LibraryBook other){
    		return this.getcallNumber().compareTo(other.getCallNumber());
    }

    public String toString(){
    		return super.toString() + ", " + circulationStatus() + ", " + callNumber;
    }
}
