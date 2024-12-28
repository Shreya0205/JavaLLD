package Code.Services;

import Code.CategoryType;
import Code.Product;
import Code.SearchInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventoryService implements SearchInterface {

    HashMap<CategoryType, List<Product>> categoryProducts;
    HashMap<Product, Integer> productQuantities;

    public InventoryService() {
        this.categoryProducts = new HashMap<>();
        this.productQuantities = new HashMap<>();
    }


    @Override
    public List<Product> searchByCategory(CategoryType categoryType) {
        return this.categoryProducts.get(categoryType);
    }

    @Override
    public List<Product> searchByProductName(String productName) {

        List<Product> result = new ArrayList<>();

        for (Product product: productQuantities.keySet()){
            if(product.getName().equals(productName))
                result.add(product);
        }

        return result;
    }

    public void addProduct(Product product){

        if(productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.getOrDefault(product, 0) + 1);
            return;
        }

        productQuantities.put(product, 1);
        categoryProducts.computeIfAbsent(product.getCategoryType(), k->new ArrayList<>()).add(product);
    }

    public void removeProduct(Product product){
        productQuantities.remove(product);
        categoryProducts.get(product.getCategoryType()).remove(product);
    }

    public void decrementQuantity(Product product){
        productQuantities.put(product, productQuantities.get(product)-1);
    }

    public boolean isProductAvailable(Product product){
        return !productQuantities.get(product).equals(0);
    }

    public void addCategory(CategoryType categoryType){
        this.categoryProducts.put(categoryType, new ArrayList<>());
    }

    public void removeCategory(CategoryType categoryType){
        this.categoryProducts.remove(categoryType);
    }
}
