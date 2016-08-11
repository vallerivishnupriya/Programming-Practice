package StringAssingnment;

public class ReverseEachWord {
	public void reverseWord(String str)
	{
		String reverseString=" ";
		String[] words=str.split(" ");
		for(int i=0;i<words.length;i++)
		{
			String word=words[i];
			String reverseWord=" ";
			for(int j=word.length()-1;j>=0;j--)
			{
				reverseWord=reverseWord+word.charAt(j);
			}
			reverseString=reverseString+reverseWord+" ";
		}
		System.out.println(reverseString);
	}
public String revWord(String str)
{
	 int strLeng = str.length()-1;
     String reverse = "", temp = "";

     for(int i = 0; i <= strLeng; i++){
         temp += str.charAt(i);
         if((str.charAt(i) == ' ') || (i == strLeng)){
             for(int j = temp.length()-1; j >= 0; j--){
                 reverse += temp.charAt(j);
                 if((j == 0) && (i != strLeng))
                     reverse += " ";
             }
             temp = "";
         }
     }
     return reverse;
}

	public static void main(String[] args) {
		
		ReverseEachWord reverse=new ReverseEachWord();
		reverse.reverseWord("I Love Java");
		 String newReverseWord=reverse.revWord("I Love Java");
		 System.out.println(newReverseWord);
		
	}

}
