package DatsStructure;


import java.util.LinkedList;

import javax.naming.NotContextException;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class LinkList<T> {
	private Node first;//����ͷ���
	private int size=0;
	public LinkList(){
		this.first = null;
	}
	
	//��ͷ������һ�����
	public void insertFirstNode(T data){
		Node temp = new Node(data);
	    temp.next=first;
		first = temp;
		size++;
	}
	
	//ɾ��һ��ͷ��㲢����
	public Node deleteFirstNode(){
		Node temp = first;
		first =temp.next;
		size--;
		return temp;
	}
	
	
	
	//����ֵ��������
	public Node find(T value) throws NotFoundException{
		Node current = first;
		while(current.data!=value||!current.data.equals(value)){
			if(current.next==null){
				throw new NotFoundException("�������ݲ�����");
			}
			current=current.next;
		}
		return current;
	}
	
	//ɾ���ڵ�
	public Node deleteNode(Object value) throws NotFoundException{
		Node current =first;
		Node previous = first;
		while(current.data!=value||!current.data.equals(value)){
			if(current.next==null){
				throw new NotFoundException("ɾ�����ݲ�����");
			}
			previous = current;//��ס��ǰ�ڵ�
			current = current.next;//ָ��ǰ�ڵ����һ���ڵ�
		}
		
		if(current==first){
			first = first.next;
		}
		previous.next=current.next;//ǰһ���ڵ��ָ��ָ��ǰ�ڵ����һ���ڵ�
		return current;
		
	}
	//�鿴������
		public int size(){
			return size;
		}
	//��ʾ
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
	
	//������
	protected Object data ;
    //ָ����
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
