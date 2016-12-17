package edu.xtu.androidbase.weaher.ui.weather.model.request;

import java.util.List;

import edu.xtu.androidbase.weaher.ui.weather.domain.SelectCity;

/**
 * Created by huilin on 2016/12/16.
 */

public class MainRequest {
    private List<SelectCity> selectCities;

    public List<SelectCity> getSelectCities() {
        return selectCities;
    }

    public void setSelectCities(List<SelectCity> selectCities) {
        this.selectCities = selectCities;
    }
}
