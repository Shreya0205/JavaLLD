package Code;

import java.util.ArrayList;
import java.util.List;

public class Product {
    Integer id;
    String name;
    CategoryType categoryType;
    List<Review> reviewList;
    Double price;

    public Product(Integer id, String name, CategoryType categoryType, Double price) {
        this.id = id;
        this.name = name;
        this.categoryType = categoryType;
        this.price = price;
        this.reviewList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public Double getPrice() {
        return price;
    }

    public void addReview(Review review){
        this.reviewList.add(review);
    }

}
