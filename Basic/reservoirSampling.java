import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[] reservoirSampling(int[] data,int k){
    	if(data == null || data.length == 0 || k > data.length)
    		return null;
    	int[] sample = new int[k];
    	for(int i = 0 ; i < data.length; i++){
    		if(i < k){
    			sample[i] = data[i];
    		}else{
    			int j = new Random().nextInt(i);
    			if(j < k){
    				sample[j] = data[i];
    			}
    		}
    	}
    	return sample;
    }

    public static void main(String[] args) {
	    int k = 5;
	    int[] data = new int[100];
	    for(int i = 0 ; i < data.length; i++){
	    	data[i] = i;
	    }
	    int[] res = reservoirSampling(data, k);
	    System.out.println(Arrays.toString(res));
    }
}
