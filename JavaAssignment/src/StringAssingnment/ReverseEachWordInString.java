package StringAssingnment;

import java.util.Stack;

public class ReverseEachWordInString {

	public void reverseWord(String str)
	{
		String revString=" ";
		String[] words=str.split(" ");
		for(int i=words.length-1;i>=0;i--)
		{
			String revWord=words[i];
			revString=revString+revWord+" ";
		}
		System.out.println(revString);
	}
	public void reverseUsingStack(String str)
	{
		String[] word=str.split(" ");
		Stack<String> s=new Stack<String>();
	    for(int i=0;i<=word.length-1;i++)
	    {
	    	s.push(word[i]);
	    }
	    while(!s.empty())
	    {
	    	System.out.print(s.pop() + " ");
	    }
	}
	public static void main(String[] args) {
			
		ReverseEachWordInString reverse=new ReverseEachWordInString();
		reverse.reverseWord("I Love Java");
		reverse.reverseUsingStack("I Love Java");
	}

}
