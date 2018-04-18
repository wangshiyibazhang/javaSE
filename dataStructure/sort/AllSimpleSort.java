package DataStructure;

import java.util.Arrays;
import java.util.Random;

public class AllSimpleSort {
	
	//ð������
	public static int[] BubbleSort(int[] arr){
		
		if(arr.length==0||arr==null){
			return null;
		}
		int temp =0;
		for(int j=0;j<arr.length;j++){
			for(int i =arr.length-1;i>j;i--){//�����һ��Ԫ�ؿ�ʼ
				//�����һ��Ԫ��С����һ��Ԫ��ʱ�����ƶ�
				if(arr[i]<=arr[i-1]){
					Swap.swap(arr, i, i-1);
				}
			}
		}
		return arr;
	}
	
	//ѡ������
	public static int[] selectSort(int[] arr){
		//��ʼ��һ��������������Ǹ�Ԫ��
		int min =0;
		//��ʼ��һ���м��������װ����Ԫ��
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			min=i;//�Ƚ���һ������Ϊ��С�Ǹ���Ȼ��ͺ�����бȽ�
			//�ӵ�i����ʼ����Ϊǰ���Ѿ��ǱȽϺõ�
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[min]){//
					min=j;//�������ֵ��С����С��ʱ��������������С
				}
			}
			//���е���
			if(i!=min){
				Swap.swap(arr, i, min);
			}
		}
		return arr;
	}
	
	//��������1
	public static int[] insertSort(int[] arr){
		int temp = 0;
		for(int i=1;i<arr.length;i++){
			temp=arr[i];
			int j=i;
			while(arr[j]>=temp&&j>0){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
		return arr;	
	}
	
	//��������2
	public static int[] InsertSort(int[] arr){
		int temp = 0;
		for(int i=1;i<arr.length;i++){
			for(int j=i;j>0&&arr[j-1]>arr[j];j--){
				Swap.swap(arr, j, j-1);
			}
		}
		return arr;
	}
	
	
	public static void main(String[] args){
		int[] arr = {5,56,86,4,-4,57};
		System.out.println(Arrays.toString(arr));
		System.out.print("[");
		for(int a : AllSimpleSort.BubbleSort(arr))System.out.print(a+",");
		System.out.print("]");
	}
}
