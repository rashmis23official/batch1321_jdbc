package prepareddemos;


class A
{
	String x;
	void dis()
	{
		{
			 x="hello";
			System.out.println("dis--x = "+x);
		}
		System.out.println("dis--x = "+x);
	}
	void show()
	{
		System.out.println("show--x = "+x);
	}	
}
public class Sample {
	public static void main(String[] args) {
		A obj=new A();
		obj.show();		
	}
}
