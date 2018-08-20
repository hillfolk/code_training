import java.util.Random;
public class CustomSet{
	private int[] intset;
	private int set_size;
	
	public static void main(String[] args) {
		CustomSet cset = new CustomSet();
		double step1 = System.currentTimeMillis();
		cset.generateSetArray(20,20);
		double step2 = System.currentTimeMillis();
		double endtime = step2 - step1;
		cset.reportSet(endtime);

		double step3 = System.currentTimeMillis();
		CustomSet csetarray = new CustomSet();	
		csetarray.generateSet(20,20);
		double step4 = System.currentTimeMillis();
 		endtime = step4 - step3;

		csetarray.reportSet(endtime);

		
	}
	public void generateSet(int m,int maxval){
		set_size = 0;
		int t;
		intset = new int[m];
		// intset[0] = maxval;

		Random random = new Random();
		while(set_size < m){
			t = random.nextInt(maxval);
		if(!setCheck(t)){
			insertSet(t);
			set_size++;
			// System.out.println("set_size:" + set_size);
			}
				// insert(t);
		 }
		
	}
	public void generateSetArray(int m,int maxval){
		set_size = 0;
		int t;
		intset = new int[m+1];
		intset[0] = maxval;

		Random random = new Random();
		while(set_size < m){
			t = random.nextInt(maxval);
				insert(t);
		 }
		
	}
	public boolean setCheck(int m){
		for (int i = 0;i < set_size ;i++  ) {
		if (intset[i] == m){
			return true;
			}	
		}
		return false; 
	}
	public void insertSet(int v){

		int i = 0;
		int t;
		if (set_size == 0) {
			intset[0] = v;	
		}else{
			intset[set_size] = v;
		}
		for (i =0; i <= set_size ;i++ ) {

		for (int j = i; j >0 ;j-- ) {
				t = intset[j];	
			if(intset[j-1] > t){
			 intset[j]  = intset[j-1];
			intset[j-1] = t;	 	
			}
		}
	
	}
 	
 }

	
	public void reportSet(double endtime){
		int i = 0;

		while( i<set_size){
		System.out.print(intset[i]+"-");
		i++;
		}
			System.out.println("");
				System.out.println("Execute Time:"+ endtime);
	}

	public void insert(int t){
		int i,j;
		for (i = 0;intset[i] <t ;i++ ) 
		{	// 센티널을 검사하기 때문에 루프를 벗어남
			// 맨 앞부터 재우기 때문에 적용 가능 하다
			// System.out.print(i);
		}
		if (intset[i] == t){
				return;
			}
		for (j = set_size;j >= i ;j-- ){
				intset[j+1] = intset[j];
			}
		intset[i] = t;
		set_size++;
			
		}
}





