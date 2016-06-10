//
//  divide.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef divide_h
#define divide_h

int Solution::divide(int dividend, int divisor){
    long long dvd = dividend, dvs = divisor;
    int sign = dvd < 0 ^ dvs < 0 ? -1 : 1;
    dvd = abs(dvd);
    dvs = abs(dvs);
    long long quotient = 0;
    for (long long temp = 0, i = 31; i >=0; i--){
        if (temp + (dvs << i) <= dvd){
            temp += dvs << i;
            quotient |= 1LL << i;
        }
    }
    if(sign < 0) quotient = -quotient;
    return quotient >= INT_MAX || quotient < INT_MIN ? INT_MAX : quotient;
}

#endif /* divide_h */
