package DatsStructure;

public class CreateOwnArray {
	//ʵ����һ����������
	private static  <T> T[] createInstance(Class<T> cls,int Maxsize){
		T[] obj = null;
		obj = (T[])new Object[Maxsize];
		return obj;
	}
	private Object[] arr;//����һ������ΪT������
	private int elements=0;//��������Ԫ�ظ���
	private int Maxsize;//���������С
	public CreateOwnArray(Class cls,int Maxsize){
		this.Maxsize=Maxsize;
		arr =this.createInstance(cls,Maxsize);;		
	}
	
	//Ĭ��Ϊ�������飬��СΪ50
	public CreateOwnArray(){
	arr =  this.createInstance(Integer.class,50);;		
	}
	//��ʾ����
	public void display(){
		System.out.print("[");
		for(int i =0;i<this.elements;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println("]");
	}
	//������ĩβ��
	public void addElement(Object obj){
		arr[elements]= obj;
		this.elements++;
	}
	//������ָ��λ����
	public void addIndexElements(int index,Object obj) {
		if(index>elements&&index<0)throw new ArrayIndexOutOfBoundsException();
		int i;
		//����Ԫ�ز��ܳ������鳤�ȣ�
		for(i=0;i<this.elements&&elements<this.Maxsize;i++){
			//�ҵ���ӵ�λ��ʱ��������Ԫ������һ����λ
			if(i==index){
				this.elements++;
				break;
			}
		}
		//�����������Ų��������λ�Ӻ��ֵ�������Ųһ��λ��
		for(int j=elements;j>i;j--)arr[j]=arr[j-1];
		arr[index]=obj;
	}
	
	//ɾ��ָ��λ�õ�ֵ
	public void deleteIndexElements(int index){
		
		if(index>=this.elements||index<0){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			//ɾ��Ԫ��ʱֻ�轫ָ��λ��֮���������ǰŲһ����λ
			for(int i=index;i<elements;i++){
				arr[i]=arr[i+1];
			}		
			this.elements--;
		}
		
}
	//��ֵ������
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
	
	//����ָ��λ�õ�ֵ
	public void updateElements(int index,Object newElement){
		for(int i=0;i<elements;i++){
			if(i==index)arr[i-1]=newElement;
		}
	}
	
	public static void main(String[] args) throws Exception{
//   	CreateOwnArray arr1 = new CreateOwnArray();
//		CreateOwnArray arr2 = new CreateOwnArray(String.class, 50);
/*

	��String���ͽ��в���
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
	 * ��Long����
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
