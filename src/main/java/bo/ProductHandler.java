package bo;

import ui.ProductInfo;

import java.util.ArrayList;
import java.util.List;

// Fasadobjekt för att UI lagret inte ska ha tillgång till det riktiga verksamhetsobjektet Product.
public class ProductHandler {

    public static List<ProductInfo> getProducts() {
        List<Product> products = Product.getProducts();
        List<ProductInfo> productInfos = new ArrayList<>();
        // Omvandlar till ProductInfo för att Product inte ska användas utanför verksamhetslagret.
        products.forEach(product -> productInfos.add(new ProductInfo(product.getName(), product.getPrice())));
        return productInfos;
    }
}
