package view;

import model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductView {

    Scanner scan = new Scanner(System.in);

    public String opcaoMenu(){
        System.out.println("""
            1 - Criar produto
            2 - Editar produto
            3 - Remover produto
            4 - Listar produtos
            5 - Pesquisar produtos
            6 - Venda de produtos
            0 - Sair do programa
                """);

        return scan.nextLine();

    }

    public void listProducts() {
        for (int i = 0; i < Product.productsStock.size(); i++){
            Map<String, Object> product = Product.productsStock.get(i);
            System.out.printf("%d - %s - Quantidade: %s - Valor: R$ %s\n",
                    (i+1), product.get("nome"), product.get("quantidade"),  product.get("valor"));
        }
    }

    public Map<String, Object> getProductInformation() {
        Map<String, Object> product = new HashMap<>();
        System.out.println("Nome do produto? ");
        System.out.print("> ");
        product.put("nome", scan.nextLine());
        System.out.println("Quantidade do produto? ");
        System.out.print("> ");
        product.put("quantidade", scan.nextLine());
        System.out.println("Valor do produto? ");
        System.out.print("> ");
        product.put("valor", scan.nextLine());

        return product;

    }

    public String answer(){
        return scan.nextLine();
    }

    public void editProduct(){
        System.out.println("Você deseja editar qual produto? Se não deseja editar nada digite 0");
        listProducts();
        String option = answer();
        if(option.equals("0")){
            System.out.println("Voltando para o menu. ");
        } else{
            Map<String, Object> newProduct = getProductInformation();
            Product.productsStock.get(Integer.parseInt(option) - 1).putAll(newProduct);
        }
    }

    public void removeProduct() {
        System.out.println("Você deseja remover qual produto? Se não deseja remover nada digite 0");
        listProducts();
        String option = answer();
        if(option.equals("0")){
            System.out.println("Voltando para o menu. ");
        } else{
            Product.productsStock.remove(Integer.parseInt(option) - 1);
        }
    }

    public String searchProduct() {
        System.out.println("Digite o nome ou parte dele: ");
        String search = scan.nextLine().toLowerCase();

        return search;

    }

    public void listFilteredProducts(List<Map<String, Object>> products){

        for (int i = 0; i < products.size(); i++){
            Map<String, Object> product = products.get(i);
            System.out.printf("%d - %s - Quantidade: %s - Valor: R$ %s\n",
                    (i+1), product.get("nome"), product.get("quantidade"),  product.get("valor"));
        }
    }

    public String sellProducts() {
        System.out.println("O que deseja comprar? ");
        String option = answer();
        System.out.println("Qual a quantidade");
        option += "," + answer();

        return option;
    }
}