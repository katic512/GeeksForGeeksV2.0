//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int l=i+1,r=arr.length-1;
            while(l<r && arr[i]<=0){
                int tempSum = (arr[i]+arr[l]+arr[r]);
                if(tempSum==0){
                    return true;
                }else if(tempSum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return false;
    }
}
