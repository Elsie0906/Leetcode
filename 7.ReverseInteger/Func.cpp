#include <iostream>
#include <new>
#include <vector>

using namespace std;

bool isOverflow(long long int x)
{
    long int max = pow(2,31)-1;
    long int min = -pow(2,31);
    
    //cout<<"max ="<<max<<", min ="<<min<<'\n';
    
    if(x> max)
       return 1;
    else if(x< min)
       return 1;
    else
       return 0;
}

bool isPositive(long int x)
{
    
    if(x>0)
       return 1;
    else
       return 0;
}

class Solution {
public:
    int reverse(int x) {
        bool checkOverflow, checkPositive;
        long long int y= 0;
        vector<int> nums;
        vector<int> mark;
        int temp, divisor, rem;
        int validBit = 0;
        long long int dividend;
        long long int value=0;
        
        //cout<<"x = "<< x << '\n';

        /* check if x is positive */
        
        checkPositive = isPositive(x);
        
        //cout<<"checkPositive = "<<checkPositive<<'\n';
        
        dividend = abs(x);
           
        //cout<<"dividend = "<< dividend <<'\n';
        
        /* decompose x -> HSB:10^9 */
        
        for (int i=10 ; i>0; i--)
        {
            divisor = pow(10, i-1);
            
            rem = dividend % divisor;
        
            temp = (dividend - rem)/divisor;
            
            //cout << "temp = "<< temp <<'\n';
            
            nums.push_back(temp);
            
            
            if(temp !=0)
               mark.push_back(1);
            else
               mark.push_back(0);
            
            dividend = rem;
        }    
        
        #if 0
        cout<<"nums = ";
        
        for(int i=0; i<nums.size(); i++)
            cout<< nums[i];
            
        cout<<'\n'; 
        
        cout<<"mark = ";
        
        for(int i=0; i<nums.size(); i++)
            cout<< mark[i];
            
        cout<<'\n'; 
        
        #endif
        
        /* How many valid bits? */
        
        for(int i=mark.size(); i>0; i--)
        {   
            if(mark[i-1]!=0)
               validBit = 10-i+1;
               
            //cout<<"i = "<< i<<"validBit = "<<validBit<<'\n';   
        }
        
        if(validBit == 0)   // for exceptional case such as '0', '1'
           validBit = 1;
        
        /* reverse or recompose the number */
        
        for(int i=nums.size(); i>0; i--)
        {
            //cout<< "nums = "<< nums[i-1]<< "valid bit = "<< validBit<<'\n';
            
            temp = pow(10, validBit-1);
            
            value = nums[i-1];
            
            //cout<<"temp ="<<temp<<'\n';
            
            y = y+value*temp;
            
            //cout<<"add value = "<<value<<", y = "<<y<<"\n";
            
            if(validBit > 1)
               validBit--;
        }
        
        //cout<<"y = "<<y<<"\n";
        
        checkOverflow = isOverflow(y);
        
        //cout<<"checkOverflow ="<<checkOverflow<<'\n';
        
        if(checkOverflow == 1)
            return 0;
        else if(checkPositive == 1)
            return y;
        else
            return -y;
            
        
    }
};