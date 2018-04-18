package DataStructure;

import java.util.Arrays;

/*
 * ��������-->����ð������
 */
public class QuickSort {
	
	//���������
	public static int splitGroup(int[] arr,int low,int high){
		//�ؼ���Ϊ���һ��
		int point =arr[high];
		//�ӵ�һ����ʼ�ȣ�����Ӧ��ָ��ǰһ��
		low = low-1;
		//��ÿһ�η��鶼����low<high��ʱ���˳�ѭ��
		while(low<high){
			//��Ϊ�ؼ��������һ������Ӧ�ý����ڹؼ��ֵĶ�������ߣ�����Ӧ�ô���߿�ʼѭ���Ƚϣ�����������ʱswap
			//����ؼ���ѡ��һ����ʱ����Ӧ���ȴ��ұ߿�ʼ
			while(low<high&&arr[++low]<=point);
			Swap.swap(arr, low,high);
			//�Ƚ������֮���ٱȽ��ұ�
			while(high>low&&arr[--high]>=point);
			Swap.swap(arr, low,high);
		}
		return low;
	}
	
	public static  void sort(int[] arr,int low,int high){
		int point = 0;
		if(low<high){
			//��ס�����
			point = splitGroup(arr, low, high);
			//����߽�������
			sort(arr,low,point-1);
			//���ұ߽�������
			sort(arr,point+1,high);
		}
	}
	
	public static void Sort(int arr[]){
		sort(arr,0,arr.length-1);
	}
	
	
	public static void main(String[] args){
		int[] arr = {5,56,86,4,-4,57};
		System.out.println(Arrays.toString(arr));
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	
		
	}
}
