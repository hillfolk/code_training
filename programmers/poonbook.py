#!/usr/bin/env python

import sys

def solution(phone_book):
    number= {}
    check = False
    positon = 0;
    for phone_number in phone_book:
        for num_char in phone_number:
            if number in num_char:
                number[num_char]:

    answer = check
    return answer

def main(argments):
    input_data = ["12232332", "12", "222222"]
    print(solution(input_data))




if __name__ == '__main__':
    sys.exit(main(sys.argv[1:]))
