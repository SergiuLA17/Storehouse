package com.example.Storehouse.responseBuilder.multiproduct;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.exceptions.WrongQuantityException;
import com.example.Storehouse.logger.Print;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.product.ProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.response.multiProductsResponse.MultiProductsResponse;
import com.example.Storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MultiProductResponseBuilder implements iMultiProductResponseBuilder {
    @Autowired
    private Print print;
    @Autowired
    private StorehouseService service;
    private MultiProductRequest request;
    private MultiProductsResponse response;
    private final List<Product> productList = new ArrayList<>();
    private Optional<Products> foundedProduct;

    public MultiProductResponseBuilder() {
    }

    public void dataPreparation(MultiProductRequest superMarketRequest) {
        productList.clear();
        request = superMarketRequest;
        print.info("New request. " + request);
    }


    public void requestToFoundProduct(String name) {
        foundedProduct = service.findByName(name);
    }

    public boolean checkIfThereIsEnoughProductQuantity(int quantity) {
        if (500 < quantity || quantity <= 0) {
            if (quantity <= 0) {
                throw new WrongQuantityException("Wrong quantity value. Request quantity: " + quantity );
            } else
                throw new WrongQuantityException("Sorry, this quantity is too large for our store. Maximum quantity 500");
        } else
            return foundedProduct.map(products -> products.getQuantity() > quantity).orElseGet(() -> false);
    }

    public Optional<Product> buildProductForResponse(int quantity){
        return Optional.ofNullable(Product.builder()
                .idProduct(foundedProduct.get().getIdProduct())
                .name(foundedProduct.get().getName())
                .quantity(quantity)
                .dateOfManufacture(foundedProduct.get().getDateOfManufacture())
                .daysToExpire(foundedProduct.get().getDaysToExpire())
                .build());
    }

    public void requestToUpdateProductQuantity(int quantity){
        foundedProduct.ifPresent(products -> products.setQuantity(quantity));
        foundedProduct.ifPresent(products -> service.updateQuantityProduct(foundedProduct.get().getName()));
    }

    public void requestToUpdateProduct(int quantity){
        foundedProduct.ifPresent(products -> service.updateDataBase(foundedProduct.get().getName(), quantity));
    }

    public void addDataToResponse(){
        response = MultiProductsResponse
                .builder().products(productList)
                .uuid(request.getId())
                .build();
    }

    public MultiProductsResponse getResponse() {
            return response;
    }

    public void buildCompletedSuccessfully() {
        print.info("Request was successfully processed");
    }

    public void build() {
        for (ProductRequest product : request.getRequiredProducts().get()) {
            requestToFoundProduct(product.getName());

            if (checkIfThereIsEnoughProductQuantity(product.getQuantity())) {
                productList.add(buildProductForResponse(product.getQuantity()).get());
            } else {
                requestToUpdateProductQuantity(product.getQuantity());
                productList.add(buildProductForResponse(product.getQuantity()).get());
            }

            requestToUpdateProduct(product.getQuantity());
        }

        addDataToResponse();
    }

}
