package DataStructure;

import java.util.Arrays;
/*
 * 希尔排序-->基于插入排序
 */
public class ShellSort {
	public static void Sort(int[] arr){
		//初始化跨度为1
		int h=1;
		//当跨度小于长的1/3时，跨度为h=h*3+1
		while(h<(arr.length / 3))h =3 * h+1;
		
		//当跨度大于0时一直进行插入排序
		int temp =0;
		while(h>0){
			//从第一个元素开始和第h个进行比较
			for(int i=h;i<arr.length;i++){
				//交换第j个和从j开始的第h个跨度为
				for(int j=i;j>=h&&arr[j-h]>arr[j];j-=h){
					Swap.swap(arr, j, j-h);
				}			}
			//跨度逐渐减小
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
