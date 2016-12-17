package edu.xtu.androidbase.weaher.ui.weather.domain;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import edu.xtu.androidbase.weaher.ui.weather.domain.City;
import edu.xtu.androidbase.weaher.ui.weather.domain.Province;
import edu.xtu.androidbase.weaher.ui.weather.domain.SelectCity;
import edu.xtu.androidbase.weaher.ui.weather.domain.Zone;

import edu.xtu.androidbase.weaher.ui.weather.domain.CityDao;
import edu.xtu.androidbase.weaher.ui.weather.domain.ProvinceDao;
import edu.xtu.androidbase.weaher.ui.weather.domain.SelectCityDao;
import edu.xtu.androidbase.weaher.ui.weather.domain.ZoneDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cityDaoConfig;
    private final DaoConfig provinceDaoConfig;
    private final DaoConfig selectCityDaoConfig;
    private final DaoConfig zoneDaoConfig;

    private final CityDao cityDao;
    private final ProvinceDao provinceDao;
    private final SelectCityDao selectCityDao;
    private final ZoneDao zoneDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cityDaoConfig = daoConfigMap.get(CityDao.class).clone();
        cityDaoConfig.initIdentityScope(type);

        provinceDaoConfig = daoConfigMap.get(ProvinceDao.class).clone();
        provinceDaoConfig.initIdentityScope(type);

        selectCityDaoConfig = daoConfigMap.get(SelectCityDao.class).clone();
        selectCityDaoConfig.initIdentityScope(type);

        zoneDaoConfig = daoConfigMap.get(ZoneDao.class).clone();
        zoneDaoConfig.initIdentityScope(type);

        cityDao = new CityDao(cityDaoConfig, this);
        provinceDao = new ProvinceDao(provinceDaoConfig, this);
        selectCityDao = new SelectCityDao(selectCityDaoConfig, this);
        zoneDao = new ZoneDao(zoneDaoConfig, this);

        registerDao(City.class, cityDao);
        registerDao(Province.class, provinceDao);
        registerDao(SelectCity.class, selectCityDao);
        registerDao(Zone.class, zoneDao);
    }
    
    public void clear() {
        cityDaoConfig.clearIdentityScope();
        provinceDaoConfig.clearIdentityScope();
        selectCityDaoConfig.clearIdentityScope();
        zoneDaoConfig.clearIdentityScope();
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public ProvinceDao getProvinceDao() {
        return provinceDao;
    }

    public SelectCityDao getSelectCityDao() {
        return selectCityDao;
    }

    public ZoneDao getZoneDao() {
        return zoneDao;
    }

}
