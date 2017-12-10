import java.util.*;
import java.io.*;

public class Barcode implements Comparable<Barcode> {
	private String zip;
	String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	
	public Barcode(String zip) {
		for (int i = 0; i<zip.length(); i++) {
			if (zip.length() != 5 || !zip.matches("[0-9]+")){
	    			throw new IllegalArgumentException();
			}
		}
		this.zip = zip;
	}
	
	public int compareTo(Barcode other){
		return Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip());
	}
	
	public static String toCode(String zip){
		Barcode bar = new Barcode(zip);
		return bar.getCode();
	}
	
	public String getCode(){
		String code = "|";
		int total = 0;
		for (int i = 0; i < zip.length(); i++){
		    total += Integer.parseInt(zip.substring(i,i+1));
		    code += conversions[Integer.parseInt(zip.substring(i,i+1))];
		}
		return code + conversions[total % 10] + "|";
	}
	
	public static String toZip(String code) {
		
		if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(31) != '|'){
		    throw new IllegalArgumentException();
		}
		for (int i = 0; i < 32; i++){
		    if (code.charAt(i) != '|' || code.charAt(i) != ':'){
		    		throw new IllegalArgumentException();
		    }
		}
		
		String ans = "";
		code = code.substring(1,31);
		int total = 0;
		String[] conversions1 = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < 10; i++){
		    a.add(conversions1[i]);
		}
		for (int i = 0; i < 25; i++){
		    int x = a.indexOf(code.substring(i,i+5));
		    if (x == -1){
		    		throw new IllegalArgumentException();
		    }
		    total += x;
		    ans += x;
		    i += 4;
		}
		
		return ans;
	}
	
	public String getZip(){
		return zip;
    }
	
	public String toString() {
		return getCode() + " (" + zip + ")";
	}
	
}
