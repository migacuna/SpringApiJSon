package com.soap.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soap.modelo.ApiUser;
import com.soap.modelo.ApiUser2;
import com.soap.modelo.ApiUser3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

/**
 *  En este servicio, Posee 3 metodos de diferentes Api para su consumo.
 *  A traves de RestTemplate capturamos la url, se convierte a Json y esta a un objeto JsNode para extraer
 *  su data.
 */

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ArrayList<ApiUser3> getUserAll() throws JsonProcessingException {
        ArrayList<ApiUser3> listUser = new ArrayList<>();
        List<ApiUser3> users = new ArrayList<>();
        try {
            String apiUrl = "https://reqres.in/api/users";
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(apiUrl, String.class);

            ObjectMapper mapper = new ObjectMapper();

            // Convertir la cadena JSON en un objeto JsonNode
            JsonNode jsonNode = mapper.readTree(response);
            // Acceder a las propiedades "id" y "email" del objeto "data"
            JsonNode dataNode = jsonNode.get("data");

            //Ciclo para mapear JsNode a una Lista de clase Java del objeto tipo ApiUser
            for (JsonNode jsonUser : dataNode) {
                ApiUser3 apiUser3 = mapper.treeToValue(jsonUser, ApiUser3.class);
                users.add(apiUser3);
            }

            // Ejemplo de extracion individual de la propiedad del objeto "data"
                /*
                Long id = dataNode.get("id").asLong();
                String name = dataNode.get("first_name").toString();
                String lastName = dataNode.get("last_name").toString();
                String avatar = dataNode.get("avatar").toString();
                String email = dataNode.get("email").asText();

                // Imprimir los resultados
                System.out.println("ID: " + id);
                System.out.println("Email: " + email);
                return dataNode; */

        }catch (Exception e){
            e.printStackTrace();
        }
        listUser.addAll(users);
        return listUser;
    }

    public ArrayList<ApiUser2> getProductAll() throws JsonProcessingException{
        ArrayList<ApiUser2> listProducts = new ArrayList<>();
        List<ApiUser2> products = new ArrayList<>();
        try{
            String apiUrl = "https://reqres.in/api/products";
            RestTemplate restTemplate1 = new RestTemplate();
            String response = restTemplate1.getForObject(apiUrl, String.class);

            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(response);

            JsonNode dataNode = jsonNode.get("data");

            for(JsonNode dataProduct: dataNode){
                ApiUser2 apiUser2 = mapper.treeToValue(dataProduct, ApiUser2.class);
                products.add(apiUser2);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        listProducts.addAll(products);
        return listProducts;
    }

    public ArrayList<ApiUser> getApiJsonUser() throws JsonProcessingException{
        ArrayList<ApiUser> listJsonUser = new ArrayList<>();
        List<ApiUser> userJs = new ArrayList<>();
        try{
            String apiUrl = "https://jsonplaceholder.typicode.com/users";
            RestTemplate restTemplate2 = new RestTemplate();
            String response = restTemplate2.getForObject(apiUrl, String.class);

            ObjectMapper mapper = new ObjectMapper();

            JsonNode userData = mapper.readTree(response);

            for (JsonNode jsUserData: userData ){
                ApiUser apiUser = mapper.treeToValue(jsUserData, ApiUser.class);
                userJs.add(apiUser);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        listJsonUser.addAll(userJs);
        return listJsonUser;
    }
}
