package dataStructureAndAlgorithms;

public class 정렬알고리즘 {
    public void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    /** Bubble Sort :: O(n^2) **/
    public void sortByBubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]) swap(arr,j,j+1);
            }
        }
    }

    /** Selection Sort :: O(n^2) **/
    public void sortBySelection(int[] arr){
        for(int i=0;i<arr.length-1;i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            swap(arr,i,minIdx);
        }
    }

    /** Insertion Sort :: O(n^2) 단, 정렬된 경우엔 O(n) **/
    public void sortByInsertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0&&temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }

    /** Quick Sort :: O(NLogN) 단, 정렬된 경우 O(n^2) **/
    public void sortByQuick(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort(int[] arr,int left,int right){
        int part=partition(arr,left,right);
        if(left<part-1) quickSort(arr,left,part-1);
        if(part<right) quickSort(arr,part,right);
    }

    public int partition(int[] arr, int left, int right){
        int pivot=arr[(left+right)/2];
        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }

            while(arr[right]>pivot){
                right--;
            }

            if(left<=right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    /** Merge Sort :: O(NLogN) **/
    public void sortByMerge(int[] arr){
        int[] tempArr=new int[arr.length];
        mergeSort(arr,tempArr,0,arr.length-1);
    }

    public void mergeSort(int[] arr,int[] tempArr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(arr,tempArr,left,mid);
            mergeSort(arr,tempArr,mid+1,right);

            merge(arr,tempArr,left,mid,right);
        }
    }

    public void merge(int[] arr, int[] tempArr,int left,int mid,int right){
        for(int i=left;i<=right;i++){
            tempArr[i]=arr[i];
        }

        int part1=left;
        int part2=mid+1;

        int idx=left;
        while(part1<=mid&&part2<=right){
            if(tempArr[part1]<=tempArr[part2]){
                arr[idx]=tempArr[part1];
                part1++;
            }
            else{
                arr[idx]=tempArr[part2];
                part2++;
            }
            idx++;
        }
        for(int i=0;i<mid-part1;i++){
            arr[idx+i]=tempArr[part1+i];
        }
    }
}
