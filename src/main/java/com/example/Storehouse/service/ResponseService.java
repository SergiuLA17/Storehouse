package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.exception.exceptions.WrongQuantityException;
import com.example.Storehouse.service.logger.LoggerService;
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
    private LoggerService loggerService;
    @Autowired
    private  StorehouseService service;

    private Optional<Products> requestToFindProductInDatabase(String name){
        return service.findByName(name);
    }

    private boolean checkIfThereIsEnoughProductQuantity(int quantity, String name) {
        if (500 < quantity || quantity <= 0) {
            if (quantity == 0) {
                throw new WrongQuantityException("Wrong quantity value. Request quantity: " + quantity);
            } else
                throw new WrongQuantityException("Sorry, this quantity is too large for our store. Maximum quantity 500");
        } else
            return requestToFindProductInDatabase(name).get().getQuantity() > quantity;
    }

     private Optional<Product> buildProductForResponse(int quantity, String name) {
        return requestToFindProductInDatabase(name).map(products ->
                Product.builder()
                .idProduct(products.getIdProduct())
                .name(products.getName())
                .quantity(quantity)
                .dateOfManufacture(products.getDateOfManufacture())
                .daysToExpire(products.getDaysToExpire())
                .build());
    }

    private void requestToUpdateProductQuantityInDatabase(String name) {
        service.updateQuantityProduct(name);
    }

    private void requestToUpdateProductInDatabase(int quantity, String name) {
        service.updateDataBase(name, quantity);
    }

    private void requestToSaveRefundProductToDatabase(RefundProducts refundProduct){
        service.saveRefundProduct(refundProduct);
    }

    private int requestToGetQuantityOfProductFromDatabase(String name){
        return service.getQuantityOfProduct(name);
    }


     public  Optional<SingleProductResponse> getResponse(SingleProductRequest singleProductRequest) {
         proceedProduct(singleProductRequest);
        return Optional.ofNullable(SingleProductResponse.builder()
                .nameOfProduct(buildProductForResponse(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName()).get())
                .requestUUID(singleProductRequest.getRequestUUID())
                .build());
    }
    public  Optional<RefundResponse> getResponse(RefundRequest refundRequest){
        saveProductInDatabase(refundRequest);
        return Optional.ofNullable(RefundResponse.builder()
                .requestUUID(refundRequest.getRequestUUID())
                .message("Request was successfully processed")
                .build());
    }

    public  Optional<CheckQuantityResponse> getResponse(CheckQuantityOfProductRequest request){
        buildCheckQuantityProductResponse(request);
        return Optional.ofNullable(CheckQuantityResponse.builder()
                .requestUUID(request.getRequestUUID())
                .nameOfProduct(request.getNameOfProduct())
                .quantityOfProduct(requestToGetQuantityOfProductFromDatabase(request.getNameOfProduct()))
                .build());
    }



    public  Optional<MultiProductsResponse> getResponse(MultiProductRequest multiProductRequest){
        return Optional.ofNullable(MultiProductsResponse
                .builder().products(proceedProduct(multiProductRequest))
                .uuid(multiProductRequest.getRequestUUID())
                .build());
    }


    private void proceedProduct(SingleProductRequest singleProductRequest) {
        loggerService.showInfoAboutRequest(singleProductRequest);

        if (checkIfThereIsEnoughProductQuantity(singleProductRequest.getProductQuantity(), singleProductRequest.getProductName())) {
            requestToUpdateProductInDatabase(singleProductRequest.getProductQuantity(),singleProductRequest.getProductName());
        } else {
            requestToUpdateProductQuantityInDatabase(singleProductRequest.getProductName());
            requestToUpdateProductInDatabase(singleProductRequest.getProductQuantity(),singleProductRequest.getProductName());
        }
        loggerService.requestProcessedSuccessfully();
    }

    private List<Product> proceedProduct(MultiProductRequest multiProductRequest) {
        final List<Product> productList = new ArrayList<>();
        loggerService.showInfoAboutRequest(multiProductRequest);

        for (RequiredProduct product : multiProductRequest.getListOfRequiredProducts()) {

            if (checkIfThereIsEnoughProductQuantity(product.getQuantity(),product.getName())) {
                productList.add(buildProductForResponse(product.getQuantity(),product.getName()).get());
            } else {
                requestToUpdateProductQuantityInDatabase(product.getName());
                productList.add(buildProductForResponse(product.getQuantity(),product.getName()).get());
            }

            requestToUpdateProductInDatabase(product.getQuantity(),product.getName());
        }
        loggerService.requestProcessedSuccessfully();
        return productList;
    }

    private void saveProductInDatabase(RefundRequest request){
        loggerService.showInfoAboutRequest(request);

        requestToSaveRefundProductToDatabase(request.getRefundProduct());

        loggerService.requestProcessedSuccessfully();
    }

    private void buildCheckQuantityProductResponse(CheckQuantityOfProductRequest request){
        loggerService.showInfoAboutRequest(request);

        requestToFindProductInDatabase(request.getNameOfProduct());

        loggerService.requestProcessedSuccessfully();
    }
}
