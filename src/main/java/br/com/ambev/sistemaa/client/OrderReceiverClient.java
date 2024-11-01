package br.com.ambev.sistemaa.client;

import br.com.ambev.sistemaa.dto.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "orderReceiverClient",url = "${order-receiver.url}")
public interface OrderReceiverClient {

    @PostMapping
    ResponseEntity<String> receiveOrder(@RequestBody OrderRequest order);
}
