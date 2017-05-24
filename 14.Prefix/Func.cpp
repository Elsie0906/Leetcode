#include <iostream>
#include <stream>

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        int len = 0;
        int tempCount,count;
        string str1,str2;
        string PrefixStr("");
      
        //cout << "vector size = "<< strs.size() <<'\n';
        
        // exceptional case, NULL pointer
        if(strs.size() == 0)
           return PrefixStr;
           
        // exceptional case, only one string ["a"]   
        if(strs.size() == 1)
           return strs[0];
        
        #if 0
        for (int i=0; i<strs.size(); i++)
            cout << strs[i] << '\n';
        #endif
        
        count = 0;
        
        for(int i=0; i<strs.size()-1; i++)
        {
            // take two strings
            // compare to the next item, input = ["abc","a", "ccc"]
            str1 = strs[i];
            str2 = strs[i+1];
               
            //cout<< "str1 = "<< str1<< ", str2 = "<< str2 << '\n';   
        
            // start to compare
        
            len = min(str1.size(),str2.size());
            
            if(i!=0 && len > count)
               len = count;
            //cout << "comparing len = "<< len <<'\n';
        
            tempCount = 0;
            
            for (int j=0; j< len; j++)
            {
                if(str1[j] == str2[j])
                   tempCount = tempCount+1;
                else
                   break;                 // input = ["aca", "cba"]
            }
        
            //cout << "matched temp len = "<< tempCount <<'\n';
        
            if(i == 0)
               count = tempCount;
               
            if(tempCount <= count)
               count = tempCount;
           
            //cout << "matched len = "<< count << '\n';   
        }
        
        for(int i=0; i< count; i++)
            PrefixStr.push_back(str1[i]);
        
        return PrefixStr;
        
    }
};