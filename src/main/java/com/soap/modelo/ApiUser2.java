package com.soap.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ApiUser2 Corresponde al URl de la API https://reqres.in/api/products
 * {"id", "name", "year", "color", "pantone_value"} que es una copia del modelo de la APi
 *  * a consumir, en una clase pojo con su constructor vacio y lleno, ademas de sus respectivos getter y setter.
 */

@JsonIgnoreProperties(ignoreUnknown = true)   //Ignora si si clase Java no tiene todos los campos correspondientes a todas las propiedades Json
public class ApiUser2 {

    private long id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    public ApiUser2() {
        super();
    }

    public ApiUser2(long id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }
}
