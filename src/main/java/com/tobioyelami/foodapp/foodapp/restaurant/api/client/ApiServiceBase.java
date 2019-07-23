package com.tobioyelami.foodapp.foodapp.restaurant.api.client;

import com.tobioyelami.foodapp.foodapp.restaurant.exceptions.ApiException;

import java.util.List;

/**
 * Created by toyelami on 17/07/2019
 */
public abstract class ApiServiceBase<T> {

    protected final String rootUrl;
    protected final ClientHelper clientHelper;
    protected final Class<T> clazz;
    private final String endPoint;

    public ApiServiceBase(String endPoint, String rootUrl, Class<T> clazz) {
        this.rootUrl = rootUrl;
        this.endPoint = endPoint;
        this.clazz = clazz;
        clientHelper = new ClientHelper();
    }


    public List<T> getAll() throws ApiException {
        String url = rootUrl + endPoint;
        return clientHelper.getApiResponseList(url, clazz, "Could not get all models");
    }

    public T get(long id) throws ApiException {
        String url = rootUrl + endPoint + String.valueOf(id);
        return clientHelper.getApiResponse(url, clazz, "Could not get model");
    }

    public T create(T req) throws ApiException {
        String url = rootUrl + endPoint;
        return clientHelper.postApiResponse(url, req, clazz, "Could not add model");
    }

    public Boolean update(T req) throws ApiException {
        String url = rootUrl + endPoint;
        return clientHelper.putApiResponse(url, req, "Could not update model");
    }

    public Boolean delete(long id) throws ApiException {
        String url = rootUrl + endPoint + String.valueOf(id);
        return clientHelper.deleteApiResponse(url, "Could not delete model");
    }

    public List<T> getPaged(int pageSize, int page) throws ApiException {
        String url = String.format("%s%s?page=%d&pageSize=%d", rootUrl, endPoint, page, pageSize);
        return clientHelper.getApiResponseList(url, clazz, "could not get paged model");
    }

    public T findByParam(String paramName, String paramValue) throws ApiException {
        String url = String.format("%s%s/by?%s=%s", rootUrl, endPoint, paramName, paramValue);
        return clientHelper.getApiResponse(url, clazz, "Could not get model by param");
    }
}
