package com.sd75.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRes<T> {
    @Builder.Default
    private Boolean success = true;
    private String message;
    private T data;
}
