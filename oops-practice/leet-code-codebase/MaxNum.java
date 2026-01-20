package leetcode;

public class MaxNum {
	public static void main(String[] args) {
		
		int[] x = {7,1,5,3,6,4};
		
		
		System.out.print("\n"+numb(x));
	}
	
	static int numb(int[] prices) {
		int l = prices.length;

        int min = prices[0];
        int max = 0;

        for(int i=1; i<l; i++){
            if(min>prices[i]){
                min = prices[i];
            }else{
                if(max<prices[i]-min){
                    max = prices[i]-min;
                }
            }
        }
        return max;
	}
}
