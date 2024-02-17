package com.example.test.project.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDbModelToBookDtoMapper {

    @Mapping(source = "title", target = "name")
    com.example.test.project.dto.Book map(com.example.test.project.data.Book bookDbModel);
}
