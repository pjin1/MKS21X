import java.util.Arrays;

public class Sorts {

  public static String name() {
    return "10,Jin,Peter";
  }

  public static boolean isSorted(int[] ary) {
    for(int i = 0; i < ary.length - 1 ; i++){
      if(ary[i] > ary[i+1]){
        return false;
      }
    }
    return true;
  }

  private static void swap(int[] ary,int a, int b) {
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
  }

  //Sorts
  public static void bogoSort(int[] ary) {
    while(!isSorted(ary)){
      for(int i = 0 ; i < ary.length; i++){
        int temp = ary[i];
        int newSpot = (int)(Math.random()*ary.length);
        ary[i] = ary[newSpot];
        ary[newSpot] = temp;
      }
    }
  }

  public static void selectionSort(int[] ary) {
    for (int i = 0; i < ary.length; i++){
      int min = ary[i];
      int index = i;
      for (int j = i; j < ary.length; j++){
        if (ary[j] < min){
          min = ary[j];
          index = j;
        }
      }
      swap(ary,i,index);
    }
  }
  
  public static void insertionSort(int[] ary) {
	  for (int i = 1; i < ary.length; i++) {
		  int temp = ary[i];
		  int index =i;
		  while (index > 0 && temp < ary[index-1]) {
			  ary[index] = ary[index-1];
			  index--;
		  }
		  ary[index] = temp;
	  }
  }

  public static void bubbleSort(int[] ary) {
	  boolean swapped;
	  for (int i = 0; i < ary.length; i++) {
		  for (int j = 0; j < ary.length-i-1; i++) {
			  if (ary[j] > ary[j+1]){
				  swap(ary,j,j+1);
				  swapped = true;
			  }    
		  }
	  }
	  if (swapped==false) {
		  break;
	  }
  }
  
}
