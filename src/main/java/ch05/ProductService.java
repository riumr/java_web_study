package ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
  Map<String, Product> products = new HashMap<>();

  public ProductService(){
    Product p = new Product("101","애플사과폰 12","애플전자",120000,"2020.12.12");
    products.put("101",p);
    p = new Product("102","삼전우주폰 21","삼전전자",130000,"2021.2.2");
    products.put("102",p);
    p = new Product("103","엘지","엘지전자",150000,"2021.3.2");
    products.put("103",p);
  }

  public List<Product> findAll(){
    return new ArrayList<>(products.values());
  }

  public Product find(String id){
    return products.get(id);
  }
}
