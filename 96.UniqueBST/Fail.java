/*
** G(n): the number of unique BST for a sequence of length n.
** F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n
** G(n) = F(1, n) + F(2, n) + ... + F(n, n)
** Particularly, the bottom cases, 
** G(0)=1, G(1)=1
** For example, F(3, 7): the number of unique BST tree with number 3 as its root.
** we need to construct an unique BST out of its left subsequence [1, 2] 
** and another BST out of the right subsequence [4, 5, 6, 7]
** Therefore, F(3,7) = G(2) * G(4)
** F(i, n) = G(i-1) * G(n-i)    1 <= i <= n 
** Combining the above two formulas,
** G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
*/

public class Solution {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
    
        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }
}