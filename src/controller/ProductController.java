package controller;

import java.io.IOException;
import java.util.Map;

import model.Product;
import view.ProductView;

/**
 * Productcontroller
 */
public class ProductController {

    ProductView view = new ProductView();

    public void menu(){
        while(true){
            String opcao = view.opcaoMenu();

            switch(opcao){
                case "1" -> createProduct();
                case "2" -> editProduct();
                case "3" -> removeProduct();
                case "4" -> listProducts();
                case "5" -> {
                    break;
                }
                default -> System.out.println("Comando Inválido. ");
            }
        }
    }

    private void createProduct() {
        while(true){
            Map<String, Object> product = view.getProductInformation();
            Product.productsStock.add(product);
        }
        Product.saveStock();
    }

    private void listProducts() {
        view.listProducts();
    }

    private Object removeProduct() {
        return null;
    }

    private Object editProduct() {
        return null;
    }
}