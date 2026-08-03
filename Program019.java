import java.util.Arrays;

public class Program034 {

    // =========================================================
    // ข้อ 1: การกลับลำดับ String (Reverse a String)
    // =========================================================

    // วิธีที่ 1: Recursive Algorithm
    // แนวคิด: นำตัวอักษรตัวสุดท้ายของ String มาวางไว้ด้านหน้า แล้วเรียกเมธอดซ้ำกับ String ที่ตัดตัวสุดท้ายออก
    // ทำจนเหลือ String ที่มีความยาว 0 หรือ 1 ตัวอักษร

    static String reverseRecursive(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char lastChar = s.charAt(s.length() - 1);
        String rest = s.substring(0, s.length() - 1);

        return lastChar + reverseRecursive(rest);
    }

    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // ถ้าความยาวของ s น้อยกว่าหรือเท่ากับ 1
    // ส่งคืน s
    // นำตัวอักษรตัวสุดท้ายของ s มาไว้ด้านหน้า
    // ตัดตัวอักษรตัวสุดท้ายออกจาก s
    // เรียก reverseRecursive กับ String ที่เหลือ
    // ส่งคืนผลลัพธ์
    // สิ้นสุด

    // Time Complexity: O(n²)
    // เนื่องจากมีการสร้าง substring ใหม่ในแต่ละรอบ
    // ทำให้เกิดการประมวลผลรวมประมาณ n + (n-1) + ... + 1

    // Space Complexity: O(n)
    // เนื่องจากมีการเรียก Recursive ซ้อนกันหลายระดับ


    // วิธีที่ 2: Iterative Algorithm
    // แนวคิด: ใช้ Loop เริ่มจากตัวอักษรตำแหน่งสุดท้าย
    // แล้วเพิ่มตัวอักษรแต่ละตัวลงใน StringBuilder

    static String reverseIterative(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // สร้าง StringBuilder
    // วน Loop จากตำแหน่งสุดท้ายของ s ไปยังตำแหน่งแรก
    // เพิ่มตัวอักษรลงใน StringBuilder
    // ส่งคืน StringBuilder ในรูปแบบ String
    // สิ้นสุด

    // Time Complexity: O(n)
    // เนื่องจากอ่านตัวอักษรทั้งหมดจำนวน n ตัวเพียงครั้งเดียว

    // Space Complexity: O(n)
    // เนื่องจาก StringBuilder ต้องเก็บผลลัพธ์ที่กลับลำดับแล้ว


    // คำอธิบายเพิ่มเติม:
    // Recursive มีการเรียกเมธอดซ้ำและสร้าง substring หลายครั้ง
    // จึงใช้เวลามากกว่า Iterative เมื่อข้อมูลมีขนาดใหญ่
    
    // String เป็น Immutable Object
    // ดังนั้นการใช้เครื่องหมาย + ต่อ String หลายครั้ง
    // อาจทำให้เกิดการสร้าง String Object ใหม่หลายครั้ง
    
    // StringBuilder เป็น Mutable Object
    // สามารถเพิ่มข้อมูลลงใน Object เดิมได้
    // จึงเหมาะกับการต่อ String หลายครั้ง
    
    // สรุป: Iterative เหมาะกับข้อมูลขนาดใหญ่กว่า
    // เพราะมี Time Complexity เป็น O(n)
    // และไม่ต้องใช้ Recursive Stack


    // =========================================================
    // ข้อ 2: การตรวจสอบ Palindrome
    // =========================================================

    // วิธีที่ 1: Reverse and Compare
    // แนวคิด: กลับลำดับ String แล้วนำไปเปรียบเทียบกับ String เดิม
    // ถ้าเหมือนกัน แสดงว่าเป็น Palindrome

    static boolean isPalindromeByReverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        return s.equals(reversed);
    }

    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // สร้าง StringBuilder จาก s
    // กลับลำดับ String
    // เปรียบเทียบ String เดิมกับ String ที่กลับลำดับ
    // ถ้าเหมือนกัน ส่งคืน true
    // ถ้าไม่เหมือนกัน ส่งคืน false
    // สิ้นสุด

    // Time Complexity: O(n)
    // ต้องอ่านตัวอักษรทั้งหมดเพื่อสร้าง String ที่กลับลำดับ

