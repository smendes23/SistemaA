package br.com.ambev.sistemaa.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderRequest(
        List<ProductRequest> products,
        BigDecimal totalAmount,
        String status,
        String idempotencyKey
) {
    public OrderRequest withStatus(String status){
        return new OrderRequest(products(), BigDecimal.ZERO, status, idempotencyKey());
    }
}
