package br.com.ambev.sistemaa.controller;

import br.com.ambev.sistemaa.dto.OrderRequest;
import br.com.ambev.sistemaa.services.OrderReceiverClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.of;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderReceiverClientService service;

    @PostMapping
    public ResponseEntity<String> receiveOrder(@RequestBody OrderRequest order) {

        log.info("Receiving order: {}", order);

        return of(order)
                .map(orderRequest -> ResponseEntity.ok(service.receiveOrder(orderRequest)))
                .orElseThrow();
    }
}