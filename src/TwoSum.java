import java.util.HashMap;

/**
 * Created by xz346 on 6/1/15.
 *
 * Q: Given an array of integers, find two numbers such that they add up to a specific target number X.
 *
 * A: Have to loop through the array and find another number: say (X-i1), So this is really a lookup problem
 *    Boils down to how to look up for an element in a collection quickly.
 */
public class TwoSum {

    public int[] findTwoNumber(int[] ArrayOfInteger, int TargetSum) {
        HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<ArrayOfInteger.length; i++){
            int firstNum = ArrayOfInteger[i];
            int targetLookfor = TargetSum-firstNum;

            if(myHashMap.containsKey(targetLookfor)) {
                return new int[] { myHashMap.get(targetLookfor) + 1, i + 1 };
            }

            myHashMap.put(firstNum, i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
