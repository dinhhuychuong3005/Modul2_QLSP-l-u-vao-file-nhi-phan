import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
    public static void writeFile(String path, List<Product> productList) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public static void readFile(String path) throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Product> products = (ArrayList<Product>) objectInputStream.readObject();
            System.out.println(products);
            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }
}
