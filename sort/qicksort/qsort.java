public class qsort{
	private int[]  data;
	private int data_size;

	public static void main(String[] args) {
	qsort sqsort = new qsort();
	sqsort.data_size = 1000;

	 sqsort.data = new int[sqsort.data_size];
	for (int i = 0; i < sqsort.data_size  ; i ++) {
		 sqsort.data [i] = (int)(100.0 * Math.random()) + 1;
	}

	System.out.println("");
	for (int i = 0; i <  sqsort.data .length ;i++ ) {
	System.out.print(":"+  sqsort.data [i]);
 	
	 }
	
	sqsort.qsort1(0,sqsort.data .length-1);
	int[] result = sqsort.getSortedData();
	double step1 = System.currentTimeMillis();
	System.out.println("");
	for (int i = 0; i < result.length ;i++ ) {
	System.out.print(result[i]+":");
 	
 	}
 	System.out.println("");
}

public void qsort1(int l,int u){
		int p = l;
		int i = l;
		int j = u;
		while(true){
			while(data[p]>= data[i] && i < u){
				i++;
			}
			while(data[p] <= data[j] && j > l){
				j--;
			}
			if (i >= j){
				break;
			}else{
				swap(i,j);
			}
		}
		swap(p,j);
		if (l < j) {
			qsort1(l,j);
		}
		if (u > i){
			qsort1(i,u);
		}
		
	}

public int[] getSortedData(){

	return data;

}
public void swap(int f ,int l){
	int t;
	t = data[f];
	data[f] = data[l];
	data[l] = t;


}

}
