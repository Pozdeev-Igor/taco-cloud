package tacos.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Error serializing object", e);
        }
        return result;
    }
}
