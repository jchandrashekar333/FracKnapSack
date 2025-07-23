// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
   public static double fracKnapSack(int weight,Item arr[], int n){
       int currW = 0; double totVal = 0.0;
       Arrays.sort(arr,new ItemComparator());
       for(int i =0;i<n;i++){
           if(currW+arr[i].weigh<=weight){
               currW+=arr[i].weigh;
               totVal+= arr[i].val;
           }
           else{
               int rem = weight - currW;
               totVal += ((double)arr[i].val / arr[i].weigh) * rem;

               break;
           }
       }
       return totVal;
   }
    
    public static void main(String[] args) {
        int n = 3;
        int weight = 50;
         Item arr[] = new Item[] {
            new Item(100, 20),
            new Item(300, 10),
            new Item(120, 30)
        };
        double ans = fracKnapSack(weight,arr,n);
        System.out.println("Max value is"+ans);
        
    }
}
class ItemComparator implements Comparator<Item>{
    public int compare(Item a, Item b){
        double I1 = (double)(a.val)/(double)(a.weigh);
        double I2 = (double)(b.val)/(double)(b.weigh);
        
        if(I1<I2) return 1;
        else if(I1>I2) return -1;
        else return 0;
        
    }
}
 class Item{
        int val,weigh;
        Item(int x, int y ){
            this.val = x;
            this.weigh = y;
        }
    }
