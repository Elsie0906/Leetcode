// Name: Yin-Hsia Yen
// USC NetID: yinhsiay
// CS 455 PA4
// Fall 2017


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.io.*;

public class LCATester {
  public static void main(String[] args)  {  

      Solution sol = new Solution();  
      TreeNode root = build();
      TreeNode lca = sol.lowestCommonAncestor(root,root.left,root.right.right);
      System.out.println("lca: " + lca.val);    
  }

  private static TreeNode build(){
      TreeNode p = new TreeNode(3);

      p.left = new TreeNode(5);
      p.right = new TreeNode(1);

      TreeNode pp = p.left;

      pp.left = new TreeNode(6);
      pp.right = new TreeNode(2);

      pp = pp.right;
      pp.left = new TreeNode(7);
      pp.right = new TreeNode(4);

      pp = p.right;
      pp.left = new TreeNode(0);
      pp.right = new TreeNode(8);


      return p;
  }
}
