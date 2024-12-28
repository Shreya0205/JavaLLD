package Code;

import java.util.List;

public interface SearchInterface {

    public List<Product> searchByCategory(CategoryType categoryType);
    public List<Product> searchByProductName(String productName);

}
