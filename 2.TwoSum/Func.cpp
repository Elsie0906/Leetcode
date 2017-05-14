#include <iostream>
#include <new>
#include <vector>

using namespace std;

class List{
public:
    int value,index;
    List(void);
    List(int new_value, int new_index);
    vector<List> new_vector;
};

List::List()
{
    value = -1;
    index = -1;
}

List::List(int new_value, int new_index)
{
    value = new_value;
    index = new_index;
}

struct less_than_key
{
    bool operator() (List &struct1, List &struct2)
    {
        return (struct1.value < struct2.value);
    }
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i,FirstValue, SecondValue,tempIndex, minIndex, maxIndex;
        vector<int> map;
        vector<List> newnums;
        
        // a new mapping, sorting
    
        for(i=0; i<nums.size();i++)
        {
            List list(nums[i],i);
            newnums.push_back(list);
        }
        
        sort(newnums.begin(),newnums.end(),less_than_key());
        
        // binary search
        for(i=0; i<newnums.size(); i++)
        {
            FirstValue = newnums[i].value;
            //cout<<"i= "<<i<<", FirstValue= "<<FirstValue<<'\n';
            maxIndex = newnums.size()-1;
            tempIndex = maxIndex;
            minIndex = i;
            SecondValue = newnums[tempIndex].value;
            
            while(SecondValue != (target - FirstValue) && maxIndex>(minIndex+1))
            {
                //cout<<"minIndex= "<<minIndex<<'\n';
                //cout<<"maxIndex= "<< maxIndex<<'\n';
                
                if((minIndex + maxIndex)%2 == 0)
                    tempIndex = (minIndex + maxIndex)/2;
                else
                    tempIndex = (minIndex + maxIndex - 1)/2;
                    
                SecondValue = newnums[tempIndex].value;
                
                //cout<<"SecondValue= "<<SecondValue<<", tempIndex= "<<tempIndex<<'\n';
                
                if(SecondValue > (target - FirstValue))
                    maxIndex = tempIndex;
                else
                    minIndex = tempIndex;
            }
            
            if(SecondValue == (target - FirstValue))
            {
                map.push_back(newnums[i].index);
                map.push_back(newnums[tempIndex].index);
                return map;
            }
            
        }
        
    }
};