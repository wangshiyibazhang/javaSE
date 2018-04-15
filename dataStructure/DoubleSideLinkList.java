package DataStructure;


public class DoubleSideLinkList<T> {
	//头结点
	private Node first;
	//尾节点
	private Node last;
	//链表长度
	private int size=0;
	//插入一个头结点
	public void insertFirstNode(T data){
		Node temp = new Node(data);
		if(isEmpty()){       //链表为空时，也为尾节点
			this.last=temp;
		}else{
			first.previous=temp;//否则头结点前一个节点指向新节点
		}
		temp.next =first;
		first = temp;
		size++;
	}
	
	//在尾部插入节点
	public void insertLastNode(T data){
		Node temp = new Node(data);
		if(isEmpty()){
			first=temp;
		}else{
			last.next=temp;
			temp.previous=last;
		}
		last=temp;
		size++;
	}
	
	//从头部删除一个节点
	public T deleteFirstNode(){
		Node temp = first;
		if(first.next==null){
			last=null;
		}else{
			first.next.previous=null;
		}
		first=temp.next;
		size--;
		return (T)temp.data;
	}
	
	//从尾部删除一个节点
	public T deleteLastNode(){
		Node temp = last;
		if(first.next==null){
			first=null;
		}else{
			temp.previous.next=null;
			last=temp.previous;
		}
		size--;
		return (T)temp.data;
	}
	
	//判断链表是否为空
	public boolean isEmpty(){
		return first==null;
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
			current.previous.next=current.next;//前一个节点的指针指向当前节点的下一个节点
			size--;
			return current;
			
		}
		//查看链表长度
			public int getSize(){
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
		public static void main(String[] args) throws NotFoundException{
			DoubleSideLinkList<String> dsl = new DoubleSideLinkList<String>();
			
			dsl.insertFirstNode("5");
			dsl.insertFirstNode("4");
			dsl.insertFirstNode("3");
			dsl.insertFirstNode("2");
			dsl.insertFirstNode("1");
			
	//		dsl.display();

//			dsl.deleteFirstNode();
//			dsl.display();
			dsl.insertLastNode("6");
			dsl.insertLastNode("7");
			dsl.insertLastNode("8");
			dsl.insertLastNode("9");
			dsl.insertLastNode("0");
			
			
			dsl.display();
			System.out.println(dsl.getSize());
//			dsl.deleteLastNode();
//			dsl.display();
		
			dsl.deleteNode("7");
			dsl.display();
			System.out.println(dsl.getSize());
			
			
		
		}
}


