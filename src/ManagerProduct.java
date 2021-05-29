import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    List<Product> productList = new ArrayList<>();

    public void createList() {//sản phẩm có sẵn
        Product product = new Product("2", "Iphone 12", "Apple", 20000, "cell phone");
        Product product1 = new Product("3", "Galaxy S10", "SamSung", 19000, "cell phone");
        Product product2 = new Product("4", "Redmi 9", "Xiaomi", 2400, "cell phone");
        Product product3 = new Product("5", "P30", "huawei", 5000, "cell phone");
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    public void add() { //thêm sản phẩm
        Product product = inputData();
        productList.add(product);
    }

    public Product inputData() {  //người dùng nhập dữ liệu
        Scanner scanner = new Scanner(System.in);
        String id;
        do {
            System.out.println("Enter id:");
            id = scanner.nextLine();
        } while (checkById(id) != -1);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter brand name: ");
        String brandName = scanner.nextLine();
        System.out.println("Enter price");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        return new Product(id, name, brandName, price, description);
    }

    public void display() {// hiển thị
        try {
            for (Product element : productList) {
                System.out.println("ID: " + element.getId()
                        + " ,Name: " + element.getName()
                        + " ,brand_name: " + element.getBrandName()
                        + " ,price: " + element.getPrice()
                        + " ,description: " + element.getDescription() + "\n");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + "/File is empty!");
        }
    }

    public int checkById(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void findById() {
        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        System.out.println("Nhập id sản phẩm cần tìm");
        String id = scanner.nextLine();
        if (checkById(id) == -1){
            System.out.println("Không tìm thấy mã sản phẩm này");
        }else {
            System.out.println(productList.get(checkById(id)).toString());
        }
    }
    public void removeId(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập id sản phẩm cần xóa");
        String id = scanner.nextLine();
        if (checkById(id) == -1){
            System.out.println("Không tìm thấy mã sản phẩm này");
        }else {
            productList.remove(productList.get(checkById(id)));
        }
    }
}
