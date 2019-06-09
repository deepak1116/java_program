
import java.util.Scanner;

public class flames {
	//flames fun = new flames();
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String first,second;
		System.out.print("Enter first name:");
		first = sc.nextLine();
		System.out.print("Enter second name:");
		second = sc.nextLine();
		char[] f1=first.toCharArray(),f2=second.toCharArray();
		int len1=f1.length,len2=f2.length,count=0,finallen;
		
		for(int i=0;i<len1;i++)
		{
			for(int j=0;j<len2;j++)
			{
				if(f1[i]==f2[j])
				{
					f1[i]='!';f2[j]='!';
					count+=2;break;
				}
			}
		}
		finallen = len1+len2-count;
		String[] arr= {"Friend","Love","Affection","Marriage","Enemy","Sister"};
		String answer = find(finallen,arr,6);
		System.out.println(answer);
		sc.close();
	}
	public static String find(int len,String[] arr,int arrlen)
	{
		int i=len,check,length=arrlen,count=0;
		check=len;
		while(i>length)
		{
			if(count==0)
			{
				i=check-length;
				count=1;
			}
			else
			{	i-=length;
			}
		}
		i--;
		if(i!=length-1)
		for(int j=i;j<length-1;j++)
		{
			arr[j]=arr[j+1];
		}
		else
			i=0;
		arr[length-1]=null;
		length--;
		if(i!=0)
		for(int j=0;j<i;j++)
		{
			String temp = arr[0];
			for(int k=0;k<length-1;k++)
			{
				arr[k]=arr[k+1];
			}
			arr[length-1]=temp;
		}
		if(length!=1)
		{
			find(len,arr,length);
		}
		return arr[0];
	}
	public static void printarr(char[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
