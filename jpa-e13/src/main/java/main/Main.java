package main;

import services.ProductService;

public class Main {

    public static void main(String[] args) {
        var productService = new ProductService();
        productService.addProduct("Beer");
        productService.addProduct("Chocolate");

        productService.findAllProducts()
                .forEach(System.out::println);
    }

}
