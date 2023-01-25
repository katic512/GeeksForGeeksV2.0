//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        int left =0, right=0, tempSum=0;
        while(left<arr.length && right<arr.length && result.size()<2){
            tempSum += arr[right];
            while(tempSum>=s && left<=right){
                if(tempSum == s){
                    updateResult(left,right,result);
                    break;
                }else{
                    tempSum-=arr[left];
                }
                left++;
            }
            right++;
        }
        if(result.size()<2)result.add(-1);
        return result;
    }
    
    private static void updateResult(int left, int right, ArrayList<Integer> result){
        if(left==right){
            result.add(left+1);
            result.add(left+1);
        }else{
            result.add(left+1);
            result.add(right+1);
        }
    } 
}
