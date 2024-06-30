package com.keyin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    @JsonProperty("name")
    private String name;

    @JsonProperty("province")
    private String province;

    @JsonProperty("population")
    private int population;

    public City(String name, String province, int population) {
        this.name = name;
        this.province = province;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}