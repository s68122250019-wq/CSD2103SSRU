public class TestProgram1_034 {

    // Algorithm 1: Iterative
    static String reverseIterative(String s) {

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }


    // Algorithm 2: Recursive
    static String reverseRecursive(String s) {

        if (s.length() <= 1) {
            return s;
        }

        char lastChar = s.charAt(s.length() - 1);
        String rest = s.substring(0, s.length() - 1);

        return lastChar + reverseRecursive(rest);
    }


    public static void main(String[] args) {

        // ขนาดข้อมูล
        int[] sizes = {100, 1000, 10000, 100000};

        // จำนวนครั้งที่ทดลอง
        int trials = 5;


        for (int n : sizes) {

            String input = "A".repeat(n);

            long totalIterative = 0;
            long totalRecursive = 0;

            int recursiveRuns = 0;


            System.out.println("\n=================================");
            System.out.println("Data size (n) = " + n);
            System.out.println("=================================");


            // ทดลองทั้งหมด 5 ครั้ง
            for (int i = 1; i <= trials; i++) {


                // =========================
                // Iterative
                // =========================

                long start = System.nanoTime();

                reverseIterative(input);

                long end = System.nanoTime();

                long iterativeTime = end - start;

                totalIterative += iterativeTime;


                System.out.println(
                    "Iterative Run " + i + ": "
                    + iterativeTime + " ns"
                );


                // =========================
                // Recursive
                // =========================

                try {

                    start = System.nanoTime();

                    reverseRecursive(input);

                    end = System.nanoTime();

                    long recursiveTime = end - start;

                    totalRecursive += recursiveTime;
                    recursiveRuns++;


                    System.out.println(
                        "Recursive Run " + i + ": "
                        + recursiveTime + " ns"
                    );


                } catch (StackOverflowError e) {

                    System.out.println(
                        "Recursive Run " + i
                        + ": StackOverflowError"
                    );
                }
            }


            // =========================
            // คำนวณ Average
            // =========================

            double averageIterative =
                (double) totalIterative / trials;


            System.out.println("\n----- Average -----");


            System.out.println(
                "Iterative Average: "
                + averageIterative + " ns"
            );


            if (recursiveRuns > 0) {

                double averageRecursive =
                    (double) totalRecursive / recursiveRuns;


                System.out.println(
                    "Recursive Average: "
                    + averageRecursive + " ns"
                );


            } else {

                System.out.println(
                    "Recursive Average: "
                    + "ไม่สามารถคำนวณได้"
                );
            }
        }
    }
}
