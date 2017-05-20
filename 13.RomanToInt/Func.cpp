/*
    1. set some significant numbers such as 'I' for 1, 'V' for 5, and etc.
    2. recognized the expression: 
       'I' equals to -1(negative int) when we put it in front of a 'V'  
*/

#include <iostream>
#include <string>

int LookUpTable(char input){
    
    int tempValue = 0;
    
    switch(input)
    {
        case 'I':
                tempValue = 1;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n';
                break;
        case 'V':
                tempValue = 5;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;
        case 'X':
                tempValue = 10;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;           
        case 'L':
                tempValue = 50;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;                    
        case 'C':
                tempValue = 100;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;                    
        case 'D':
                tempValue = 500;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;         
        case 'M':
                tempValue = 1000;
                //cout<< "input = " << input << ", tempValue = "<< tempValue << '\n'; 
                break;  
        default:
                tempValue = 0;
                //cout<< "input = " << input << " cannot be recognized" << '\n';
                break;
    }
    
    return tempValue;
}

class Solution {
public:
    int romanToInt(string s) {
        int equalValue = 0;
        int tempValue = 0;
        int input1, input2;
        
        //for(string::iterator it=s.begin(); it!=s.end(); it++)
            //cout << *it << '\n';
        
        for(int i=0; i < s.size(); i++)
        {
            input1 = LookUpTable(s[i]);
            
            if(i >= s.size()-1)
               input2 = 0;
            else   
               input2 = LookUpTable(s[i+1]);
        
            if(input1 < input2)
               tempValue = (-1)*input1;
            else
               tempValue = input1;
           
            //cout << "tempValue = " << tempValue << '\n';   
        
            equalValue = equalValue + tempValue;
        }
        
        return equalValue;
    }
};