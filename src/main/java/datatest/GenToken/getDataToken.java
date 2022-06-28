package datatest.GenToken;

import actions.commons.GlobalConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;

@Data
public class getDataToken {

    public static getDataToken getDataJson() {

        String fileName = GlobalConstants.API_TEST_DATA_FOLDER + "GenToken\\GenToken.json";

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), getDataToken.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;
}
