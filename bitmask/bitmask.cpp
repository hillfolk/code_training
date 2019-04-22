#include <iostream>

using namespace std;
int main(){
  //bit 를 이용한 집합
  
  // 공집합과 꽉 찬 집합
  
  int fullPizza = (1 << 20)-1; // 20개 bit 가 켜진 상태의 정수

  cout<<fullPizza<<endl;

  //원소 추가 
  int p = 2;
  int toppings;
  
  toppings |= (1 << p);
 
  cout<<toppings<<endl;

  //원소의 포함여부 확인
  if(toppings & (1 << p)) cout << "pepperoni is in" <<endl;

  //원소 삭제
   toppings -= (1 << p);
  
  cout<<toppings<<endl;
  
  toppings &= ~(1 <<p);
  cout<<toppings<<endl;

  //원소 토글
  toppings ^= (1 << p);
  cout<<toppings<<endl;

  
  
  return 0;
  
}
