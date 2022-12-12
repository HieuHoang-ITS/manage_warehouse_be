package com.warehouse.dto.response;

import com.warehouse.common.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private int status;

    private String message;

    private Object item;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ApiResponse ApiResponseSuccess(Object o) {
        return new ApiResponse(Constants.HTTP_CODE_200, Constants.SUCCESS, o);
    }

    public static ApiResponse ApiResponseSuccessInvalid() {
        return new ApiResponse(Constants.HTTP_CODE_400, Constants.VALIDATE_THE_FIELD);
    }

    public static ApiResponse ApiResponseSuccessNotFound(String message) {
        return new ApiResponse(Constants.HTTP_CODE_404, Constants.RECORD_NOT_FOUND_DATA, message);
    }
}
