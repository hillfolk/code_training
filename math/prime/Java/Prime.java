public class Prime { //소수 구하기
private static void exam2(int num) { 
        int data[] = new int[num];
        int count=2;
        data[0] = 2;
        data[1] = 3;
        int x1, x2;
        boolean         flag = false;
        for(int i=6; i<num-1; i+=6)
        {
            x1 = i-1;
            x2 = i+1;
            flag = false;
            for(int j=0; j<count; j++)
            {
                if(x1%data[j]==0)
                {
                    flag = true;
                    break;
                }
                if(data[j]>Math.sqrt(x1))
                    break;
            }
            if(!flag)
            {
                data[count++] = x1;
            }
            flag = false;
            for(int j=0; j<count; j++)
            {
                if(x2%data[j]==0)
                {
                    flag = true;
                    break;
                }
                if(data[j]>Math.sqrt(x2))
                    break;
            }
            if(!flag)
            {
                data[count++] = x2;
            }
        }
        System.out.println("exam2 : "+ count);
        // for (int k = 0;k < count ; k++ ) {

        //      // System.out.print(data[k]);
        //      // System.out.print(" ");

        // }
       
    }
 
    private static void exam1(int num) { 
        boolean arr[] = new boolean[num+1];
        System.out.print("num"+num);
        System.out.print("sqrt" + Math.sqrt(num));
        int count=1;
        for(int i=3; i<=num; i+=2)
        {
            if(!arr[i])
            {
                count++;
                if(i<=Math.sqrt(num))
                    for(int k=i; k*i<=num && k*i>0; k+=2)
                    {
                        if(!arr[k*i])
                            arr[k*i] = true;
                    }
            }
        }
        System.out.println("exam1: "+count);
      
    }

    public static void main(String[] args) {                                                                                                  
        double first = System.currentTimeMillis();
        int max = 10000;
         exam1(max);
        double second = System.currentTimeMillis();
         exam2(max);
        double third = System.currentTimeMillis();
        System.out.println("exam1 : " + (second-first));
        System.out.println("exam2 : " + (third-second));
    }
 
  
} 