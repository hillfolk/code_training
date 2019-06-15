#include <string>
#include <vector>

using namespace std;

bool compare(int left,int rigiht){

  string str_left =  to_string(left);
  string str_right = to_string(right);

  int left_right = stoi(str_left + str_right);
  int rigiht_left = stoi(str_rigiht + str_left);
  

  if (left_right > right_left ){
    return true;
  }

 
  return false;
}

string solution(vector<int> numbers) {

  // 1 비교
  // 스왑
  //정렬 완료후 문자열 변환 
  sort(numbers.begin,numbers.end,compare)
    
  
    string answer = "";
    return answer;
}



void main(){
  

}
