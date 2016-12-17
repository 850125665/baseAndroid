package edu.xtu.androidbase.weaher.ui.weather.model;

import java.util.List;

import edu.xtu.androidbase.weaher.ui.weather.domain.SelectCity;
import edu.xtu.androidbase.weaher.ui.weather.domain.SelectCityDao;
import edu.xtu.androidbase.weaher.ui.weather.domain.Weather;
import edu.xtu.androidbase.weaher.ui.weather.domain.WeatherAPI;
import edu.xtu.androidbase.weaher.ui.weather.model.request.MainRequest;
import edu.xtu.androidbase.weaher.util.DbManager;
import edu.xtu.androidbase.weaher.util.LogUtils;
import edu.xtu.androidbase.weaher.util.Retrofit.Api;
import edu.xtu.androidbase.weaher.util.Retrofit.ApiService;
import edu.xtu.androidbase.weaher.util.RxUtil.RxHelp;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by huilin on 2016/12/14.
 */

public class MainModel implements IMainModel {

    private String TAG = getClass().getSimpleName();

    @Override
    public Observable<Weather> showWeatherList(final MainRequest mainRequest) {
//        DbManager.getInstant().mDaoSession.getSelectCityDao()
//                .rx()
//                .loadAll()
//                .take(3)
//                .flatMap(new Func1<List<SelectCity>, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(List<SelectCity> selectCities) {
//                        return ApiService.getInstanct().getWeather(selectCities.get());
//                    }
//                });
        return Observable.defer(new Func0<Observable<SelectCity>>() {
            @Override
            public Observable<SelectCity> call() {
                return Observable.from(mainRequest.getSelectCities());
            }
        })
                .distinct()
                .flatMap(new Func1<SelectCity, Observable<Weather>>() {
                    @Override
                    public Observable<Weather> call(SelectCity selectCity) {
                        LogUtils.d(TAG, selectCity.toString());
                        return ApiService.getInstanct().getWeather(selectCity.getCityName())
                                .map(new Func1<WeatherAPI, Weather>() {
                                    @Override
                                    public Weather call(WeatherAPI weatherAPI) {
                                        return weatherAPI.mHeWeatherDataService30s.get(0);
                                    }
                                });

                    }
                })
                .filter(new Func1<Weather, Boolean>() {
                    @Override
                    public Boolean call(Weather weather) {
                        return !"unknown city".equals(weather.status);
                    }
                });


    }
}
