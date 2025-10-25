import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Utils.NhapMang();
        int choose;
        System.out.println("--- Menu ---");
        System.out.println("1. Tính tổng các phần tử trong mảng");
        System.out.println("2. In ra phần tử lớn nhất, nhỏ nhất");
        System.out.println("3. Sắp xếp lại mảng theo chiều tăng dần");
        System.out.println("4. In ra số nguyên tố lớn nhất trong mảng");
        while(true) {
            do
            {
                System.out.print("Nhập lựa chọn: ");
                choose = sc.nextInt();
            }
            while(choose < 0 || choose > 4);
            switch(choose) {
                case 1: {
                    Utils.TinhTong(arr);
                    break;
                }
                case 2: {
                    Utils.Max(arr);
                    Utils.Min(arr);
                    break;
                }
                case 3: {
                    Utils.SapXepTang(arr);
                    break;
                }
                case 4: {
                    Utils.SoNTLonNhat(arr);
                    break;
                }
            }
        }
    }
}