    // Space Complexity: O(n)
    // ต้องสร้าง StringBuilder สำหรับเก็บ String ที่กลับลำดับ


    // วิธีที่ 2: Two-Pointer
    // แนวคิด: ใช้ตัวชี้ 2 ตัว คือ left และ right
    // left เริ่มจากตัวแรก และ right เริ่มจากตัวสุดท้าย
    // เปรียบเทียบตัวอักษรทั้งสองด้าน
    // ถ้าไม่เหมือนกัน แสดงว่าไม่ใช่ Palindrome

    static boolean isPalindromeTwoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // วิธีตรวจสอบเพิ่มเติม:
    // ทำความสะอาด String ก่อนตรวจสอบ
    // โดยลบช่องว่าง เครื่องหมายวรรคตอน
    // และเปลี่ยนตัวอักษรเป็นตัวพิมพ์เล็ก

    static boolean isPalindrome(String s) {

        String cleaned =
                s.replaceAll("[^a-zA-Z0-9]", "")
                 .toLowerCase();

        return isPalindromeTwoPointer(cleaned);
    }

    // ตัวอย่าง:
    // "racecar" -> true
    
    // "hello" -> false
    
    // "A man, a plan, a canal: Panama"
    // หลังจากทำความสะอาด String แล้ว
    // จะสามารถตรวจสอบได้ว่าเป็น Palindrome


    // คำอธิบายเพิ่มเติม:
    // Two-Pointer สามารถหยุดการทำงานได้ทันที
    // เมื่อพบตัวอักษรสองฝั่งไม่ตรงกัน
    
    // ดังนั้น Best-case Time Complexity คือ O(1)
    // ในกรณีที่ตัวอักษรคู่แรกไม่ตรงกัน
    
    // Worst-case Time Complexity คือ O(n)
    // เมื่อ String เป็น Palindrome และต้องตรวจสอบเกือบทุกตัว
    
    // Two-Pointer ใช้พื้นที่เพิ่มเติมเพียงตัวแปร left และ right
    // จึงมี Space Complexity เป็น O(1)
    
    // ส่วน Reverse and Compare ต้องสร้าง String ใหม่
    // จึงใช้พื้นที่ O(n)
    
    // สรุป: Two-Pointer มีประสิทธิภาพด้าน Space มากกว่าและสามารถหยุดก่อนตรวจสอบครบทุกตัวอักษรได้


    // =========================================================
    // ข้อ 3: การนับจำนวนสระ
    // =========================================================

    // วิธีที่ 1: Recursive Counting
    // แนวคิด: ตรวจสอบตัวอักษรตัวแรกของ String ว่าเป็นสระหรือไม่
    // จากนั้นเรียกเมธอดซ้ำกับ String ส่วนที่เหลือ

    static int countVowelsRecursive(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        char firstChar =
                Character.toLowerCase(s.charAt(0));

        int count =
                (firstChar == 'a' ||
                 firstChar == 'e' ||
                 firstChar == 'i' ||
                 firstChar == 'o' ||
                 firstChar == 'u')
                ? 1 : 0;

        return count +
               countVowelsRecursive(s.substring(1));
    }

    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // ถ้า s ว่าง ให้ส่งคืน 0
    // ตรวจสอบตัวอักษรตัวแรก
    // ถ้าเป็นสระ ให้ count = 1
    // ถ้าไม่ใช่สระ ให้ count = 0
    // เรียกเมธอดกับ String ที่เหลือ
    // นำค่าที่ได้มาบวกกับ count
    // ส่งคืนผลลัพธ์
    // สิ้นสุด

    // Time Complexity: O(n²)
    // เนื่องจากมีการสร้าง substring ใหม่ทุกครั้ง

    // Space Complexity: O(n)
    // เนื่องจากมี Recursive Call จำนวนหลายระดับ


    // วิธีที่ 2: Iterative Counting
    // แนวคิด: ใช้ Loop อ่านตัวอักษรทีละตัว
    // แล้วตรวจสอบว่าตัวอักษรนั้นเป็นสระหรือไม่

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

    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // กำหนด count = 0
    // วน Loop อ่านตัวอักษรทุกตัว
    // ถ้าตัวอักษรเป็น a, e, i, o หรือ u
    // เพิ่ม count 1
    // ส่งคืน count
    // สิ้นสุด

