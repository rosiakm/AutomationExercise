package api.builders;

import api.utils.Parameters;
import ui.helpers.ConfigLoader;

public class RequestBuilder {
    public static Parameters setParameters(String basePath){
        return Parameters.builder()
                .BASE_URI(ConfigLoader.get("baseApiUrl"))
                .BASE_PATH(basePath)
                .CONTENT_TYPE(ConfigLoader.get("content_type"))
                .build();
    }
}
