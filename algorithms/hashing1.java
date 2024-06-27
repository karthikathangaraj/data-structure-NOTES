package algorithms;
class simplehashing
{
	private int[] ht;
	private int ts;
	public simplehashing(int s)
	{
	ts=s;
	ht=new int[s];
	for(int i=0;i<ts;i++)
		ht[i]=-1;
	}	
private int hashfunction(int key)
{
	return key%ts;
}
public void insert(int key)
{
	int hv=hashfunction(key);
	while(ht[hv]!=-1)
	{
		hv=(hv+1)%ts;
	}
	ht[hv]=key;
	
}

public void display()
{
	System.out.println("values in table");
	for(int i=0;i<ts;i++)
	{
		if(ht[i] !=-1)
		   System.out.println(i+ "---->"+ht[i]);
		else
			System.out.println(i+"--->"+"null");
	}
	
}
}
public class hashing1 {

	public static void main(String[] args) {
		simplehashing h1=new simplehashing(10);
		int[] key= {10,20,30};
		for(int k:key)
		{
			h1.insert(k);
		}
		h1.display();
	}

}
