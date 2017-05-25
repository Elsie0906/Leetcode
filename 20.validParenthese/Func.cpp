/* 
   Example:
   
   '([])' -> TRUE
   '([)]' -> FALSE
   '(['   -> FALSE
   '('    -> FALSE
  
    1. must be paired
    2. using two stacks: Lock & Unlock -> check order
*/   
#include <iostream>
#include <new>
#include <vector>


class myStack{
public:
        void checkStatus(void);
        void push(char inputPush);
        int checkValid(char inputCheck);
        int finalCheck(void);
private:
        vector<char> Lock;
        vector<char> Unlock;
};

int myStack::finalCheck(void){
    
    int result = 0;
    
    if(Lock.size() !=0 || Unlock.size() !=0)
       result = -1;
       
    return result;   
}

int myStack::checkValid(char inputCheck){
    
    int result = -1;
    
    switch(inputCheck)
    {
        case ')':
                if(!Lock.empty() && Lock.back() == 'a')
                {
                   //cout<<"Case1"<<'\n';    
                   result = 0;
                   Lock.pop_back();
                   Unlock.pop_back();
                } 
                break;
        case ']':
                if(!Lock.empty() && Lock.back() == 'b')
                {
                   //cout<<"Case2"<<'\n';    
                   result = 0;
                   Lock.pop_back();
                   Unlock.pop_back();
                }   
                break;
        case '}':
                if(!Lock.empty() && Lock.back() == 'c')
                {
                   //cout<<"Case3"<<'\n';    
                   result = 0;
                   Lock.pop_back();
                   Unlock.pop_back();
                }
                break;
        default:
                if(inputCheck == '(' || inputCheck == '[' || inputCheck == '{')
                    result = 0;
                break;
    }
    
    return result;
}

void myStack::checkStatus(void){
    
    cout<< "myStack:Lock = ";
    
    for(int i=0; i< Lock.size(); i++)
        cout<< Lock[i];
        
    cout<<'\n';    
    
    cout<< "myStack:Unlock = ";
    
    for(int i=0; i< Unlock.size(); i++)
        cout<< Unlock[i];
        
    cout<<'\n'; 
}

void myStack::push(char inputPush){
    
    switch(inputPush)
    {
        case '(':
                Lock.push_back('a');
                //cout<< "Lock stack: insert a for ("<<'\n';
                break;
        case '[':
                Lock.push_back('b');
                //cout<< "Lock stack: insert b for ["<<'\n';                
                break;
        case '{':
                Lock.push_back('c');
                //cout<< "Lock stack: insert c for {"<<'\n';                
                break;
        case ')':
                Unlock.push_back('a');
                //cout<< "Unlock stack: insert a for )"<<'\n';
                break;     
        case ']':
                Unlock.push_back('b');
                //cout<< "Unlock stack: insert b for ]"<<'\n';
                break; 
        case '}':
                Unlock.push_back('c');
                //cout<< "Unlock stack: insert c for }"<<'\n';
                break;                
        default:
                cout<< "undefined char"<<'\n';
    }
}

class Solution {
public:
    bool isValid(string s) {
        
        bool result = true;
        int tempResult;
        myStack myS;
        char input;
        
        //cout<< "string size = " << s.size()<< '\n';
        
        if(s.size()%2 == 1)
           return false;
        
        for(int i=0; i<s.size(); i++)
        {
            input = s[i];
            myS.push(input);
            
            //myS.checkStatus(); 
            
            tempResult = myS.checkValid(input);
            //cout<<"temp result = "<< tempResult<<'\n';

            if(tempResult == -1)
               return false;
               
        }
         
        //myS.checkStatus();   
        
        tempResult = myS.finalCheck();    // ex.'(('
        
        if(tempResult == -1)
           result = false;
        
        return result;
    }
};