package DatsStructure;

public class CreateOwnArray {
	//实例化一个泛型数组
	private static  <T> T[] createInstance(Class<T> cls,int Maxsize){
		T[] obj = null;
		obj = (T[])new Object[Maxsize];
		return obj;
	}
	private Object[] arr;//声明一个类型为T的数组
	private int elements=0;//声明数组元素个数
	private int Maxsize;//设置数组大小
	public CreateOwnArray(Class cls,int Maxsize){
		this.Maxsize=Maxsize;
		arr =this.createInstance(cls,Maxsize);;		
	}
	
	//默认为整形数组，大小为50
	public CreateOwnArray(){
	arr =  this.createInstance(Integer.class,50);;		
	}
	//显示数组
	public void display(){
		System.out.print("[");
		for(int i =0;i<this.elements;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println("]");
	}
	//在数组末尾增
	public void addElement(Object obj){
		arr[elements]= obj;
		this.elements++;
	}
	//在数组指定位置增
	public void addIndexElements(int index,Object obj) {
		if(index>elements&&index<0)throw new ArrayIndexOutOfBoundsException();
		int i;
		//数组元素不能超过数组长度，
		for(i=0;i<this.elements&&elements<this.Maxsize;i++){
			//找到添加的位置时，让数组元素增加一个单位
			if(i==index){
				this.elements++;
				break;
			}
		}
		//从数组最后面挪，将索引位子后的值依次向后挪一个位置
		for(int j=elements;j>i;j--)arr[j]=arr[j-1];
		arr[index]=obj;
	}
	
	//删除指定位置的值
	public void deleteIndexElements(int index){
		
		if(index>=this.elements||index<0){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			//删除元素时只需将指定位置之后的索引向前挪一个单位
			for(int i=index;i<elements;i++){
				arr[i]=arr[i+1];
			}		
			this.elements--;
		}
		
}
	//按值查索引
	public int getElement(Object obj){
		int index=0;
		boolean flag = false;
		for(int i=0;i<elements;i++){
			if(arr[i]==obj||arr[i].equals(obj)){
				index =i+1;
				flag = true;
			}
		}
		return flag==true?index:-1;
	}
	
	//更新指定位置的值
	public void updateElements(int index,Object newElement){
		for(int i=0;i<elements;i++){
			if(i==index)arr[i-1]=newElement;
		}
	}
	
	public static void main(String[] args) throws Exception{
//   	CreateOwnArray arr1 = new CreateOwnArray();
//		CreateOwnArray arr2 = new CreateOwnArray(String.class, 50);
/*

	用String类型进行测试
*/		
//		arr2.addElement("a");
//		arr2.addElement("f");
//		arr2.addElement("s");
//		arr2.addElement("g");
//		arr2.addElement("j");
//		arr2.display();
//		
//		arr2.addIndexElements(2, "b");
//		arr2.display();
//		arr2.deleteIndexElements(2);
		
//		arr2.display();
//		System.out.println(arr2.getElement("j"));
		
//		arr2.updateElements(2,"b");
//		arr2.display();
		
	/*
	 * 用Long类型
	 */
		CreateOwnArray arr3 = new CreateOwnArray(Long.class,50);
		
		for(int i=0;i<10;i++){
			arr3.addElement(i);
		}
		arr3.display();
		
		arr3.addIndexElements(2, 4);
		arr3.display();
	}
}
