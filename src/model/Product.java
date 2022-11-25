package model;

import javax.management.ObjectName;
import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;

public class Product{
    public static List<Map<String, Object>> productsStock = new ArrayList<>();
    final private static Path pathOfFile = Paths.get("productsStock.txt");

    public static void verifyStock() throws IOException {
        if (Files.exists(pathOfFile)) {

            Stream<String> stream = Files.lines(pathOfFile, StandardCharsets.UTF_8);
            stream.forEach(stringProduct -> {
                Map<String, Object> map = new HashMap<>();
                String[] productInfos = stringProduct.split(",");
                map.put("nome", productInfos[0]);
                map.put("quantidade", productInfos[1]);
                map.put("valor", productInfos[2]);
                productsStock.add(map);

            });
            System.out.println(productsStock);
        }
    }

    public static void saveStock(){
        List<String> toSaveStock = new ArrayList<>();
        System.out.println(productsStock);

        productsStock.forEach(product -> {
            var x = product.get("nome");
            var y = product.get("quantidade");
            var z = product.get("valor");

            toSaveStock.add("" + x + ", " + y + ", "  + z);
        });

        try {
            Files.write(pathOfFile, toSaveStock, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro de arquivo: " + e.getMessage());;
        }
    }


}
