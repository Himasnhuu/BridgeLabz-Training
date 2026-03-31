//3075. Maximize Happiness of Selected Children

package leetcode;
public class MaximizeHappiness {
	public static void main(String[] args) {
		int [] arr = {2,3,4,5};
		int k=1;
		
		System.out.println(maximumHappinessSum(arr,k));
	}
	
	public static long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        while(k>0){
            
            int maxvalue = happiness[0];
            int maxindex = 0;
            for(int i=1;i<happiness.length; i++){
                if(maxvalue<happiness[i]){
                    maxvalue = happiness[i];
                    maxindex = i;
                }
            }
            sum+=maxvalue;
            happiness[maxindex]=0;
            --k;
            for(int i=0; i<happiness.length; i++){
                if(happiness[i]>0){
                    happiness[i]--;
                }
            }
        }
        return sum;

    }
}