    // Time Complexity: O(n)
    // อ่านตัวอักษรแต่ละตัวเพียงครั้งเดียว

    // Space Complexity: O(1)
    // ใช้ตัวแปร count เป็นหลัก


    // คำอธิบายเพิ่มเติม:
    // Recursive มีจำนวน Recursive Call ตามจำนวนตัวอักษร
    // และแต่ละรอบมีการสร้าง substring
    
    // Iterative ใช้ Loop และตรวจสอบตัวอักษรทีละตัว
    // จึงเหมาะกับข้อมูลที่มีขนาดใหญ่กว่า
    
    // Recursive มีความเสี่ยงที่จะเกิด StackOverflowError
    // หาก String มีขนาดใหญ่จนมี Recursive Call มากเกินไป
    
    // ส่วน Iterative ไม่ต้องสร้าง Call Stack หลายระดับ
    
    // สรุป:Iterative มีประสิทธิภาพมากกว่าในกรณีข้อมูลขนาดใหญ่


    // =========================================================
    // ข้อ 4: การจัดกลุ่มจำนวนคู่และจำนวนคี่
    // =========================================================

    // วิธีที่ 1: Recursive
    // แนวคิด: อ่านตัวอักษรจาก String ทีละตัว
    // ถ้าเป็นตัวเลขให้ตรวจสอบว่าเป็นเลขคู่หรือเลขคี่
    // แล้วนำไปเก็บใน StringBuilder ที่เหมาะสม

    static void groupEvenOddRecursive(
            String s,
            int left,
            int right,
            StringBuilder even,
            StringBuilder odd) {

        if (left > right) {
            return;
        }

        char c = s.charAt(left);

        if (Character.isDigit(c)) {

            int digit = Character.getNumericValue(c);

            if (digit % 2 == 0) {
                even.append(c);
            } else {
                odd.append(c);
            }
        }

        groupEvenOddRecursive(
                s,
                left + 1,
                right,
                even,
                odd);
    }

    // Pseudocode
    // เริ่ม
    // รับ String s, left, right, even และ odd
    // ถ้า left > right ให้จบการทำงาน
    // อ่านตัวอักษรตำแหน่ง left
    // ถ้าเป็นตัวเลข
    // ตรวจสอบว่าเป็นเลขคู่หรือเลขคี่
    // ถ้าเป็นคู่ เพิ่มใน even
    // ถ้าเป็นคี่ เพิ่มใน odd
    // เรียกเมธอดกับตำแหน่งถัดไป
    // สิ้นสุด

    // Time Complexity: O(n)
    // อ่านตัวอักษรแต่ละตัวหนึ่งครั้ง

    // Space Complexity: O(n)
    // มี Recursive Stack และพื้นที่สำหรับเก็บผลลัพธ์


    // วิธีที่ 2: Iterative
    // แนวคิด: ใช้ Loop ตรวจสอบตัวเลขทุกตัว
    // แล้วแยกตัวเลขคู่และเลขคี่ออกจากกัน

    static void groupEvenOddIterative(
            String s,
            StringBuilder even,
            StringBuilder odd) {

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                int digit = Character.getNumericValue(c);

                if (digit % 2 == 0) {
                    even.append(c);
                } else {
                    odd.append(c);
                }
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ String s
    // วน Loop อ่านตัวอักษร
    // ถ้าเป็นตัวเลข
    // ตรวจสอบเลขคู่/เลขคี่
    // เพิ่มลงในกลุ่มที่เหมาะสม
    // สิ้นสุด

    // Time Complexity: O(n)
    // อ่านตัวอักษรทุกตัวหนึ่งครั้ง

    // Space Complexity: O(n)
    // ต้องเก็บผลลัพธ์เลขคู่และเลขคี่


    // วิธีที่ 3: Extra Array
    // แนวคิด: สร้าง Array แยกสำหรับเลขคู่และเลขคี่
    // จากนั้นนำผลลัพธ์กลับมาใส่ใน StringBuilder

    static void groupEvenOddExtraArray(
            String s,
            StringBuilder even,
            StringBuilder odd) {

        char[] evenArray = new char[s.length()];
        char[] oddArray = new char[s.length()];

        int evenIndex = 0;
        int oddIndex = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                int digit = Character.getNumericValue(c);

                if (digit % 2 == 0) {
                    evenArray[evenIndex++] = c;
                } else {
                    oddArray[oddIndex++] = c;
                }
            }
        }

