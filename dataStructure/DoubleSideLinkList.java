package DataStructure;


public class DoubleSideLinkList<T> {
	//ͷ���
	private Node first;
	//β�ڵ�
	private Node last;
	//������
	private int size=0;
	//����һ��ͷ���
	public void insertFirstNode(T data){
		Node temp = new Node(data);
		if(isEmpty()){       //����Ϊ��ʱ��ҲΪβ�ڵ�
			this.last=temp;
		}else{
			first.previous=temp;//����ͷ���ǰһ���ڵ�ָ���½ڵ�
		}
		temp.next =first;
		first = temp;
		size++;
	}
	
	//��β������ڵ�
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
	
	//��ͷ��ɾ��һ���ڵ�
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
	
	//��β��ɾ��һ���ڵ�
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
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty(){
		return first==null;
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
			current.previous.next=current.next;//ǰһ���ڵ��ָ��ָ��ǰ�ڵ����һ���ڵ�
			size--;
			return current;
			
		}
		//�鿴������
			public int getSize(){
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


