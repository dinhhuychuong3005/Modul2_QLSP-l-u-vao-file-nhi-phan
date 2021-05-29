import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();
        managerProduct.createList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========Menu=========");
        System.out.println("1.Hiển thị sản phẩm");
        System.out.println("2.Thêm sản phẩm");
        System.out.println("3.Tìm kiếm sản phẩm theo ID");
        System.out.println("4.Xóa sản phẩm theo id:");
        System.out.println("5.Lưu danh sách sản phẩm vào file:");
        System.out.println("6.Hiển thị danh sách sản phẩm từ file");
        System.out.println("7.Exit");
        System.out.println("Nhập lựa chọn của bạn:");
        int choice = scanner.nextInt();
        try {
            while (choice >= 0 && choice <= 7) {
                switch (choice) {
                    case 1: {
                        managerProduct.display();
                        break;
                    }
                    case 2: {
                        managerProduct.add();
                        System.out.println("sau khi thêm sản phẩm:");
                        managerProduct.display();
                        break;
                    }
                    case 3: {
                        scanner.nextLine();
                        managerProduct.findById();
                        break;
                    }
                    case 4: {
                        scanner.nextLine();
                        managerProduct.removeId();
                        System.out.println("sau khi xóa sản phẩm");
                        managerProduct.display();
                        break;
                    }
                    case 5: {
                        ProductFile.writeFile("product.txt", managerProduct.productList);
                        break;
                    }
                    case 6: {
                        ProductFile.readFile("product.txt");
                        break;
                    }
                    case 7: {
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Not available!");
                }
                System.out.println();
                System.out.println("Bạn muốn chọn gì tiếp theo");
                choice = scanner.nextInt();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
