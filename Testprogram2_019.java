public class TestProgram3_034 {

    // Algorithm 1: Recursive
    static int countVowelsRecursive(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        char firstChar = Character.toLowerCase(s.charAt(0));

        int count = (firstChar == 'a' ||
                     firstChar == 'e' ||
                     firstChar == 'i' ||
                     firstChar == 'o' ||
                     firstChar == 'u') ? 1 : 0;

        return count + countVowelsRecursive(s.substring(1));
    }


    // Algorithm 2: Iterative
    static int countVowelsIterative(String s) {

        int count = 0;

        for (char c : s.toLowerCase().toCharArray()) {

            if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') {

                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        // ขนาดข้อมูล
        int[] sizes = {100, 1000, 10000, 100000};

        // จำนวนครั้งที่ทดลอง
        int trials = 5;


        for (int n : sizes) {

            // สร้าง String ขนาด n
            String input = "a".repeat(n);

            long totalRecursive = 0;
            long totalIterative = 0;

            int recursiveRuns = 0;


            System.out.println("\n========================================");
            System.out.println("Data size (n) = " + n);
            System.out.println("========================================");


            // ทดลอง 5 ครั้ง
            for (int i = 1; i <= trials; i++) {


                // -------------------------------
                // Recursive
                // -------------------------------

                try {

                    long start = System.nanoTime();

                    int recursiveResult =
                            countVowelsRecursive(input);

                    long end = System.nanoTime();

                    long recursiveTime = end - start;

                    totalRecursive += recursiveTime;
                    recursiveRuns++;


                    System.out.println(
                            "Recursive Run " + i +
                            ": " + recursiveTime + " ns" +
                            " | Result = " + recursiveResult
                    );


                } catch (StackOverflowError e) {

                    System.out.println(
                            "Recursive Run " + i +
                            ": StackOverflowError"
                    );
                }


                // -------------------------------
                // Iterative
                // -------------------------------

                long start = System.nanoTime();

                int iterativeResult =
                        countVowelsIterative(input);

                long end = System.nanoTime();

                long iterativeTime = end - start;

                totalIterative += iterativeTime;


                System.out.println(
                        "Iterative Run " + i +
                        ": " + iterativeTime + " ns" +
                        " | Result = " + iterativeResult
                );
            }


            // -------------------------------
            // คำนวณค่าเฉลี่ย
            // -------------------------------

            System.out.println("\n---------- Average ----------");


            double averageIterative =
                    (double) totalIterative / trials;


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
                        "Recursive Average: ไม่สามารถคำนวณได้"
                );
            }
        }
    }
}
