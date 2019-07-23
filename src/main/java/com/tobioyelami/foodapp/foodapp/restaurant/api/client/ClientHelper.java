package com.tobioyelami.foodapp.foodapp.restaurant.api.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by toyelami on 17/07/2019
 */
public class ClientHelper {

    private RestTemplate restTemplate = new RestTemplate();

    public <T> List<T> getApiResponseList(String url, Class<T> clazz, String errorMessage) {
        throw new UnsupportedOperationException();
    }

    public <T> T getApiResponse(String url, Class<T> clazz, String errorMessage) {
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, clazz);
        return responseEntity.getBody();
    }

    public <T> T postApiResponse(String url, T req, Class<T> clazz, String errorMessage) {
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, req, clazz);
        return responseEntity.getBody();
    }

    public <T> Boolean putApiResponse(String url, T req, String errorMessage) {
        HttpEntity httpEntity = new HttpEntity<>(req);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Boolean.class);
        return responseEntity.getBody();
    }

    public Boolean deleteApiResponse(String url, String errorMessage) {
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Boolean.class);
        return responseEntity.getBody();
    }
}
