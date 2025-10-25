import java.util.Scanner;

public class Utils {
    public static int[] NhapMang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Nhập vào giá trị của mảng: ");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        return arr;
    }
    public static void TinhTong(int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        System.out.println("Tổng các phần tử trong mảng: " + sum);
    }
    public static void Max(int[] arr) {
        int max = arr[0];
        for(int x : arr) {
            if(x > max)
                max = x;
        }
        System.out.println("Phần tử lớn nhất: " + max);
    }
    public static void Min(int[] arr) {
        int min = arr[0];
        for(int x : arr) {
            if(x < min)
                min = x;
        }
        System.out.println("Phần tử nhỏ nhất: " + min);
    }
    public static void SapXepTang(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Mảng sau khi sắp xếp tăng dần: ");
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
    public static boolean SoNT(int x) {
        if(x < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void SoNTLonNhat(int[] arr) {
        int max = 0;
        for(int x : arr) {
            if(SoNT(x) && x > max)
                max = x;
        }
        if(max == 0)
            System.out.println("Không có");
        else
            System.out.println("Số nguyên tố lớn nhất trong mảng: " + max);
    }
}