        even.append(evenArray, 0, evenIndex);
        odd.append(oddArray, 0, oddIndex);
    }

    // Pseudocode
    // เริ่ม
    // รับ String s
    // สร้าง Array สำหรับเลขคู่และเลขคี่
    // กำหนดตำแหน่งเริ่มต้นของ Array เป็น 0
    // อ่านตัวอักษรทุกตัว
    // ถ้าเป็นเลขคู่ เก็บใน evenArray
    // ถ้าเป็นเลขคี่ เก็บใน oddArray
    // นำข้อมูลใน Array มาเก็บใน StringBuilder
    // สิ้นสุด

    // Time Complexity: O(n)
    // ต้องอ่านข้อมูลทุกตัวใน String

    // Space Complexity: O(n)
    // ต้องสร้าง Array เพิ่มอีก 2 ชุด


    // คำอธิบายเพิ่มเติม:
    // ทั้ง 3 วิธีสามารถแบ่งเลขคู่และเลขคี่ออกจากกันได้
    
    // Recursive ต้องใช้ Recursive Stack
    // จึงมีพื้นที่เพิ่มเติมจากการเรียกเมธอด
    
    // Iterative ใช้ Loop และไม่ต้องสร้าง Recursive Stack
    // จึงเหมาะกับข้อมูลขนาดใหญ่กว่า
    
    // Extra Array ต้องสร้าง Array เพิ่มขึ้นมา
    // ทำให้ใช้พื้นที่มากกว่า Iterative
    
    // ทั้ง Recursive และ Iterative สามารถรักษาลำดับของข้อมูล
    // ที่พบจาก String เดิมได้
    
    // ส่วน Extra Array ใช้พื้นที่เพิ่มเพื่อเก็บผลลัพธ์
    
    // สรุป: Iterative เป็นวิธีที่เหมาะสมกว่า เมื่อพิจารณาความเรียบง่ายและการใช้พื้นที่


    // =========================================================
    // ข้อ 5: การแบ่ง Array ตามค่า k
    // =========================================================

    // วิธีที่ 1: Recursive Partition
    // แนวคิด: ใช้ left และ right เป็นตัวชี้
    // ค่าที่น้อยกว่าหรือเท่ากับ k จะอยู่ทางด้านหนึ่ง
    // ส่วนค่าที่มากกว่า k จะอยู่ทางอีกด้านหนึ่ง

    static void partitionArrayRecursive(
            int[] arr,
            int left,
            int right,
            int k) {

        if (left >= right) {
            return;
        }

        if (arr[left] <= k) {

            partitionArrayRecursive(
                    arr,
                    left + 1,
                    right,
                    k);

        } else if (arr[right] > k) {

            partitionArrayRecursive(
                    arr,
                    left,
                    right - 1,
                    k);

        } else {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            partitionArrayRecursive(
                    arr,
                    left + 1,
                    right - 1,
                    k);
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ Array arr, left, right และ k
    // ถ้า left >= right ให้จบ
    // ถ้า arr[left] <= k
    // เลื่อน left ไปทางขวา
    // ถ้า arr[right] > k
    // เลื่อน right ไปทางซ้าย
    // มิฉะนั้น
    // สลับค่า arr[left] กับ arr[right]
    // เลื่อนตัวชี้ทั้งสอง
    // สิ้นสุด

    // Time Complexity: O(n)
    // ตรวจสอบข้อมูลใน Array

    // Space Complexity: O(n)
    // เนื่องจาก Recursive Call


    // วิธีที่ 2: Iterative Partition
    // แนวคิด: ใช้ตัวชี้ left และ right
    // เพื่อหาตำแหน่งที่ต้องสลับค่า

    static void partitionArrayIterative(
            int[] arr,
            int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && arr[left] <= k) {
                left++;
            }

            while (left < right && arr[right] > k) {
                right--;
            }

            if (left < right) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ Array arr และค่า k
    // กำหนด left = 0
    // กำหนด right = ตำแหน่งสุดท้าย
    // ขณะที่ left < right
    // เลื่อน left หากค่ามีค่าน้อยกว่าหรือเท่ากับ k
    // เลื่อน right หากค่ามากกว่า k
    // ถ้ายังมีตำแหน่งที่ต้องจัดกลุ่ม
    // สลับค่า
    // สิ้นสุด

    // Time Complexity: O(n)
    // แต่ละข้อมูลถูกตรวจสอบในกระบวนการแบ่งกลุ่ม

    // Space Complexity: O(1)
    // ใช้ตัวแปรเพิ่มเติมเพียงไม่กี่ตัว


    // วิธีที่ 3: Sorting-Based
    // แนวคิด: เรียง Array ก่อน
    // จากนั้นแบ่งค่าที่ <= k และค่าที่ > k

    static void partitionArraySorting(
            int[] arr,
            int k) {

        Arrays.sort(arr);

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= k) {
                arr[index++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > k) {
                arr[index++] = arr[i];
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ Array arr และค่า k
    // เรียงลำดับ Array
    // สร้าง index = 0
    // เก็บค่าที่ <= k ไว้ก่อน
    // จากนั้นเก็บค่าที่ > k
    // สิ้นสุด

    // Time Complexity: O(n log n)
    // เนื่องจากต้องเรียง Array ก่อน

    // Space Complexity: O(1)
    // ใช้ตัวแปรเพิ่มเติมเพียงเล็กน้อย


    // คำอธิบายเพิ่มเติม:
    // Recursive และ Iterative สามารถแบ่งข้อมูลโดยไม่ต้องเรียง
    // Array ทั้งหมดก่อน
    
    // Iterative ไม่ต้องใช้ Recursive Stack
    // จึงใช้พื้นที่เพิ่มเติมน้อย
    
    // Sorting-Based ต้องเสียเวลาในการ Sort
    // ทำให้มี Time Complexity เป็น O(n log n)
    
    // ดังนั้นหากต้องการเพียงแบ่งข้อมูลตามค่า k
    // Iterative Partition จะเหมาะกว่า
    // เพราะมี Time Complexity O(n)
    // และ Space Complexity O(1)


    // =========================================================
    // ข้อ 6: การค้นหาคู่จำนวนที่มีผลรวมเท่ากับ k
    // =========================================================

    // วิธีที่ 1: Brute Force
    // แนวคิด: เปรียบเทียบตัวเลขทุกคู่ใน Array
    // ถ้าผลรวมของตัวเลขสองตัวเท่ากับ k ให้แสดงคู่ดังกล่าว

    static void findPairsBruteForce(
            int[] arr,
            int k) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1;
                 j < arr.length;
                 j++) {

                if (arr[i] + arr[j] == k) {

                    System.out.println(
                            "Pair found: (" +
                            arr[i] + ", " +
                            arr[j] + ")"
                    );
                }
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ Array arr และค่า k
    // ใช้ Loop ชั้นนอกเลือกตัวเลขตัวแรก
    // ใช้ Loop ชั้นในเลือกตัวเลขตัวที่สอง
    // ตรวจสอบผลรวม
    // ถ้าผลรวมเท่ากับ k ให้แสดงคู่ตัวเลข
    // สิ้นสุด

    // Time Complexity: O(n²)
    // เพราะต้องตรวจสอบคู่ของข้อมูลจำนวนมาก

    // Space Complexity: O(1)
    // ใช้ตัวแปรเพิ่มเติมเพียงเล็กน้อย


    // วิธีที่ 2: Recursive Two-Pointer
    // แนวคิด: ใช้ตัวชี้ left และ right โดยวิธีนี้ต้องใช้งานกับ Array ที่เรียงลำดับแล้ว
    // ถ้าผลรวมเท่ากับ k ให้บันทึกคู่
    // ถ้าผลรวมน้อยกว่า k ให้เลื่อน left
    // ถ้าผลรวมมากกว่า k ให้เลื่อน right

    static void findPairsRecursive(
            int[] arr,
            int left,
            int right,
            int k) {

        if (left >= right) {
            return;
        }

        int sum = arr[left] + arr[right];

        if (sum == k) {

            System.out.println(
                    "Pair found: (" +
                    arr[left] + ", " +
                    arr[right] + ")"
            );

            findPairsRecursive(
                    arr,
                    left + 1,
                    right - 1,
                    k);

        } else if (sum < k) {

            findPairsRecursive(
                    arr,
                    left + 1,
                    right,
                    k);

        } else {

            findPairsRecursive(
                    arr,
                    left,
                    right - 1,
                    k);
        }
    }

    // Pseudocode
    // เริ่ม
    // รับ Array arr, left, right และ k
    // ถ้า left >= right ให้จบ
    // คำนวณ sum = arr[left] + arr[right]
    // ถ้า sum == k
    // แสดงคู่ตัวเลข
    // เลื่อน left และ right เข้าหากัน
    // ถ้า sum < k
    // เลื่อน left ไปทางขวา
    // ถ้า sum > k
    // เลื่อน right ไปทางซ้าย
    // สิ้นสุด

    // Time Complexity: O(n)
    // เนื่องจากตัวชี้แต่ละตัวเคลื่อนผ่าน Array

    // Space Complexity: O(n)
    // เนื่องจากมี Recursive Call หลายระดับ


    // วิธีที่ 3: Binary Search
    // แนวคิด:
    // เลือกตัวเลข arr[i]
    // แล้วคำนวณค่าที่ต้องการอีกตัว
    // complement = k - arr[i]
    // จากนั้นใช้ Binary Search เพื่อค้นหา complement ในส่วนที่เหลือของ Array

    static void findPairsBinarySearch(
            int[] arr,
            int k) {

        for (int i = 0; i < arr.length; i++) {

            int complement = k - arr[i];

            if (binarySearch(
                    arr,
                    complement,
                    i + 1,
                    arr.length - 1)) {

                System.out.println(
                        "Pair found: (" +
                        arr[i] + ", " +
                        complement + ")"
                );
            }
        }
    }

    static boolean binarySearch(
            int[] arr,
            int target,
            int left,
            int right) {

        while (left <= right) {

            int mid =
                    left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;

            } else if (arr[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }

        return false;
    }

       // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int k
    // ใช้ลูปอ่านค่าทุกตัวใน arr
    // คำนวณ complement = k - arr[i]
    // ถ้า binarySearch(arr, complement, i + 1, arr.length - 1) คืนค่า true
    // แสดงคู่จำนวนนั้น
    // สิ้นสุด

    // Time Complexity: O(n log n)
    // เนื่องจากต้องใช้การค้นหาแบบ Binary Search สำหรับแต่ละตัวในอาร์เรย์

    // Space Complexity: O(1)
    // เนื่องจากใช้ตัวแปรเพิ่มเติมเพียงเล็กน้อย

    // เหตุใด Two-Pointer จึงใช้ได้เมื่ออาร์เรย์เรียงลำดับแล้วและจะเกิดอะไรขึ้นหากนำวิธีนี้ไปใช้กับอาร์เรย์ที่ยังไม่เรียงลำดับ
    
    // Two-Pointer ใช้ได้เมื่ออาร์เรย์เรียงลำดับแล้วเพราะสามารถใช้ตัวชี้สองตัวเพื่อหาคู่จำนวนที่มีผลรวมเท่ากับ k ได้อย่างมีประสิทธิภาพ
    
    // หากนำวิธีนี้ไปใช้กับอาร์เรย์ที่ยังไม่เรียงลำดับจะไม่สามารถหาคู่จำนวนที่มีผลรวมเท่ากับ k ได้อย่างถูกต้องเนื่องจากค่าที่อยู่ในอาร์เรย์ไม่ได้เรียงลำดับตามขนาด
    // ทำให้การเปรียบเทียบผลรวมของตัวชี้ left และ right อาจไม่สะท้อนถึงความสัมพันธ์ที่แท้จริงของค่าตัวเลขในอาร์เรย์

    // สรุป:ทั้งสามวิธีสามารถใช้ในการค้นหาคู่จำนวนที่มีผลรวมเท่ากับ k ได้แต่การใช้วิธี Recursive Two-Pointer จะมีประสิทธิภาพดีกว่าในแง่ของเวลาและพื้นที่
}
