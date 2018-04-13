package DatsStructure;

public class operateStack {
	private int Maxsize;
	private Object stack[];
	private int index=-1;
	public operateStack(){
		stack = new Object[10];
	}
	public operateStack(int Maxsize){
		this.Maxsize =Maxsize;
		stack = new Object[Maxsize];
	}
	//��ջ
	public  void Push(Object obj){			
		if(index>stack.length-1)throw new StackOverflowError("ջ����");
		index++;
		stack[index]=obj;
	}
	
	//��ջ
	public  Object Pop(){
		Object temp;
		if(index==-1)throw new StackOverflowError("ջ���ˣ�");
		temp = stack[index];
		index--;
		return temp;
	}
	
	//�鿴����
	public Object peek(){
		return stack[index];
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public Boolean isEmpty(){
		return index==-1;
	}
	
	//�ж��Ƿ�ջ��
	public boolean isFull(){
		return index==stack.length-1;
	}
	
	public static void main(String[] args){
		operateStack mystack = new operateStack();
		mystack.Push("a");
		mystack.Push("b");
		mystack.Push("c");
		mystack.Push("d");
		mystack.Push("e");
		mystack.Push("f");
		System.out.print("��ջ�ɹ���");
		System.out.println(mystack.isFull()?"ջ����":"ջδ��");
		
		System.out.println("��ʱջ������Ϊ-->"+mystack.peek());
		
		System.out.println("��������Ϊ-->"+mystack.Pop());
		
		System.out.println("��ʱջ������Ϊ-->"+mystack.peek());
		
		System.out.println(mystack.isEmpty()?"ջΪ��":"ջ�ǿ�");

	}
}
