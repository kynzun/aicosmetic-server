package com.kj.web.AICosmetic.api;

import com.kj.web.AICosmetic.api.SaleApiController.SaleResponse;
import com.kj.web.AICosmetic.domain.Product;
import com.kj.web.AICosmetic.domain.Sale;
import com.kj.web.AICosmetic.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    @GetMapping("/api/products")
    public Result getProductList() {
        List<Product> products = productService.findProducts();
        List<ProductListResponse> collect = products
                .stream()
                .map(m -> new ProductListResponse(m))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @GetMapping("/api/products/{id}")
    public ProductDetailResponse getProduct(@PathVariable("id") Long id) {
        Product product = productService.findProduct(id);
        return new ProductDetailResponse(product);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class ProductListResponse {
        private Long id;
        private String product_name;
        private Long original_price;
        private Long current_price;
        private LocalDate sale_from;
        private LocalDate sale_to;

        public ProductListResponse(Product product) {
            id = product.getId();
            product_name = product.getName();
            original_price = product.getOriginal_price();
            current_price = product.getCurrent_price();
            List<Sale> salesList =product.getSales();
            sale_from = salesList.get(salesList.size()-1).getStartDate();
            sale_to = salesList.get(salesList.size()-1).getEndDate();
        }

    }

    @Data
    @AllArgsConstructor
    static class ProductDetailResponse {
        private Long id;
        private String product_name;
        private Long original_price;
        private Long current_price;
        private LocalDate sale_from;
        private LocalDate sale_to;
        private int sales_num;
        private List<SaleResponse> sales;

        public ProductDetailResponse(Product product) {
            id = product.getId();
            product_name = product.getName();
            original_price = product.getOriginal_price();
            current_price = product.getCurrent_price();
            List<Sale> salesList =product.getSales();
            sale_from = salesList.get(salesList.size()-1).getStartDate();
            sale_to = salesList.get(salesList.size()-1).getEndDate();
            sales_num = salesList.size();
            sales = salesList.stream()
                    .map(m -> new SaleResponse(m.getDiscountRate(), m.getStartDate(), m.getEndDate()))
                    .collect(Collectors.toList());
        }
    }

}
