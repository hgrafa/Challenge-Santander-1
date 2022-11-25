package view;

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
            0 - Sair do programa
                """);

        return scan.nextLine();

    }

    public void listProducts() {
    }

    public Map<String, Object> getProductInformation() {
        return null;
    }


}