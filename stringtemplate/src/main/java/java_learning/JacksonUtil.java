package java_learning;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JacksonUtil {
    private static ObjectMapper objectMapper;
    private static JsonFactory jsonFactory;

    static {
        objectMapper =  new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonFactory = new JsonFactory(objectMapper);
    }

    public static JsonFactory getFactory(){
        return jsonFactory;
    }

    public static  String objectToString(final Object obj) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(obj);
        return content;
    }

    public static JsonNode stringToObject(final String input) throws IOException {
        JsonNode rtn = objectMapper.readTree(input);
        return  rtn;
    }

    public static <T> T stringToObject(final String input, Class<T> clazz) throws IOException{
        T result = objectMapper.treeToValue(stringToObject(input), clazz);
        return result;
    }

    public static Map<String, Object> jsonNodeToMap(final JsonNode node){
        Map<String, Object> result = objectMapper.convertValue(node, Map.class);
        return result;
    }

    public static JsonNode valueToJsonNode(Map<String, Object> map){
        return objectMapper.valueToTree(map);
    }

    public static  String mapToString(final Map<String, Object> input) throws JsonProcessingException {
        String jsonResp = objectMapper.writeValueAsString(input);
        return  jsonResp;
    }

    public static Map<String, Object> objectToMap(final Object object){
        Map<String, Object> result = objectMapper.convertValue(object, Map.class);
        return result;
    }
}