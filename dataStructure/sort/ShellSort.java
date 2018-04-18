package DataStructure;

import java.util.Arrays;
/*
 * ϣ������-->���ڲ�������
 */
public class ShellSort {
	public static void Sort(int[] arr){
		//��ʼ�����Ϊ1
		int h=1;
		//�����С�ڳ���1/3ʱ�����Ϊh=h*3+1
		while(h<(arr.length / 3))h =3 * h+1;
		
		//����ȴ���0ʱһֱ���в�������
		int temp =0;
		while(h>0){
			//�ӵ�һ��Ԫ�ؿ�ʼ�͵�h�����бȽ�
			for(int i=h;i<arr.length;i++){
				//������j���ʹ�j��ʼ�ĵ�h�����Ϊ
				for(int j=i;j>=h&&arr[j-h]>arr[j];j-=h){
					Swap.swap(arr, j, j-h);
				}			}
			//����𽥼�С
			h=(h-1)/3;
		}
	}
	

	public static void main(String[] args){
		int[] arr = new int[5];
		arr[0]=23;
		arr[1]=3;
		arr[2]=-2;
		arr[3]=36;
		arr[4]=43;
		System.out.println(Arrays.toString(arr));
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
