package collection.framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Arrays
int[] x = {1,2,1,3,2};
        int[] y = {5,3,4,6,2};

        System.out.println(maxSumDistinctTriplet(x,y));
    }

    public static int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer,Integer> mpp = new HashMap<>();

        for(int i=0;i<x.length;i++){
            if(mpp.containsKey(x[i])){
                if(mpp.get(x[i]) < y[i]){
                    mpp.put(x[i],y[i]);
                }
            }else{
                mpp.put(x[i],y[i]);
            }
        }

        Set<Integer> stt = mpp.values().stream().distinct().collect(Collectors.toSet());
        if(stt.size() < 3){
            return -1;
        }

        int collect = stt.stream().sorted(Collections.reverseOrder()).limit(3).mapToInt(i->i).sum();
        
        
        System.out.println(collect);

        return 0;
    }
}
