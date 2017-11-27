public class ReversedCharSequence implements CharSequence {
    private String seq;
    private String newSeq;
		
    public ReversedCharSequence(String seq) {
    		this.seq = seq;
    		newSeq = "";
    		for (int i = seq.length() - 1; i > -1; i--) {
    			newSeq += seq.substring(i, i+1);
    		}
    }

    public char charAt (int index) {
    		return newSeq.charAt(index);
    }

    public int length() {
    		return newSeq.length();
    }

    public ReversedCharSequence subSequence (int start, int end) {
    		String sub ="";
		for (int i = start; i < end; i++) {
			sub += newSeq.charAt(i);
		}
		String preans = "";
		for (int i = sub.length() - 1; i >= 0; i--) {
			preans += sub.charAt(i);
		}
		ReversedCharSequence ans = new ReversedCharSequence(preans);
		return ans;

    }

    public String toString () {
    		return newSeq;
    }
    
    public static void main(String[] args){
    		ReversedCharSequence ans = new ReversedCharSequence("PeterJin");
    		for (int i = 0; i < ans.length(); i++){
    			System.out.println(ans.charAt(i));
    		}
    			       
    	System.out.println(ans);
    	
    }
}
	    