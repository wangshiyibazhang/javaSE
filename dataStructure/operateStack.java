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
	//入栈
	public  void Push(Object obj){			
		if(index>stack.length-1)throw new StackOverflowError("栈满了");
		index++;
		stack[index]=obj;
	}
	
	//出栈
	public  Object Pop(){
		Object temp;
		if(index==-1)throw new StackOverflowError("栈空了！");
		temp = stack[index];
		index--;
		return temp;
	}
	
	//查看数据
	public Object peek(){
		return stack[index];
	}
	
	//判断栈是否为空
	public Boolean isEmpty(){
		return index==-1;
	}
	
	//判断是否栈满
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
		System.out.print("入栈成功，");
		System.out.println(mystack.isFull()?"栈满了":"栈未满");
		
		System.out.println("此时栈顶数据为-->"+mystack.peek());
		
		System.out.println("弹出数据为-->"+mystack.Pop());
		
		System.out.println("此时栈顶数据为-->"+mystack.peek());
		
		System.out.println(mystack.isEmpty()?"栈为空":"栈非空");

	}
}
