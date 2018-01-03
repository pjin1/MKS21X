public class ReversedCharSequence implements CharSequence {
    private String seq;
	private String output;
    
    public ReversedCharSequence(String seq) {
    		this.seq = seq;
    		output = "";
    		for (int i = seq.length() - 1; i >= 0; i--) {
    			output += seq.substring(i, i+1);
    		}
    }

    public char charAt (int index) {
    		return output.charAt(index);
    }

    public int length() {
    		return output.length();
    }

    public CharSequence subSequence (int start, int end) {
    		return output.subSequence(start,end);
    }

    public String toString () {
    		return output.toString();
    }
    
}
	    