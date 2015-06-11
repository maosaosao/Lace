import java.util.ArrayList;
import java.util.List;

/**
 * Created by xz346 on 6/11/15.
 *
 * Requirement:
 *  Given a digit string, return all possible letter combinations that the number could represent.
 *  Input:Digit string "23"
 *  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Solution:
 *  https://leetcode.com/discuss/29834/letter-combinations-of-a-phone-number?show=29834#q29834
 *
 * Read more on where DFS is usually being used for algorithms :
 *  http://en.wikipedia.org/wiki/Depth-first_search#Applications
 *
 * Note :
 *  Always list/write down what're given
 */
public class LetterCombinOfPhoneNumber {

    final String[] phoneStringArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> getPossibleCombinations(String givenNumbers) {

        ArrayList<String> myStringList = new ArrayList<String>();

        //no digits, then retull empty result
        if (givenNumbers.length() == 0) {
            return myStringList;
        }

        dfs(myStringList, new StringBuilder(), 0, givenNumbers);

        return myStringList;
    }


    public void dfs(ArrayList mStringList, StringBuilder sBuilder, int indexOfNumbers, String givenNumbers) {
        //Condition of looping out, add a combination into result list
        if (indexOfNumbers == givenNumbers.length()) {
            mStringList.add(sBuilder.toString());
        }

        //get the current numberString from the phone string array
        String strRepresentNumber = phoneStringArray[givenNumbers.charAt(indexOfNumbers) - '0'];

        for(int i = 0; i < strRepresentNumber.length(); i++){
            sBuilder.append(strRepresentNumber.charAt(i));
            dfs(mStringList, sBuilder, indexOfNumbers + 1, givenNumbers);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }



    }
}
