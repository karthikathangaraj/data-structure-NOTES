package algorithms;

import java.util.LinkedList;

//class  Node
//{
//	int data;
//	Node next;
//	Node(int d1)
//	{
//		this.data=d1;//21
//		this.next=null;
//	}
//	
//}
//class LinkedList
//{
//	Node head;
//	public void insert(int data)//20
//	{
//		Node n1=new Node(data);
//		n1.next=head;
//		head=n1;
//	}
//	public void insert1(int data)
//	{
//		Node n2=new Node(data);
//		if(head==null)
//		{
//			head=n2;
//			return;
//		}
//		Node last=head;
//		while(last.next != null)
//		{
//			last=last.next;
//		}
//		last.next=n2;
//	}
//	public void prints()
//	{
//		Node n3=head;
//		while(n3 !=null)
//		{
//			
//			System.out.println(n3.data + " ");	
//            n3=n3.next;
//		}
//		System.out.println();
//	}
//}
public class list11 {

	public static void main(String[] args) {
//		LinkedList l1=new LinkedList();
//		l1.insert1(301); 
//		l1.insert(12); p
//		l1.insert(112);
//		l1.insert1(30); 
//		l1.prints();
		LinkedList l1=new LinkedList();
		l1.addFirst(12);
		
		l1.addLast(34);
	    System.out.println(l1);
		

	}

}
