package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class AlgorithmTest {


    private int[] nums = {56,123,24,35,63,26,332,13,62};

    /**
     * 快速排序
     */
    public void quickSort(int[] array,int l,int r){
        if(l<r){
            int i=l; int j=r;
            int k = array[i];
            while(i<j){
                while(i<j){
                    if(array[j] < k){
                        array[i] = array[j];
                        i++;
                        break;
                    }
                    j--;
                }
                while(i<j){
                    if(array[i] > k){
                        array[j] = array[i];
                        j--;
                        break;
                    }
                    i++;
                }
            }
            array[i] = k;
            quickSort(array,l,i-1);
            quickSort(array,i+1,r);
            System.out.println("------" + Arrays.toString(array));
        }
    }


    @Test
    public void test(){

        int[] nums = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        System.out.println(arraySign(nums));
    }

    @Test
    public void test2(){

        System.out.println(findTheWinner(500,149));
    }

    public int arraySign(int[] nums) {
        int m = 0;
        for(int n : nums){
            if(n == 0){
                return 0;
            }else if(n < 0){
                m++;
            }
        }
        return m % 2 == 0 ? 1 : -1;
    }

    //1823. 找出游戏的获胜者
    public int findTheWinner(int n, int k) {
        if(n == 1){
            return n;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int num = n;
        int mount = k;
        do{
            int r = mount % num;
            if(r == 0){
                list.remove(num-1);
                r = 1;
            }else{
                list.remove(r-1);
            }
            num--;
            mount = r + k -1 ;
        }while(num > 1);
        return list.get(0);
    }
}
