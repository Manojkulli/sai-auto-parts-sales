package com.sai.automobiles.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
public class ResponseDto {

    private int statusCode;
    private String message;
    private Object responseBody;
    private String errorMessage;



}
