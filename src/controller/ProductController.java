package controller;

import java.util.*;

import model.Product;
import view.ProductView;

/**
 * Productcontroller
 */
public class ProductController {

    ProductView view = new ProductView();

    public void menu(){
        Boolean saida = true;
        while(saida){
            String opcao = view.opcaoMenu();

            switch(opcao){
                case "1" -> createProduct();
                case "2" -> editProduct();
                case "3" -> removeProduct();
                case "4" -> listProducts();
                case "5" -> searchProduct();
                case "6" -> sellProducts();
                case "0" -> {
                    saida = false;
                }
                default -> System.out.println("Opção Inválida. ");
            }
        }
    }

    private void sellProducts() {
        boolean continueLoop = true;
        List<Map<String, Object>> products = new ArrayList<>();
        while(continueLoop){
            view.listProducts();
            String[] selectedProduct = view.sellProducts().split(",");
            Map<String, Object> productInStock = Product.productsStock.get(Integer.parseInt(selectedProduct[0]) - 1);
            if(Integer.valueOf(productInStock.get("quantidade").toString().trim()) < Integer.parseInt(selectedProduct[1])){
                System.err.println("Produto em estoque insuficiente. \nTemos quantidade disponível "+ productInStock.get("quantidade")+
                        " a venda. \nDeseja comprar uma quantidade menor ou outro item? ");
                String answer = view.answer();
                if(answer.equals("s")) continue;
                break;
            }
            
            System.out.println("Deseja algo mais? ");
            if(view.answer().equals("n")) continueLoop = false;
        }
        view.listFilteredProducts(products);
    }

    private void searchProduct() {
        String search = view.searchProduct();
        List<Map<String, Object>> filteredProducts = new ArrayList<>();
        for(Map<String, Object> product : Product.productsStock){
            String name = (String) product.get("nome");

            if(name.toLowerCase().contains(search)){
                filteredProducts.add(product);
            }
        }
        view.listFilteredProducts(filteredProducts);
    }

    private void createProduct() {
        while(true){
            Map<String, Object> product = view.getProductInformation();
            Product.productsStock.add(product);

            System.out.println("Continuar adicionando produtos? ");
            if(!view.answer().equals("s")) break;
        }
        Product.saveStock();
    }

    private void listProducts() {
        view.listProducts();
    }

    private void removeProduct() {
        view.removeProduct();
    }

    private void editProduct() {
        view.editProduct();


    }
}