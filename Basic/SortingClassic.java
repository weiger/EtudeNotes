
public class SortingClassic {
    public static void bubblesort(int[] data) {
	for (int i = 0; i < data.length - 1; i++)
	    for (int j = 0; j < data.length - 1 - i; j++)
		if (data[j] > data[j + 1])
		    swap(data, j, j + 1);
    }

    public static void selectionsort(int[] data) {
	for (int i = 0; i < data.length; i++)
	    for (int j = i; j < data.length; j++)
		if (data[j] < data[i])
		    swap(data, i, j);
    }

    public static void insertionsort(int[] data) {

	for (int i = 1; i < data.length; i++) {
	    int tmp = data[i];
	    int j = i;
	    while (j > 0 && tmp < data[j - 1]) {
		data[j] = data[j - 1];
		j--;
	    }
	    data[j] = tmp;
	}
	/*
	 * for (int i = 1; i < data.length; i++) { for (int j = i - 1; j >= 0 &&
	 * data[j] > data[j + 1]; j--) { swap(data, j, j + 1); } }
	 */
    }

    public static void quicksort(int[] data) {
	quicksorthelper(data, 0, data.length - 1);
    }

    public static void quicksorthelper(int[] data, int beg, int end) {
	if (beg >= end)
	    return;
	int index = beg;
	for (int i = beg; i < end; i++) {
	    if (data[i] <= data[end])
		swap(data, i, index++);
	}
	swap(data, index, end);
	quicksorthelper(data, beg, index - 1);
	quicksorthelper(data, index, end);
    }

    public static void heapsort(int[] data) {
	heapify(data, data.length);
	int end = data.length - 1;
	while (end > 0) {
	    int tmp = data[end];
	    data[end] = data[0];
	    data[0] = tmp;
	    sinkdown(data, 0, end - 1);
	    end--;
	}
    }

    public static void heapify(int[] data, int count) {
	int start = (count - 2) / 2;
	while (start >= 0) {
	    sinkdown(data, start, count - 1);
	    start--;
	}
    }

    public static void sinkdown(int[] data, int start, int end) {
	int root = start;
	while ((root * 2 + 1) <= end) {
	    int child = 2 * root + 1;
	    if (2 * root + 2 <= end && data[child] < data[child + 1])
		child++;
	    if (data[root] < data[child]) {
		int tmp = data[root];
		data[root] = data[child];
		data[child] = tmp;
		root = child;
	    } else
		return;
	}
    }
    public static void mergesort(int[] data){
	int[] helper = new int[data.length];
	mergersorthelper(data,helper,0,data.length-1);
    }
    public static void mergersorthelper(int[] data, int[] helper,int beg, int end) {
	if(beg<end){
	    int mid = (beg + end)/2;
	    mergersorthelper(data,helper,beg,mid);
	    mergersorthelper(data,helper,mid+1,end);
	    merge(data,helper,beg,mid,end);    
	}
    }

    public static void merge(int[] data,int[] helper, int beg, int mid, int end) {
	for(int i= 0;i<=end;i++){
	    helper[i] = data[i];
	}
	int i = beg;
	int j = mid+1;
	int k = beg;
	while(i<=mid && j<=end){
	    if(helper[i]<=helper[j]){
		data[k] = helper[i];
		i++;
	    }else{
		data[k] = helper[j];
		j++;
	    }
	    k++;
	}
	while(i<=mid){
	    data[k] = helper[i];
	    i++;k++;
	}
    }

    public static int[] generatearray(int n) {
	int[] array = new int[n];
	for (int i = 0; i < n; i++) {
	    array[i] = (int) (Math.random() * 20);
	}
	return array;
    }

    public static void print(int[] data) {
	for (int i = 0; i < data.length; i++) {
	    System.out.print(data[i] + " ");
	}
	System.out.println();
    }

    public static void swap(int[] data, int i, int j) {
	int tmp = data[i];
	data[i] = data[j];
	data[j] = tmp;
    }

    public static void main(String[] args) {
	int[] data = generatearray(10);
	print(data);
	mergesort(data);
	print(data);
    }

}
