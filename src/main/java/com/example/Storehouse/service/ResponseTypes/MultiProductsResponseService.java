package com.example.Storehouse.service.ResponseTypes;

import com.example.Storehouse.entity.Products;
import com.example.Storehouse.exception.exceptions.ProductNotFoundException;
import com.example.Storehouse.models.product.RequiredProduct;
import com.example.Storehouse.models.request.MultiProductRequest;
import com.example.Storehouse.models.response.MultiProductsResponse;
import com.example.Storehouse.service.StorehouseService;
import com.example.Storehouse.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MultiProductsResponseService implements iMultiProductsResponseService {
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private StorehouseService storehouseService;


    public MultiProductsResponse getMultiProductResponse(MultiProductRequest multiProductRequest) {
        loggerService.requestProcessedSuccessfully();
        return MultiProductsResponse
                .builder().products(proceedProduct(multiProductRequest))
                .uuid(multiProductRequest.getRequestUUID())
                .build();
    }

    private List<Products> proceedProduct(MultiProductRequest multiProductRequest) {
        loggerService.showInfoAboutRequest(multiProductRequest);

        return getAllProductsFromDB(multiProductRequest).stream()
                .filter(condition(multiProductRequest))
                .map(products -> condition(multiProductRequest.getListOfRequiredProducts().size(), products, multiProductRequest))
                .collect(Collectors.toList());
    }


    private List<Products> getAllProductsFromDB(MultiProductRequest multiProductRequest) {
        final List<Products> productsList = new ArrayList<>();
        storehouseService.findAll()
                .iterator()
                .forEachRemaining(productsList::add);

        productVerification(productsList, multiProductRequest);

        quantityVerification(multiProductRequest);

        return productsList;
    }

    private Products condition(int size, Products products, MultiProductRequest multiProductRequest) {
        for (int i = 0; i < size; i++) {
            if (products.getName().equals(multiProductRequest.getListOfRequiredProducts().get(i).getName())) {
                products.setQuantity(multiProductRequest.getListOfRequiredProducts().get(i).getQuantity());
                return products;
            }
        }
        return products;
    }

    private Predicate<Products> condition(MultiProductRequest multiProductRequest) {
        return products -> {
            final List<String> productNames = multiProductRequest
                    .getListOfRequiredProducts()
                    .stream()
                    .map(RequiredProduct::getName)
                    .collect(Collectors.toList());
            return productNames.contains(products.getName());
        };
    }


    private void productVerification(List<Products> productsList, MultiProductRequest multiProductRequest) {
        List<String> productNames = productsList.stream().map(Products::getName).collect(Collectors.toList());

        for (int i = 0; i < multiProductRequest.getListOfRequiredProducts().size(); i++) {
            if (!(productNames.contains(multiProductRequest.getListOfRequiredProducts().get(i).getName())))
                throw new ProductNotFoundException("Wrong name or product name"
                        + multiProductRequest.getListOfRequiredProducts().get(i).getName() + " not found");
        }
    }

    private void quantityVerification(MultiProductRequest multiProductRequest) {
        for (RequiredProduct product : multiProductRequest.getListOfRequiredProducts()) {
            if (!(storehouseService.checkIfThereIsEnoughProductQuantity(product.getQuantity(), product.getName()))) {
                storehouseService.updateQuantityProduct(product.getName());
            }
            storehouseService.updateDataBase(product.getName(), product.getQuantity());
        }
    }

}
