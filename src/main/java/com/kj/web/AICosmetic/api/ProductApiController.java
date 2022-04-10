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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    @GetMapping("/api/products")
    public Result getProductList() {
        List<Product> products = productService.findProducts();
        List<ProductListDto> collect = products
                .stream()
                .map(m->new ProductListDto(m.getId(), m.getName()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @GetMapping("/api/product/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long id) {
        Product product = productService.findProduct(id);
        return new ProductResponse(product);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class ProductListDto {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class ProductResponse {
        private Long id;
        private String name;
        private List<SaleResponse> sales;

        public ProductResponse(Product product) {
            id = product.getId();
            name = product.getName();
            sales = product.getSales()
                    .stream()
                    .map(m->new SaleResponse(m.getStartDate(), m.getEndDate()))
                    .collect(Collectors.toList());
        }
    }

}
