import java.util.*;

/**
 * Created by xz346 on 5/29/15.
 * Requirement : Given an iterator of an array, implement a positive iterator,
 * PositiveIterator.hasNext() will return boolean value of next integer
 * PositiveIterator.next will return the next positive number
 * http://3.www.mitbbs.ca/article_t1/JobHunting/32895555_32895771_1.html
 */
public class PositiveIterator {

    Iterator<Integer> myIter;
    int nextTemp=0;

    PositiveIterator(Iterator<Integer> iter) {
        this.myIter = iter;
    }

    //implement next() after hasNext()
    public int next() {
        if(nextTemp ==0) {
            if(hasNext()==true) {
                return nextTemp;
            } else {
                throw new NoSuchElementException() ;
            }
        } else {
            return nextTemp;
        }
    }

    //implment hasNext() first, since hasNext() do not move pointer
    public boolean hasNext() {
        while (myIter.hasNext()) {
            int nextNum = myIter.next();
            if (nextNum > 0) {
                nextTemp = nextNum;
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        myArray.addAll(Arrays.asList(1,2,-8,-9,0));

        Iterator origIter = myArray.iterator();

        //This is very interesting, Only next() will actually move the pointer, not hasNext()
        /*for (int i=0;i<3;i++) {
            System.out.println(origIter.hasNext());
            //System.out.println(origIter.next());
        }
        System.out.print(origIter.next());*/

        PositiveIterator ipo = new PositiveIterator(origIter);
        while (ipo.hasNext()) {
            System.out.println(ipo.next());
        }

    }
}
