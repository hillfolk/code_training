public class isort1 {

public static void main(String[] args) {
		final int MAXNUM = 10000;
	int[] data = new int[MAXNUM];
	for (int i = 0; i < MAXNUM ; i ++) {
		data[i] = (int)(100.0 * Math.random()) + 1;
	}
	double step1 = System.currentTimeMillis();
	isort1(data);
	double step2 = System.currentTimeMillis();
	 

	System.out.println("End");
}

private static void isort1(int[] indata) {
	int t = 0;
	int t2 = 0;
	int i,j = 0;
for ( i = 0; i < indata.length ;i++ ) {
	System.out.print(":"+ indata[i]);
 	
 } 
  System.out.println("");
 System.out.println("----------------------------");
	for (i =0; i < indata.length ;i++ ) {

		for (j = i;(j >0 );j-- ) {
				t2 = indata[j];	
			if(indata[j-1] > t2){
				
			 indata[j]  = indata[j-1];
			indata[j-1] = t2;	 	
			}
		}
	
	
 	
 	}
for ( i = 0; i < indata.length ;i++ ) {
	System.out.print(":"+ indata[i]);
 	
 }	 
	}


}