#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <time.h>

using namespace std;

void selectionSort(vector<int>& A){
  for(int i=0; i < A.size(); ++i){
    int minIndex = i;
    for (int j = i+1; j < A.size(); ++j)
      if(A[minIndex] > A[j])
	minIndex = j;
    swap(A[i],A[minIndex]);
      
  }
}


void insertSort(vector<int>& A){

  for(int i = 0; i < A.size(); ++i){    
    int j = i;
    
    while(i > 0 && A[j-1] > A[j]){ //i가 0보다 크고 A[j-1] 보다 A[j] 가 작을경우 순서를 스왑한다. 
      swap(A[j-1],A[j]);
      --j;                                
    }
  }
}

void printV(vector<int>& v){

  for(int i = 0 ; i < v.size(); i++){   
   cout << v[i] <<' ';   
  }


}

void randomV(vector<int>& v,int input_size){
  for(int i = 0 ; i < input_size; i++){
   
   v.push_back((rand()%10000)+1);
   
  }
}

int main()
{
  srand((unsigned int)time(NULL)); // seed 값 자동 추가
  clock_t begin,end;
  vector<int> vi;
  vector<int> vi2;
  int input_size;

  
  cin >> input_size;

  randomV(vi,input_size);

  printV(vi);
  cout<<" "<<endl;
  cout<<"연산시작:"<<endl;
  
  begin = clock();
  selectionSort(vi);
  end = clock();

  cout<<"수행시간: "<<((end-begin))<<endl;

  printV(vi);

  cout<<"연산시작:"<<endl;

  randomV(vi2,input_size);
  
  begin = clock();
  insertSort(vi2);
  end = clock();
  cout<<"수행시간: "<<((end-begin))<<endl;
  printV(vi2);
    
  return 0;
}

