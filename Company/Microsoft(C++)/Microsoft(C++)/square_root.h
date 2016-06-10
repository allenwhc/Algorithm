//
//  square_root.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef square_root_h
#define square_root_h

double Solution::squareRoot(double x){
    double t = 1;
    double square_root = x/2.0;
    while (t - square_root != 0){
        t = square_root;
        square_root = (t + (x/t))/2;
    }
    return square_root;
}

#endif /* square_root_h */
