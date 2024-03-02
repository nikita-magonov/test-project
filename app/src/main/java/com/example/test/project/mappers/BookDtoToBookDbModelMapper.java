package com.example.test.project.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookDtoToBookDbModelMapper {

    @Mapping(source = "name", target = "title")
    com.example.test.project.data.Book map(com.example.test.project.api.dto.Book bookDto);
}
