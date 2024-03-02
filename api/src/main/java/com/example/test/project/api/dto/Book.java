package com.example.test.project.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Book {

    private UUID id;

    private String name;

    private String summary;
}
