package Dataverse.DataverseJSONFieldClasses.Fields.DataverseJSONGeoFieldClasses;

import Dataverse.DataverseJSONFieldClasses.CompoundJSONField;
import Dataverse.FindingBoundingBoxes.Countries;
import Dataverse.FindingBoundingBoxes.LocationTypes.BoundingBox;
import Dataverse.FindingBoundingBoxes.LocationTypes.City;
import Dataverse.FindingBoundingBoxes.LocationTypes.Country;
import Dataverse.FindingBoundingBoxes.LocationTypes.Province;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static Dataverse.DVFieldNameStrings.*;

public class GeographicCoverage extends CompoundJSONField {
    private String givenCountry, givenProvince, givenCity, otherGeographicCoverage, doi, commonCountry, commonProvince, commonCity;
    private Country countryObject;
    private Province provinceObject;
    private City cityObject;


    public GeographicCoverage(String doi) {
        this.doi = doi;
        this.givenCountry = "";
        this.givenProvince = "";
        this.givenCity = "";
        this.otherGeographicCoverage = "";
        this.commonCountry = "";
        this.commonProvince = "";
        this.commonCity = "";
        this.countryObject = new Country();

    }

    public Country getCountryObject(){
        return countryObject;
    }

    public Province getProvinceObject(){
        return provinceObject;
    }

    public City getCityObject(){
        return cityObject;
    }

    public void setGivenCountry(String givenCountry) {
        this.givenCountry = givenCountry;
        countryObject = Countries.getCountry().getCountryByName(givenCountry);
        commonCountry = countryObject.getGivenName();
    }

    public void setGivenProvince(String givenProvince) {
        this.givenProvince = givenProvince;
        provinceObject =  new Province(this.givenProvince, givenCountry);
        commonProvince = provinceObject.getGivenName();
    }

    public void setGivenCity(String givenCity) {
        this.givenCity = givenCity;
        cityObject = new City(this.givenCity, givenProvince, givenCountry);
        commonCity = cityObject.getGivenName();
    }



    @Override
    public void setField(JSONObject field) {
        for(String s:field.keySet()){
            JSONObject fieldTitle = (JSONObject) field.get(s);
            String title = fieldTitle.getString(TYPE_NAME);
            String value = fieldTitle.getString(VAL);
            switch (title) {
                case COUNTRY:
                    setGivenCountry(value);
                    break;
                case PROVINCE:
                case STATE:
                    setGivenProvince(value);
                    break;
                case CITY:
                    setGivenCity(value);
                    break;
                case OTHER_GEO_COV:
                    this.otherGeographicCoverage = value;
                    break;
                default:
                    errorParsing(this.getClass().getName(), title);
            }
        }
    }

    @Override
    public String getField(String fieldName) {
        switch (fieldName) {
            case GIVEN_COUNTRY:
                return givenCountry;
            case GIVEN_PROVINCE:
                return givenProvince;
            case GIVEN_CITY:
                return givenCity;
            case OTHER_GEO_COV:
                return otherGeographicCoverage;
            case COMMON_COUNTRY:
                return (commonCountry.isEmpty()? givenCountry:commonCountry);
            case COMMON_PROVINCE:
                return (commonProvince.isEmpty()? givenProvince:commonProvince);
            case COMMON_CITY:
                return (commonCity.isEmpty()? givenCity:commonCity);
            default:
                errorParsing(this.getClass().getName(), fieldName);
                return "Bad FieldName";
        }
    }

    public BoundingBox getBoundingBox(){
        if(this.cityObject!=null){
            if(cityObject.hasBoundingBox())
                return cityObject.getBoundingBox();
        }else if(provinceObject!=null){
            if(provinceObject.hasBoundingBox())
                return provinceObject.getBoundingBox();
        }else if(countryObject!=null){
            if(countryObject.hasBoundingBox())
                return countryObject.getBoundingBox();
        }
        return new BoundingBox();
    }
}
