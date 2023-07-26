package com.soap.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * ApiUser3 Corresponde a la URl de la API https://reqres.in/api/users
 * {"id", "email", "first_name", "last_name", "avatar"}, que es una copia del modelo de la APi
 * a consumir, en En una Clase pojo, con anotaciones Lombok.
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonPropertyOrder({"id", "email", "first_name", "last_name", "avatar"})
public class ApiUser3 {

    @JsonProperty("id")
    private long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("avatar")
    private String avatar;

}
