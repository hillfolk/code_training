#include <string>
#include <vector>

using namespace std;

int compare(int first_input,int second_input){
  int ret = -1;
  int num = 0;
  int cnt,cnt2 = 0;
  aector<int> first_NumArray  = int[100];
  aector<int> second_NumArray  = int[100];
  
  
  //가장 큰수를 만들수 있는 수인지 비교
  // 오른쪽 값이 큰경우 1  왼쪽 값이 큰경우 -1 같은 경우 0
  if (first_input == second_input){
    return 0;
  }

  while (first_input != 0){
   
  first_input = first_input / 10;
  first_NumArray[cnt] = first_input;
  first_cnt ++;
  }
  

  while (second_input != 0){
   
  second_input = first_input / 10;
  second_NumArray[cnt] = first_input;
  second_cnt ++;
  }

  while (i  > 0){

    // 첫번째 자리가 같은 경우 다음 자리에 누가 오느냐에 따라서 큰수가 달라짐 그래서 이렇게 비교만으로는 풀기 어려움
    if([first_NumArray[first_cnt-1] > second_NumArray[second_input]) {
	return 1;
	
     }else if([first_NumArray[first_cnt-1] > second_NumArray[second_input]) {
	

       }else {
	 
       }
	   
       

 
  return ret
}

string solution(vector<int> numbers) {

  // 1 비교
  // 스왑
  //정렬 완료후 문자열 변환 
    
  
    string answer = "";
    return answer;
}



void main(){
  

}
