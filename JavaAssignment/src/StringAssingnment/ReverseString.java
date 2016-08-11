package StringAssingnment;

public class ReverseString {
	String revStr=" ";
	public void revString(String str)
	{
		for(int i=str.length()-1;i>=0;i--)
		{
			revStr=revStr+str.charAt(i);
		}
		System.out.println(revStr);
	}
	public String revStringRec(String str)
	{
		if(str ==null ||str.length()<=1)
		{
			return str;
		}
		else
		{
			return str.charAt(str.length()-1)+revStringRec(str.substring(0, str.length()-1));
		}
	}

	public static void main(String[] args) {
		ReverseString reverse=new ReverseString();
		reverse.revString("I Love Java");
		String newStr=reverse.revStringRec("I Love Java");
		System.out.println(newStr);

	}

}
