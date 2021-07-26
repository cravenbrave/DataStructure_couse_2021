import static org.junit.Assert.*;
import org.junit.Test;
//@Source class StudentArrayDequeLauncher

public class TestArrayDequeGold {

    @Test
    public void testArray1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        boolean isError = false;
        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
            }
        }

        while (!isError && !sad.isEmpty() && !ads.isEmpty()) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer sadF = sad.removeFirst();
                Integer adsF = ads.removeFirst();
                assertEquals("addFirst(" + sad.get(0) + ")\naddFirst("
                        + sadF +")\nremoveFirst()", adsF, sadF);
            } else {
                Integer sadL = sad.removeLast();
                Integer adsL = ads.removeLast();
                assertEquals("addLast(" + sad.get(sad.size() - 1) +
                        ")\naddLast(" + sadL + ")\nremoveLast()", adsL, sadL);
            }
        }
    }

//            System.out.println("student");
//        sad1.printDeque();
//        System.out.println("-----------------");
//        System.out.println("solution");
//        System.out.println(ads1.get(4));
}
