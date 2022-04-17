package com.kj.web.AICosmetic.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class SaleApiController {

    @Data
    @AllArgsConstructor
    static class SaleResponse{
        private Long discountRate;
        private LocalDate startDate;
        private LocalDate endDate;
    }
}
