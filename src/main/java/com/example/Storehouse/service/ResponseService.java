package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.exception.exceptions.WrongQuantityException;
import com.example.Storehouse.logger.Print;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.product.RequiredProduct;
import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;
import com.example.Storehouse.models.response.MultiProductsResponse;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.models.response.SingleProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements iResponseService {
    @Autowired
    private Print print;
    @Autowired
    private StorehouseService service;
    private final List<Product> productList = new ArrayList<>();

    public void showInfoAboutRequest(Object obj) {
        print.info("New request. " + obj.toString());
    }

    public Optional<Products> requestToFindProductInDatabase(String name){
        return service.findByName(name);
    }

    public boolean checkIfThereIsEnoughProductQuantity(int quantity, String name) {
        if (500 < quantity || quantity <= 0) {
            if (quantity == 0) {
                throw new WrongQuantityException("Wrong quantity value. Request quantity: " + quantity);
            } else
                throw new WrongQuantityException("Sorry, this quantity is too large for our store. Maximum quantity 500");
        } else
            return requestToFindProductInDatabase(name).get().getQuantity() > quantity;
    }

    public Optional<Product> buildProductForResponse(int quantity, String name) {
        return requestToFindProductInDatabase(name).map(products ->
                Product.builder()
                .idProduct(products.getIdProduct())
                .name(products.getName())
                .quantity(quantity)
                .dateOfManufacture(products.getDateOfManufacture())
                .daysToExpire(products.getDaysToExpire())
                .build());
    }

    public void requestToUpdateProductQuantityInDatabase(String name) {
        service.updateQuantityProduct(name);
    }

    public void requestToUpdateProductInDatabase(int quantity, String name) {
        service.updateDataBase(name, quantity);
    }

    public void requestProcessedSuccessfully() {
        print.info("Request was successfully processed\n");
    }

    public void addProductToList(String name, int quantity){
            productList.add(buildProductForResponse(quantity, name).get());
    }

    public void clearListOfProducts(){
        productList.clear();
    }

    public void requestToSaveRefundProductToDatabase(RefundProducts refundProduct){
        service.saveRefundProduct(refundProduct);
    }

    public int requestToGetQuantityOfProductFromDatabase(String name){
        return service.getQuantityOfProduct(name);
    }


    public Optional<SingleProductResponse> getResponse(SingleProductRequest singleProductRequest) {
        checkingTheProductInTheDatabase(singleProductRequest);
        return Optional.ofNullable(SingleProductResponse.builder()
                .nameOfProduct(buildProductForResponse(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName()).get())
                .requestUUID(singleProductRequest.getRequestUUID())
                .build());
    }
    public Optional<RefundResponse> getResponse(RefundRequest refundRequest){
        saveProductInDatabase(refundRequest);
        return Optional.ofNullable(RefundResponse.builder()
                .requestUUID(refundRequest.getRequestUUID())
                .message("Request was successfully processed")
                .build());
    }

    public Optional<CheckQuantityResponse> getResponse(CheckQuantityOfProductRequest request){
        buildCheckQuantityProductResponse(request);
        return Optional.ofNullable(CheckQuantityResponse.builder()
                .requestUUID(request.getRequestUUID())
                .nameOfProduct(request.getNameOfProduct())
                .quantityOfProduct(requestToGetQuantityOfProductFromDatabase(request.getNameOfProduct()))
                .build());
    }



    public Optional<MultiProductsResponse> getResponse(MultiProductRequest multiProductRequest){
        checkingTheProductInTheDatabase(multiProductRequest);
        return Optional.ofNullable(MultiProductsResponse
                .builder().products(productList)
                .uuid(multiProductRequest.getRequestUUID())
                .build());
    }


    public void checkingTheProductInTheDatabase(SingleProductRequest singleProductRequest) {
        showInfoAboutRequest(singleProductRequest);

        if (checkIfThereIsEnoughProductQuantity(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName())) {
            requestToUpdateProductInDatabase(singleProductRequest.getProductQuantity(),singleProductRequest.getProductName());
        } else {
            requestToUpdateProductQuantityInDatabase(singleProductRequest.getProductName());
            requestToUpdateProductInDatabase(singleProductRequest.getProductQuantity(),singleProductRequest.getProductName());
        }
        requestProcessedSuccessfully();
    }

    public void checkingTheProductInTheDatabase(MultiProductRequest multiProductRequest) {
        clearListOfProducts();
        showInfoAboutRequest(multiProductRequest);

        for (RequiredProduct product : multiProductRequest.getListOfRequiredProducts()) {

            if (checkIfThereIsEnoughProductQuantity(product.getQuantity(),product.getName())) {
                addProductToList(product.getName(),product.getQuantity());
            } else {
                requestToUpdateProductQuantityInDatabase(product.getName());
                addProductToList(product.getName(),product.getQuantity());
            }

            requestToUpdateProductInDatabase(product.getQuantity(),product.getName());
        }
        requestProcessedSuccessfully();
    }

    public void saveProductInDatabase(RefundRequest request){
        showInfoAboutRequest(request);

        requestToSaveRefundProductToDatabase(request.getRefundProduct());

        requestProcessedSuccessfully();
    }

    public void buildCheckQuantityProductResponse(CheckQuantityOfProductRequest request){
        showInfoAboutRequest(request);

        requestToFindProductInDatabase(request.getNameOfProduct());

        requestProcessedSuccessfully();
    }






}
