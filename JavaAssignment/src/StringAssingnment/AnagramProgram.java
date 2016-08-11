package StringAssingnment;

import java.util.Arrays;

public class AnagramProgram {
	
	public void checkAnagram(String str1,String str2)
	{
		String newStr1=str1.replaceAll("\\s", "");
		String newStr2=str2.replaceAll("\\s", "");
		boolean status=false;
		if(newStr1.length()!=newStr2.length())
		{
			status =false;
		}else
		{
			char[] newArr1=newStr1.toCharArray();
			char[] newArr2=newStr2.toCharArray();
			Arrays.sort(newArr1);
			Arrays.sort(newArr2);
			status=Arrays.equals(newArr1, newArr2);
		}
		if(status=true)
		{
			System.out.println("The given two strings are anagram");
		}else
		{
			System.out.println("The given two strings are not anagram");
		}
	}

	public static void main(String[] args) {
		AnagramProgram anagram=new AnagramProgram();
		anagram.checkAnagram("Mother In Law", "Hitler Women");

	}

}
