import java.util.ArrayList;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low>high) return;
        int pivot=divide(arr,low,high);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }

    private static int divide(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low; j<arr.length; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
            i++;
            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;
        return i;

    }

    private static int[] mergeSort(int[] arr, int si,int ei) {
        if(si>=ei){
            return arr;
        }
        int mid=si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
        return arr;
    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int ind1=si,ind2=mid+1;
        int[] merge=new int[ei-si+1];
        int x=0;
        while(ind1<=mid && ind2<=ei){
            if(arr[ind1]<arr[ind2]){
                merge[x++]=arr[ind1++];
            }
            else{
                merge[x++]=arr[ind2++];
            }
        }
        while(ind1<=mid){
            merge[x++]=arr[ind1++];
        }
        while(ind2<=ei){
            merge[x++]=arr[ind2++];
        }
        for(int i=0,j=si; i<merge.length; i++,j++){
            arr[j]=merge[i];
        }

    }

    private static int[] selectionSort(int[] arr, int n) {
        for(int i=0;i<n-1; i++){
            int min=arr[i];
            int min_index=i;
            for(int j=i+1; j<n; j++){
                if(min>arr[j]){
                    min=arr[j];
                    min_index=j;
                }
            }
            if(min_index!=i){
                int temp=arr[i];
                arr[i]=arr[min_index];
                arr[min_index]=temp;
            }
        }
        return arr;
    }

    private static int[] bubbleSort(int[] arr, int n) {

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }

    private static int[] insertionSort(int[] arr, int n){
        for(int i=1; i<n; i++){
            int j=i-1;
            int curr=arr[i];
            while(j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
        return arr;
    }

}