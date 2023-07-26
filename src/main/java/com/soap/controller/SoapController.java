package com.soap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soap.modelo.ApiUser;
import com.soap.modelo.ApiUser2;
import com.soap.modelo.ApiUser3;
import com.soap.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Metodo controlador getApiData() consume la api https://reqres.in/api/users a traves del controlado desde la url http://localhost:8080/api/user
 * Metodo controlador getApiDataProduct() consume la api https://reqres.in/api/products a traves del controlado desde la url http://localhost:8080/api/product
 * Metodo controlador getApiDataUser() consume la api https://jsonplaceholder.typicode.com/users a traves del controlado desde la url http://localhost:8080/api/otherUser
 * se envia la peticion hacia el @service y este devuelve una lista de usuario consumidos desde la API.
 */

@RestController
public class SoapController {
    ApiService apiService;

    @Autowired
    public SoapController(ApiService apiService){
        this.apiService=apiService;
    }

    @GetMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ApiUser3> getApiData() throws JsonProcessingException {

        ArrayList<ApiUser3> userListResponse = apiService.getUserAll();
        return userListResponse;
    }

    @GetMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ApiUser2> getApiDataProduct() throws JsonProcessingException {

        ArrayList<ApiUser2> productListResponse = apiService.getProductAll();
        return productListResponse;
    }

    @GetMapping(value = "/api/otherUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ApiUser> getApiDataUser() throws JsonProcessingException{

        ArrayList<ApiUser> usersListAllResponse = apiService.getApiJsonUser();
        return usersListAllResponse;
    }

}
