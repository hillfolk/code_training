#!/usr/bin/env python

import sys

def solution(phone_book):
    number= {}
    answer = False
    #phone_book.sort()  #sort 수행시 실행시간 증가 
    for phone_number in phone_book:
        for startstr in phone_book:
            if(phone_number == startstr):
                continue
            answer = not startstr.startswith(phone_number,0);
            if (not answer):
                break;
        if(not answer):
            break;
    return answer

def main(argments):
    input_data = ["12232332", "12", "222222"]
    
    print(solution(input_data))

    input_data = ["911", "97625999", "91125426"]
    print(solution(input_data))
    input_data = ["113", "12340", "123440", "12345", "98346"]
    print(solution(input_data))




if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))
