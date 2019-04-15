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
}


int main()
{
  // 연속부분 구간합의 최대 구하기 
  vector<int> vi = {-7,4,-3,6,3,-8,3,4};
  clock_t begin,end;
  int result;

    begin = clock();
  result = betterMaxSum(vi);
  end = clock();
  cout<<"수행시간: "<<(end-begin)<<endl;
  cout<<"O(N2)수행결과: "<<(result)<<endl;
  
  begin = clock();
  result = inefficientMaxSum(vi);
  end = clock();
  cout<<"행시간: "<<(end-begin)<<endl;
  cout<<"O(N3)수행결과: "<<(result)<<endl;



  // 주먹구구식 풀이 //O(N^3)

  return  0;
  
}
