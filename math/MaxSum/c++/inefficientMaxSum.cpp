#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <time.h>
#include <limits>

using namespace std;

const int MIN = std::numeric_limits<int>::min();

//O(N^3)
int inefficientMaxSum(const vector<int>& A) {
  int N = A.size(), ret = MIN;
  for(int i = 0; i < N; ++i)
    for(int j = i; j < N; ++j){
      // 구간의합 구하기
      int sum = 0;
      for(int k = i;k<= j; ++k)
	sum += A[k];
      ret = max(ret,sum) ;
	}
  return ret;
}

//O(N^2)
int betterMaxSum(const vector<int>& A){
  int N = A.size(), ret = MIN;
  for(int i = 0; i < N; ++i){
    int sum = 0;
    for(int j = i;j < N; ++j){
      sum += A[j];
      ret = max(ret,sum);
	}
    
  }
  return ret;
}

//Divide and Conquer O(NlgN)
int fastMaxSum(const vector<int>& A, int lo, int hi){
  //구간의 길이가 1인경우
  if(lo == hi)return A[lo];

  // 배열을 두 조각으로 나눈다.
  int mid = (lo + hi) /2;
  // 두부분에 모두 걸쳐 있는 최대합 구간을 찾는다.

  int left = MIN, right = MIN, sum = 0;

  for(int i = mid; i >= lo; --i){
    sum += A[i];
    left = max(left,sum);
          
  }


  sum = 0;

  for (int j = mid + 1; j <= hi; ++j){
    sum += A[j];
    right = max(right, sum);
    
  }

  int single = max(fastMaxSum(A,lo, mid),
		   fastMaxSum(A,mid+1,hi));


  return max(left+right,single);	
}
//O(N)
int fastestMaxSum(const vector<int>& A) 
{
  int N = A.size(), ret = MIN , psum = 0;
  for(int i = 0; i < N; ++i){
    psum = max(psum,0) +A[i];
    ret = max(psum,ret);
  }

  return ret;
}


int main()
{
  // 연속부분 구간합의 최대 구하기 
  vector<int> vi = {-7,4,-1,6,3,-8,3,4,-7,4,-3,6,3,-8,3,6,7,4,-3,6,3,-8,3,4};
  clock_t begin,end;
  int result;


  begin = clock();
  result = inefficientMaxSum(vi);
  end = clock();
  cout<<"수행시간: "<<(end-begin)<<endl;
  cout<<"O(N3)수행결과: "<<(result)<<endl;

     begin = clock();
  result = betterMaxSum(vi);
  end = clock();
  cout<<"수행시간: "<<(end-begin)<<endl;
  cout<<"O(N2)수행결과: "<<(result)<<endl;
  

  begin = clock();
  result = fastMaxSum(vi,0,vi.size() -1);
  end = clock();
  cout<<"수행시간: "<<(end-begin)<<endl;
  cout<<"O(NlgN) 수행결과: "<<(result)<<endl;


  begin = clock();
  result = fastestMaxSum(vi);
  end = clock();
  cout<<"수행시간: "<<(end-begin)<<endl;
  cout<<"O(N) 수행결과: "<<(result)<<endl;

  return  0;
  
}
