package com.bij.mymoneymanager.util;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryDto;
import com.bij.mymoneymanager.dto.singleentry.SingleEntryForCreationDto;
import com.bij.mymoneymanager.model.SingleEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.NamingConvention;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collections;

public class DTOModelMapper extends RequestResponseBodyMethodProcessor {

    private static final ModelMapper modelMapper = new ModelMapper();

    private EntityManager entityManager;

    public DTOModelMapper(ObjectMapper objectMapper, EntityManager entityManager) {
        super(Collections.singletonList(new MappingJackson2HttpMessageConverter(objectMapper)));
        this.entityManager = entityManager;
        //TIP: This is necessary as model mapper maps the id of Category to the id of single entry when mapping SingleEntryForCreationDto to SingleEntry
        modelMapper.typeMap(SingleEntryForCreationDto.class,SingleEntry.class).addMappings(mapper -> mapper.skip(SingleEntry::setId));
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(DTO.class);
    }

    @Override
    protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
        binder.validate();
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object dto = super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        Object id = getEntityId(dto);
        if (id == null) {
            System.out.println("********* id == null *************");
            System.out.println("********* dto == " + dto);
            System.out.println("********* parameter.getParameterType() == " + parameter.getParameterType());
            System.out.println("********* mapped dto == " + modelMapper.map(dto, parameter.getParameterType()));
            return modelMapper.map(dto, parameter.getParameterType());
        } else {
            System.out.println("********* id == NOT NULL *************");
            Object persistedObject = entityManager.find(parameter.getParameterType(), id);
            System.out.println("********* dto == " + dto);
            modelMapper.map(dto, persistedObject);
            return persistedObject;
        }
    }

    @Override
    protected Object readWithMessageConverters(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType) throws IOException, HttpMediaTypeNotSupportedException, HttpMessageNotReadableException {
        for (Annotation ann : parameter.getParameterAnnotations()) {
            DTO dtoType = AnnotationUtils.getAnnotation(ann, DTO.class);
            if (dtoType != null) {
                return super.readWithMessageConverters(inputMessage, parameter, dtoType.value());
            }
        }
        throw new RuntimeException();
    }

    private Object getEntityId(@NotNull Object dto) {
        System.out.println("**************** DTO : " + dto);
        for (Field field : dto.getClass().getDeclaredFields()) {
            System.out.println("**************** Field : " + field);
            if (field.getAnnotation(Id.class) != null) {
                try {
                    field.setAccessible(true);
                    System.out.println("**************** Field get (dto) : " + field.get(dto));
                    return field.get(dto);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
