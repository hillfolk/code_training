#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool compare(int left,int right){

  string str_left =  to_string(left);
  string str_right = to_string(right);

  int left_right =  stoi(str_left+str_right);
  cout << left_right <<endl;
  int right_left = stoi(str_right+str_left);
  cout << right_left <<endl;
  

  if (left_right > right_left ){
    return true;
  }

 
  return false;
}

string solution(vector<int> numbers) {
  
  int zcnt = 0;
  string result = "";
  sort(numbers.begin(),numbers.end(),compare);

  for (int i = 0; i < numbers.size(); ++i){
    if (numbers[i] == 0){
      zcnt ++;
    }

    result = result + to_string(numbers[i]);
  
  
  }
  if (zcnt == numbers.size()){
    result = "0";
  }
  return result;
}


int main(){
  vector<int> input_vector;

  input_vector.push_back(6);
  input_vector.push_back(10);
  input_vector.push_back(2);
    input_vector.push_back(3);

        input_vector.push_back(30);
  
  cout << solution(input_vector) << endl;

}
