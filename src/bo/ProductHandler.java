package bo;

import ui.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductHandler {

    public static List<ProductInfo> getProducts() {
        List<Product> products = Product.getProducts();
        List<ProductInfo> productInfos = new ArrayList<>();
        products.forEach(product -> productInfos.add(new ProductInfo(product.getName(), product.getPrice())));
        return productInfos;
    }
}
