package DataStructure;

import java.util.Arrays;

/*
 * 快速排序-->基于冒泡排序
 */
public class QuickSort {
	
	//将数组分组
	public static int splitGroup(int[] arr,int low,int high){
		//关键字为最后一个
		int point =arr[high];
		//从第一个开始比，索引应该指向前一个
		low = low-1;
		//当每一次分组都满足low<high的时候退出循环
		while(low<high){
			//因为关键字是最后一个，且应该讲大于关键字的都放在左边，所以应该从左边开始循环比较，不满足条件时swap
			//如果关键字选第一个数时，就应该先从右边开始
			while(low<high&&arr[++low]<=point);
			Swap.swap(arr, low,high);
			//比较玩左边之后再比较右边
			while(high>low&&arr[--high]>=point);
			Swap.swap(arr, low,high);
		}
		return low;
	}
	
	public static  void sort(int[] arr,int low,int high){
		int point = 0;
		if(low<high){
			//记住分组点
			point = splitGroup(arr, low, high);
			//对左边进行排序
			sort(arr,low,point-1);
			//对右边进行排序
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
