import constant.Common;
import constant.ErrorMessage;
import constant.SuccessfulMessage;
import model.Product;
import service.ProductController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController productController = new ProductController();
        int choose;
        System.out.println(Common.MENU);
        while(true) {
            System.out.print(Common.ENTER_CHOOSE);
            choose = sc.nextInt();
            sc.nextLine();
            switch(choose) {
                case 1:
                    System.out.print(Common.ENTER_TYPE);
                    String type = sc.nextLine();
                    System.out.print(Common.ENTER_NAME);
                    String name = sc.nextLine();
                    System.out.print(Common.ENTER_DESCRIPTION);
                    String description = sc.nextLine();
                    System.out.print(Common.ENTER_PRICE);
                    double price = sc.nextDouble();
                    productController.addProduct(type, name, description, price);
                    break;
                case 2:
                    System.out.print(Common.ENTER_ID_FOUND);
                    int idFound = sc.nextInt();
                    if(productController.getById(idFound) != null) {
                        System.out.println(SuccessfulMessage.SUCCESS_FOUND);
                        Product foundProduct = productController.getById(idFound);
                        System.out.println(foundProduct.getInfo());
                    }
                    else
                        System.out.println(ErrorMessage.ERROR_NOT_FOUND);
                    break;
                case 3:
                    System.out.print(Common.ENTER_ID_REMOVE);
                    int idRemove = sc.nextInt();
                    productController.removeById(idRemove);
                    break;
                case 4:
                    ArrayList<Product> tempArr = productController.getAllProducts();
                    if(tempArr.isEmpty())
                        System.out.println(ErrorMessage.ERROR_IS_EMPTY);
                    else {
                        for(Product x : tempArr)
                            System.out.println(x.getInfo());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println(ErrorMessage.ERROR_INVALID_CHOOSE);
            }
        }
    }
}
