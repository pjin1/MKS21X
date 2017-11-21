import java.io.*;
import java.util.*;

public class WordSearch {
	
    private char[][] data;
    private char[][] solution;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private int seed;
    
    
    public WordSearch(int rows,int cols,String fileName){
    		this(rows, cols, fileName, new Random().nextInt());
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed){
		  wordsToAdd = new ArrayList<String>();
		  wordsAdded = new ArrayList<String>();
		  randgen = new Random(randSeed);
    	data = new char[rows][cols];
    	seed = randSeed;
    	try{
    		Scanner in = new Scanner(new File(fileName));
    		while(in.hasNext()) {
    			wordsToAdd.add(in.nextLine());
        }   
    		clear();
      } 
    	catch (FileNotFoundException e){
        System.out.println("File not found: " + fileName); //e.printStackTrace();
        System.exit(1);
    	}
      addAllWords(fileName);
      solution();	
	  }
	
	public void solution(){
		solution = new char[data.length][data[0].length];
		for (int a = 0; a <data.length; a++){
			for (int b = 0; b < data[a].length; b++){
				solution[a][b] = data[a][b];
			}	
		}
	}
	
	public boolean addAllWords(String fileName){
		int x,y,num,row,col;
		for (int i = 0; i < 2000; i++){	
		    if (wordsToAdd.size() == 0){
		    		return true;
		    }
		    x = randgen.nextInt(2);
			y = randgen.nextInt(2);
			num = randgen.nextInt(wordsToAdd.size());
			row = randgen.nextInt(data.length);
			col = randgen.nextInt(data[0].length);
		    
			addWord(row, col, wordsToAdd.get(num), x, y);
		}
		return true;
	}
 
    private void clear(){
    		for (int a = 0; a < data.length; a++){
    			for (int b = 0; b < data[a].length; b++){
    				data[a][b] = '_';
    			}
    		}
    	}
    
    public int getSeed(){
		return seed;
	}
   
    public String toString(){
    		String output = "";
    		if (data.length == 0){
    			return "[]";
    		}
    		for (int a = 0; a < data.length; a++){
    			for (int b = 0; b < data[a].length; b++){
    				output += data[a][b];
    				if (b != data.length - 1){
    					output += " ";
    				} 
    			}
    			output += "\n";
    		}
    		output += "\nSeed: " + getSeed() + "\n";
    		output += "Words in the puzzle: \n";
    		String a = wordsAdded.toString();
    		output += (a).substring(1,(a).length() - 1);
        return output;
    	}
    
    private boolean addWord(int row, int col, String word, int rIncrement, int cIncrement) {
    		String wordz = word.toUpperCase();
    	  //==================================================================================
    		if (rIncrement == 0 && cIncrement == 0) {
    	    		return false;
    	    }
    	    if (row > data.length || col > data[0].length) {
            return false;
        }
    	    if ((word.length() + row) > data.length) {
        		return false;
        }
        if ((word.length() + col) > data[row].length) {
        		return false;
        }
      //==================================================================================
        for (int i=0; i<word.length(); i++){
            if (data[row+i*rIncrement][col+i*cIncrement] != '_' 
                && 
                data[row+i*rIncrement][col+i*cIncrement] != wordz.charAt(i)) {
            		return false;
            }
        }
      //==================================================================================
        for (int i=0; i<word.length(); i++){
            data[row+i*rIncrement][col+i*cIncrement] = wordz.charAt(i);
        }
      //==================================================================================
		wordsAdded.add(word);
		wordsToAdd.remove(word);
		
		return true;
		
    }
 
    private void fillEmpty() {
		for (int a = 0; a < data.length; a++) {
			for (int b = 0; b < data[a].length; b++) {
				if (data[a][b] == '_') {
					data[a][b] = getLetter();
				}
			}
		}
    }
    
    private char getLetter(){
 	   String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 	   return letters.charAt(randgen.nextInt(letters.length()));
    }
    
    public static void main(String[] args){
    		try {
    			int R = Integer.parseInt(args[0]);
    		    int C = Integer.parseInt(args[1]);
    			if (R == 0 || C == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))){
    	    			throw new ArrayIndexOutOfBoundsException();
    			}
    			if (args.length > 3){
    	    			int seed = Integer.parseInt(args[3]);
    	    			WordSearch ws = new WordSearch(R, C, args[2], seed);
    	    			if (args.length == 5 && args[4].equals("key")){
    	    				System.out.println(ws);
    	    			}
    	    			else{
    	    				ws.fillEmpty();
    	    				System.out.println(ws);
    	    			}
    			}
    			else{
    	    			WordSearch ws = new WordSearch(R, C, args[2]);
    	    			System.out.println(ws.toString());
    	    			ws.fillEmpty();
    	    			System.out.println(ws);
    			}
    		} catch(NullPointerException e) {System.out.println("drats");}
//    		catch(ArrayIndexOutOfBoundsException e){
//    			System.out.println("Input WordSearch properties as follows: \n java WordSearch <R> <C> <fileName> <seed> <key> "
//    					+ "\n <R>: # rows "
//    					+ "\n <C>: # columns "
//    					+ "\n <fileName>: name of file with desired words "
//    					+ "\n <seed> -- optional: seed for specified word search "
//    					+ "\n <key> -- optional: type 'key' for solution");
//    		}
    }
     
}
