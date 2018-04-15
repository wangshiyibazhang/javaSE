package DatsStructure;


import java.util.LinkedList;

import javax.naming.NotContextException;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class LinkList<T> {
	private Node first;//定义头结点
	private int size=0;
	public LinkList(){
		this.first = null;
	}
	
	//从头部插入一个结点
	public void insertFirstNode(T data){
		Node temp = new Node(data);
	    temp.next=first;
		first = temp;
		size++;
	}
	
	//删除一个头结点并返回
	public Node deleteFirstNode(){
		Node temp = first;
		first =temp.next;
		size--;
		return temp;
	}
	
	
	
	//根据值查找数据
	public Node find(T value) throws NotFoundException{
		Node current = first;
		while(current.data!=value||!current.data.equals(value)){
			if(current.next==null){
				throw new NotFoundException("查找数据不存在");
			}
			current=current.next;
		}
		return current;
	}
	
	//删除节点
	public Node deleteNode(Object value) throws NotFoundException{
		Node current =first;
		Node previous = first;
		while(current.data!=value||!current.data.equals(value)){
			if(current.next==null){
				throw new NotFoundException("删除数据不存在");
			}
			previous = current;//记住当前节点
			current = current.next;//指向当前节点的下一个节点
		}
		
		if(current==first){
			first = first.next;
		}
		previous.next=current.next;//前一个节点的指针指向当前节点的下一个节点
		return current;
		
	}
	//查看链表长度
		public int size(){
			return size;
		}
	//显示
	public void display(){
		Node current = this.first;
		while(current!=null){
			current.show();
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws NotFoundException {
		LinkList<String> list = new LinkList<String>();
		list.insertFirstNode("1");
		list.insertFirstNode("2");
		list.insertFirstNode("3");
		list.insertFirstNode("4");
		
		list.display();
	
//		list.deleteFirstNode();
//		list.display();
		
		System.out.println(list.size());
		System.out.println(list.find("3").data);
		
	}
}
class Node{
	
	//数据域
	protected Object data ;
    //指针域
	protected Node next;
    public Node(Object data){
    	this.data=data;
    }
	
    public void show(){
    	System.out.print(data+"->");
    }
	
}
class NotFoundException extends Exception{
	public NotFoundException(String messages){
		super();
	}
}
