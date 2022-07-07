package com.aag.social.network.transform;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Utilidades comunes de JSON
 */
@Component
public class JsonUtils {
    private final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonUtils() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Imprime un objeto en formato Json
     * @param object Objeto por deserializar
     */
    public void logJson(Object object) {
        try {
            logger.info(mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(object));
        } catch (Exception e) {
            logger.info("Error al trasformar a cadena Json: ", e);
        }
    }

    /**
     * Serializa un objeto a formato Json
     * @param object Objeto a serializar
     * @return Cadena en formato Json
     */
    public String toJsonString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.info("Error al trasformar a Json: ", e);
            return null;
        }
    }

    /**
     * Deserializa un objeto desde formato Json
     * @param <T> Tipo de retorno esperado
     * @param jsonString Cadena en formato Json
     * @param clazz Clase del tipo de retorno
     * @return Objeto deserializado
     */
    public <T extends Object> T fromJsonString(String jsonString, Class<T> clazz) {
        try {
            if(clazz == JsonNode.class) {
                return clazz.cast(mapper.readTree(jsonString));
            } else {
                return mapper.readValue(jsonString, clazz);
            }
        } catch (Exception e) {
            logger.info("Error al trasformar a Json: ", e);
            return null;
        }
    }

    /**
     * Deserializa un objeto desde formato Json
     * @param <T> Tipo de retorno esperado
     * @param jsonString Cadena en formato Json
     * @param typeRef Referencua al tipo de retorno
     * @return Objeto deserializado
     */
    public <T extends Object> T fromJsonString(String jsonString, TypeReference<T> typeRef) {
        try {
            return mapper.readValue(jsonString, typeRef);
        } catch (Exception e) {
            logger.info("Error al trasformar a Json: ", e);
            return null;
        }
    }
    
    /**
     * Serializa un objeto a formato Json
     * @param object Objeto a serializar
     * @return Cadena en formato Json
     */
    public JSONObject toJSONObject(Object object) {
        try {
            return new JSONObject(mapper.writeValueAsString(object));
        } catch (Exception e) {
            logger.info("Error al trasformar a Json: ", e);
            return null;
        }
    }
}
