

import java.util.Random;

class node{
public int val;
public node next;
public node(int v, node p) {
	val = v;
	next = p;
	}
}

public class IntSetList{
	int n;
	node head,sentinel,p;
	public static void main(String[] args) {
		int maxvall = 1000;
		int[] value = new int[maxvall];

		IntSetList intsetlist = new IntSetList(maxvall);
		double step1 = System.currentTimeMillis();
		intsetlist.generateSetList(maxvall,maxvall);
		double step2 = System.currentTimeMillis();
		intsetlist.report(value);



	}
	public void generateSetList(int m,int maxval){
		int t;
		
		Random random = new Random();
		while(this.size() < m){
			t = random.nextInt(maxval);
			this.insert(t);
			}


		
		 }
		
	public IntSetList(int maxval)
	{
		sentinel = new node(maxval,null);
		head = sentinel;
		n = 0;
	}

	public void report(int[] v)
	{
		int j = 0;
		int k = 0;
		for (p = head; p != sentinel ;p = p.next) {
			v[j++] = p.val;
		}
		while(k < v.length){
			System.out.print(v[k]+"-");
			k++;
		}

		System.out.println("size:"+this.size());
	}

	public void insert(int t){
		head = rinsert(head,t);
	}

	public node rinsert(node p,int t){
		if (p.val < t){
			p.next = rinsert(p.next,t);
		}else if(p.val > t){
			p = new node(t,p);
			n++;
		}		
System.out.println("t:"+t);
		System.out.println("n:"+n);

		return p;


	}
	public int size() {
		return n;
	}

}


