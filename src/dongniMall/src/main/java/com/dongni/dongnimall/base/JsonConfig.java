//package com.dongni.dongnimall.base;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * JSON前后端转换器
// */
//@Configuration
//public class JsonConfig extends WebMvcConfigurationSupport {
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        simpleModule.addSerializer(Date.class, new JsonSerializer<Date>(){
//            @Override
//            public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                jsonGenerator.writeString(simpleDateFormat.format(value));
//            }
//        });
//        simpleModule.addSerializer(Timestamp.class, new JsonSerializer<Date>(){
//            @Override
//            public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                jsonGenerator.writeString(simpleDateFormat.format(value));
//            }
//        });
//        objectMapper.registerModule(simpleModule);
//        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        converters.add(jackson2HttpMessageConverter);
//    }
//}
