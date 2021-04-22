/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
 */

package Cracking.Coding.Interview.TechnicalQuestions;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String args[]) {

        System.out.println(longestValidParentheses(")()(((()())"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> charStack = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                charStack.push(c);
            } else if(!charStack.empty()) {
                charStack.pop();
                count = count+2;
            }
        }
        return count;
    }
}
