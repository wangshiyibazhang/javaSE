package DataStructure;

import java.util.Arrays;
import java.util.Random;

public class AllSimpleSort {
	
	//冒泡排序
	public static int[] BubbleSort(int[] arr){
		
		if(arr.length==0||arr==null){
			return null;
		}
		int temp =0;
		for(int j=0;j<arr.length;j++){
			for(int i =arr.length-1;i>j;i--){//从最后一个元素开始
				//当最后一个元素小于上一个元素时向上移动
				if(arr[i]<=arr[i-1]){
					Swap.swap(arr, i, i-1);
				}
			}
		}
		return arr;
	}
	
	//选择排序
	public static int[] selectSort(int[] arr){
		//初始化一个变量储存嘴角那个元素
		int min =0;
		//初始化一个中间变量用来装调换元素
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			min=i;//先将第一个定义为最小那个，然后和后面进行比较
			//从第i个开始，因为前面已经是比较好的
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[min]){//
					min=j;//当后面的值还小于最小的时候将其索引付给最小
				}
			}
			//进行调换
			if(i!=min){
				Swap.swap(arr, i, min);
			}
		}
		return arr;
	}
	
	//插入排序1
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
	
	//插入排序2
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
