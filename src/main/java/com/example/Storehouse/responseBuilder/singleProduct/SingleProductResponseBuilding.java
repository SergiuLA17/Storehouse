package com.example.Storehouse.responseBuilder.singleProduct;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.exceptions.WrongQuantityException;
import com.example.Storehouse.logger.Print;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.singleProductResponse.SingleProductResponse;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SingleProductResponseBuilding implements iSingleProductResponseBuilder {
    @Autowired
    private Print print;
    @Autowired
    private StorehouseService service;
    private SingleProductRequest request;
    private SingleProductResponse response;
    private Optional<Products> foundedProduct;

    public SingleProductResponseBuilding() {
    }

    public void dataPreparation(SingleProductRequest SuperMarketRequest){
        request = SingleProductRequest.builder()
                .name(SuperMarketRequest.getName())
                .uuid(SuperMarketRequest.getUuid())
                .quantity(SuperMarketRequest.getQuantity())
                .build();
        print.info("New request. " + request.getName() + ", " + request.getQuantity());
    }

    public void requestToFoundProduct() {
        foundedProduct = service.findByName(request.getName());
    }

    public boolean checkIfThereIsEnoughProductQuantity() {
        if (500 < request.getQuantity() || request.getQuantity() <= 0) {
            if (request.getQuantity() <= 0) {
                throw new WrongQuantityException("Wrong quantity value. Request quantity: " + request.getQuantity() );
            } else
                throw new WrongQuantityException("Sorry, this quantity is too large for our store. Maximum quantity 500");
        } else
            return foundedProduct.map(products -> products.getQuantity() > request.getQuantity()).orElseGet(() -> false);
    }

    public void addDataToResponse() {
        response = SingleProductResponse.builder()
                .product(buildProductForResponse())
                .uuid(request.getUuid()).build();

    }

    public Optional<Product> buildProductForResponse(){
        return Optional.ofNullable(Product.builder()
                .idProduct(foundedProduct.get().getIdProduct())
                .name(foundedProduct.get().getName())
                .quantity(request.getQuantity())
                .dateOfManufacture(foundedProduct.get().getDateOfManufacture())
                .daysToExpire(foundedProduct.get().getDaysToExpire())
                .build());
    }

    public void requestToUpdateProductQuantity(){
        foundedProduct.get().setQuantity(request.getQuantity());
        foundedProduct.ifPresent(products -> service.updateQuantityProduct(foundedProduct.get().getName()));
    }

    public void requestToUpdateProduct(){
        foundedProduct.ifPresent(products -> service.updateDataBase(foundedProduct.get().getName(), request.getQuantity()));
    }

    public void buildCompletedSuccessfully() {
        print.info("Request was successfully processed");
    }

    public SingleProductResponse getResponse() {
        return response;
    }

    public void build(){
        requestToFoundProduct();
        if (checkIfThereIsEnoughProductQuantity()) {
            addDataToResponse();
        } else {
            requestToUpdateProductQuantity();
            addDataToResponse();
        }
        requestToUpdateProduct();
    }
}