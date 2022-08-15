package com.example.Storehouse.service;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.entity.RefundProducts;
import com.example.Storehouse.models.product.Product;
import com.example.Storehouse.models.request.CheckQuantityOfProductRequest;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.request.RefundRequest;
import com.example.Storehouse.models.request.SingleProductRequest;
import com.example.Storehouse.models.response.CheckQuantityResponse;
import com.example.Storehouse.models.response.MultiProductsResponse;
import com.example.Storehouse.models.response.RefundResponse;
import com.example.Storehouse.models.response.SingleProductResponse;

import java.util.Optional;

public interface iResponseService {
    void showInfoAboutRequest(Object obj);
    void requestToUpdateProductQuantityInDatabase(String name);
    void requestToUpdateProductInDatabase(int quantity, String name);
    void requestProcessedSuccessfully();
    void addProductToList(String name, int quantity);
    void clearListOfProducts();
    void checkingTheProductInTheDatabase(SingleProductRequest singleProductRequest);
    void checkingTheProductInTheDatabase(MultiProductRequest multiProductRequest);
    void saveProductInDatabase(RefundRequest request);
    void buildCheckQuantityProductResponse(CheckQuantityOfProductRequest request);
    void requestToSaveRefundProductToDatabase(RefundProducts refundProduct);
    Optional<SingleProductResponse> getResponse(SingleProductRequest singleProductRequest);
    Optional<RefundResponse> getResponse(RefundRequest refundRequest);
    Optional<CheckQuantityResponse> getResponse(CheckQuantityOfProductRequest request);
    Optional<MultiProductsResponse> getResponse(MultiProductRequest multiProductRequest);
    Optional<Products> requestToFindProductInDatabase(String name);
    Optional<Product> buildProductForResponse(int quantity, String name);
    boolean checkIfThereIsEnoughProductQuantity(int quantity, String name);
    int requestToGetQuantityOfProductFromDatabase(String name);
}
