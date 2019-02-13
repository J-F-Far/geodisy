package Dataverse.DataverseJSONFieldClasses;

import Crosswalking.JSONParsing.DataverseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class JSONField {
    protected Logger logger = LogManager.getLogger(DataverseParser.class);
    /**
     * Iterates through the JSONArray calling setField on each object
     *
     * @param compoundField
     * @return
     */
    public JSONField parseCompoundData(JSONArray compoundField){
        for(Object o: compoundField){
            JSONObject field = (JSONObject) o;
            setField(field);
        }
        return this;
    }

    /**
     *
     * Each class overrides this with a version using a switch statement to
     * try to fill all the fields of its class
     *
     * @param field
     */
    protected abstract void setField(JSONObject field);
}