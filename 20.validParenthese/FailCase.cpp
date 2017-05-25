#include <iostream>
#include <new>

using namespace std;

class Lock{
public:
    Lock(void);
    void getLock(char a);
    void releaseLock(char a);
    int checkLock(char a);

private:
    int lock1,lock2,lock3;
};

Lock::Lock()
{
    lock1 = -1;
    lock2 = -1;
    lock3 = -1;
}

int Lock::checkLock(char a)
{
    int result = -1;
    
    switch(a)
    {
        case '(':
                if((lock1 == 0 || lock1 == -1) && lock2 !=1 && lock3 !=1)  // no one use before && no other lock is used
                   result = 0;
                break;
        case '[':
                if(lock1!=1 && (lock2 == 0 || lock2 == -1) && lock3 != 1)
                   result = 0;
                break;   
        case '{':
                if(lock1!=1 && lock2!=1 && (lock3 == 0 || lock3 == -1))
                   result = 0;
                break;   
        case ')':                                      // must be used before && no other lock is used
                if(lock1 == 1 && lock2 !=1 && lock3 !=1 )
                   result = 0;
                   break;
        case ']':
                if(lock1 !=1 && lock2 == 1 && lock3 !=1)
                   result = 0;
                break;
        case '}':
                if(lock1 !=1 && lock2 !=1 && lock3 == 1)
                   result = 0;
                break;
        default:
                break;
        
    }
    
    return result;
}

void Lock::getLock(char a)
{
    switch(a)
    {
        case '(':
                lock1 = 1;
                //cout<< "get lock1 = "<<lock1 << '\n';
                break;
        case '[':
                lock2 = 1;
                //cout<< "get lock2 = "<<lock2 << '\n';
                break;
        case '{':
                lock3 = 1;
                //cout<< "get lock3 = "<<lock3 << '\n';
                break;
        default:
                cout<< "undifined char" << '\n';
    }
}

void Lock::releaseLock(char a)
{
    switch(a)
    {
        case ')':
                lock1 = 0;
                //cout << "release lock1 = " << lock1 << '\n';
                break;
        case ']':
                lock2 = 0;
                //cout << "release lock2 = " << lock2 << '\n';
                break;                
        case '}':
                lock3 = 0;
                //cout << "release lock3 = " << lock3 << '\n';
                break;                
        default:
                cout<< "undifined char" << '\n';        
    }
}

class Solution {
public:
    bool isValid(string s) {
        
        bool result = true;
        char input;
        int checkResult;
        Lock lock;
        
        //cout << "string size = "<< s.size()<<'\n';
        
        // can't be paired, ex. '['
        
        if(s.size()%2 == 1)
            return false;
        
        for(int i=0; i< s.size();i++)
        {
            input = s[i];
            //cout <<"input char = "<< input << '\n';
            
            checkResult = lock.checkLock(input);
            //cout << "check Lock = "<< checkResult <<'\n';
            
            if(checkResult == -1)
               return false;
            
            if(input == '(' || input == '[' || input == '{')
               lock.getLock(input);
            
            if(input == ')' || input == ']' || input == '}')
               lock.releaseLock(input);
        }
        
        return result;
        
    }
};