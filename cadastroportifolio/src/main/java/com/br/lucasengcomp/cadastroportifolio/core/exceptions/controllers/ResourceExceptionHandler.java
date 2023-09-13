package com.br.lucasengcomp.cadastroportifolio.core.exceptions.controllers;


import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ConstraintViolationExceptionDatabase;
import com.br.lucasengcomp.cadastroportifolio.core.exceptions.services.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.EXCECAO_DE_BANCO_DE_DADOS_VIOLATION;
import static com.br.lucasengcomp.cadastroportifolio.core.utils.UtilsMensagemPadrao.RECURSO_NAO_ENCONTRADO;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> erroRecursoNaoEncontrado(ResourceNotFoundException e,
                                                                  HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        mensagemErroPadrao(error, status, RECURSO_NAO_ENCONTRADO, e.getMessage(), request);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ConstraintViolationExceptionDatabase.class)
    public ResponseEntity<StandardError> violationException(ConstraintViolationExceptionDatabase e, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus status = mensagemErroHttp(request, error, HttpStatus.INTERNAL_SERVER_ERROR,
                EXCECAO_DE_BANCO_DE_DADOS_VIOLATION, e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    private HttpStatus mensagemErroHttp(HttpServletRequest request, StandardError error,
                                        HttpStatus badRequest, String databaseException, String message) {
        HttpStatus status = badRequest;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(databaseException);
        error.setMessage(message);
        error.setPath(request.getRequestURI());
        return status;
    }

    private void mensagemErroPadrao(StandardError error, HttpStatus status, String databaseException,
                                    String e, HttpServletRequest request) {
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(databaseException);
        error.setPath(request.getRequestURI());
        error.setMessage(e);
    }
}
