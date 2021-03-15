package com.credibanco.assessment.library.controller;

import com.credibanco.assessment.library.dto.ApiResponse;
import com.credibanco.assessment.library.dto.BookDto;

import org.springframework.stereotype.Component;

@Component
public class RestUtils {

    public ApiResponse validateInsertBook(BookDto bookDto) {
        String msj = "";
        Boolean isValid = true;
        if (bookDto.getTitle() == null || bookDto.getTitle().equals("")) {
            msj = "El titulo del libro es requerido.";
            isValid = false;
        } else if (bookDto.getGenre() == null) {
            msj = "El género del libro es requerido.";
            isValid = false;
        } else if (bookDto.getPagesNumber() == 0) {
            msj = "El número de páginas del libro es requerido.";
            isValid = false;
        } else if (bookDto.getAuthor() == null) {
            msj = "El autor del libro es requerido.";
            isValid = false;
        }
        ApiResponse response = new ApiResponse();
        response.setMessage(msj);
        response.setSuccess(isValid);
        return response;
    }

}
