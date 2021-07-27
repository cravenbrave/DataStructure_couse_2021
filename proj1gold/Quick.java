import static org.junit.Assert.assertEquals;

public class Quick {
    public static void main(String[] args) {
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

        sad.printDeque();
//        for (int i = 0; i < 20; i++) {
//            System.out.print(sad.removeLast() + " ");
//        }
//        System.out.println();
//        System.out.println("---------------");
//        for (int i = 0; i < 20; i++) {
//            System.out.print(ads.get(i) + " ");
//        }
//        System.out.println();
        while (!isError && !sad.isEmpty() && !ads.isEmpty()) {
//            double numberBetweenZeroAndOne = StdRandom.uniform();
//
//            if (numberBetweenZeroAndOne < 0.5) {
                Integer sadF = sad.removeFirst();
                Integer adsF = ads.removeFirst();
                if (sadF != adsF) {
                    System.out.println("sadF: " + sadF);
                    System.out.println("adsF: " + adsF);
                    System.out.println("s.size: " + sad.size());
                    System.out.println("a.size: " + ads.size());
                    System.out.println(sad.isEmpty());
                    System.out.println(ads.isEmpty());
                }
//            } else {
//                Integer sadL = sad.removeLast();
//
//                Integer adsL = ads.removeLast();
//                if (sadL == null) {
//                    System.out.println("s.size: " + sad.size());
//                    System.out.println("a.size: " + ads.size());
//                }
////                if (sadL != adsL) {
////                    System.out.println("sadL: " + sadL);
////                    System.out.println("adsL: " + adsL);
////                    System.out.println("s.size: " + sad.size());
////                    System.out.println("a.size: " + ads.size());
////                    System.out.println(sad.isEmpty());
////                    System.out.println(ads.isEmpty());
////                }
//
//            }
        }
    }
}


