import java.util.Random;

public class QuickSort {
	public int[] mData;
	private int	  mSize;
	public QuickSort(int size){
		mData = new int[size];
		mSize = size;
		generateData();
	}
	
	public static void main(String[] args){
		int testSize = 1000;
		QuickSort qsort = new QuickSort(testSize);
		int[] data = qsort.getData();
		for (int i = 0;i < data.length ;i++ ) {
		System.out.print(":"+data[i]);
		}
		System.out.println("Start");
		qsort.QuickSortRecursive(0, testSize-1);
		int[] result = qsort.getData();

		for (int i = 0;i < result.length ;i++ ) {
		System.out.print(":"+result[i])	;
		}
		
		System.out.println("complete");
	}
	
	public void generateData(){
		Random rand = new Random();
		for(int i=0;i<mSize;i++){
			mData[i] = rand.nextInt(100);
		}
	}
	
	public int[] getData(){
		return mData;
	}
	
	public void QuickSortRecursive(int Left, int Right){
		int pivot = Left;
		int i = Left;
		int j = Right;
		while(true){
			while(mData[pivot]>=mData[i] && i < Right){
				i++;
			}
			while(mData[pivot]<=mData[j] && j > Left){
				j--;
			}
			
			if(i>=j){
				break;
			}else{
				swap(i, j);	
			}
		}
		swap(pivot, j);
		
		if(Left<j)
			QuickSortRecursive(Left, j);
		if(Right>i)
			QuickSortRecursive(i, Right);
	}

	public void swap(int x, int y){
		int temp = mData[x];
		mData[x] = mData[y];
		mData[y] = temp;
	}
}
