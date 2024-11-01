package br.com.ambev.sistemaa.services;

import br.com.ambev.sistemaa.client.OrderReceiverClient;
import br.com.ambev.sistemaa.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderReceiverClientService {

    private final OrderReceiverClient client;
    public String receiveOrder(final OrderRequest request) {
        try{
            log.info("Receiving order: {}", request);
            ResponseEntity<String> response = client.receiveOrder(request);
            if(response.getStatusCode().isError()){
                throw new Exception("Error receiving order");
            }
            return response.getBody();
        }catch (Exception e){
            log.error("Error to receive order: {}", request, e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
