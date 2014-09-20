/*There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
      	int m = A.length,n=B.length;
      	int i=0,j=0,median = m+n;
      	double prev=0,last=0;
      	if(median<2){
      	    if(m==0 && n==0) return 0;
      	    if(m==1) return A[0];
      	    else return B[0];
      	}
      	while((i+j)<=median/2){
      	    prev = last;
      	    if(i>=m)
      		last = B[j++];
      	    else if(j>=n)
      		last = A[i++];
      	    else if(A[i]<B[j])
      		last = A[i++];
      	    else
      		last = B[j++];
      	}
      	if((median&1) == 0)
      	    return (prev+last)/2;
      	else
      	    return last;
        }
}
//Easy cheat
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length,n=B.length;
    	if(m==0 && n==0) return 0;
    	int[] sum = new int[m+n];
    	for(int i=0;i<m;i++)
    	    sum[i] = A[i];
    	for(int i=0;i<n;i++)
    	    sum[i+m]=B[i];
    	Arrays.sort(sum);
    	if(((m+n)&1)==0)
    	    return (sum[(m+n)/2]+sum[(m+n)/2-1])/2.0;
    	else
    	    return sum[(m+n)/2];
    }
}
//Binary Search
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if((len&1)==1)
            return getKthElement(A,B,len/2 + 1);
        else
            return (getKthElement(A,B,len/2) + getKthElement(A,B,len/2 + 1))/2;
    }
    
    public double getKthElement(int[] A, int[] B,int k){
        if(A.length>B.length)
           return getKthElement(B,A,k);
        if(A.length==0)
           return B[k-1];
        if(k==1)
           return Math.min(A[0],B[0]);
        int pa = Math.min(A.length,k/2); int pb = k - pa;
        if(A[pa-1]<B[pb-1])
            return getKthElement(Arrays.copyOfRange(A,pa,A.length),B,k-pa);
        else if(A[pa-1]>B[pb-1])
            return getKthElement(A,Arrays.copyOfRange(B,pb,B.length),k-pb);
        else
            return A[pa-1];
    }
}

//binary search stupid useless i,j parameter
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if (total % 2 == 1)
            return findKth(A, 0, B, 0, total / 2 + 1);
        else
            return (findKth(A, 0, B, 0, total / 2) + findKth(A, 0, B, 0, total / 2 + 1)) / 2;
    }
    private static double findKth(int[] a, int i, int[] b, int j, int k) {
        if (a.length > b.length)
            return findKth(b, j, a, i, k);
 
        if (a.length == 0)
            return b[k - 1];
 
        if (k == 1)
            return Math.min(a[0], b[0]);
 
        int pa = Math.min(k / 2, a.length), pb = k - pa;
        if (a[pa - 1] < b[pb - 1])
            return findKth(Arrays.copyOfRange(a, pa, a.length), i + pa, b, j, k - pa);
        else if (a[pa - 1] > b[pb - 1])
            return findKth(a, i, Arrays.copyOfRange(b, pb, b.length), j + pb, k - pb);
        else
            return a[pa - 1];
    }
}
