package vn.easycredit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.common.collect.ImmutableList;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.NormalError;
import vn.easycredit.domain.ErrorInfo;
import vn.easycredit.domain.ErrorInfo.InvalidParameter;
import vn.easycredit.domain.ErrorResponse;

/**
 * Global exception handler annotation registration for API
 * 
 * @author HienNT
 */
@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	
	/**
	 * HienNT
     * handle HttpMessageNotReadableException, include of jackson mapping
     * request body exception.
     * 
     * TODO HttpMessageNotWritableException
     * 
     * @param e
     * @return
     */

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Throwable t) {
        log.error("Internal exception", t);

        Throwable cause = t.getCause() == null ? t : t.getCause();
        String exceptionMessage = t.getMessage() == null ? cause.toString() : t.getMessage();
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, NormalError.SYSTEM_ERROR,
                exceptionMessage, ErrorInfo.Type.GENERAL);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MissingServletRequestParameterException e) {
        log.error("Missing request paramater", e);

        NormalError systemError = NormalError.INVALID_REQUEST_PARAMETERS;
        List<InvalidParameter> invalidParameters = ImmutableList
                .of(new InvalidParameter(e.getParameterName(), e.getMessage()));

        return createErrorResponse(HttpStatus.BAD_REQUEST, systemError, systemError.getErrorMessage(),
                ErrorInfo.Type.VALIDATION,
                Optional.of(invalidParameters));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException e) {
        log.error("Request parameter validation failed", e);

        NormalError systemError = NormalError.INVALID_REQUEST_PARAMETERS;

        ImmutableList.Builder<InvalidParameter> errors = ImmutableList.builder();
        e.getBindingResult().getFieldErrors()
                .forEach(fe -> errors.add(new InvalidParameter(fe.getField(), fe.getDefaultMessage())));
        e.getBindingResult().getGlobalErrors().stream()
                .forEach(ge -> errors.add(new InvalidParameter(ge.getObjectName(), ge.getDefaultMessage())));

        return createErrorResponse(HttpStatus.BAD_REQUEST, systemError, systemError.getErrorMessage(),
                ErrorInfo.Type.VALIDATION, Optional.of(errors.build()));
    }

    /**
     * handle HttpMessageNotReadableException, include of jackson mapping
     * request body exception.
     * 
     * TODO HttpMessageNotWritableException
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(HttpMessageNotReadableException e) {
        log.error("Request parameter validation failed", e);

        NormalError error = NormalError.INVALID_REQUEST_PARAMETERS;
        Throwable cause = e.getMostSpecificCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException jacksonEx = (InvalidFormatException) cause;
            String path = jacksonEx.getPathReference();
            String message = jacksonEx.getOriginalMessage();

            List<InvalidParameter> invalidParameters = ImmutableList
                    .of(new InvalidParameter(path, message));
            return createErrorResponse(
                    HttpStatus.BAD_REQUEST,
                    error, message,
                    ErrorInfo.Type.VALIDATION,
                    Optional.of(invalidParameters));
        }

        String exceptionMessage = e.getMessage() == null ? e.getCause().toString() : e.getMessage();
        return createErrorResponse(HttpStatus.BAD_REQUEST, error, exceptionMessage, ErrorInfo.Type.VALIDATION);
    }

    /**
     * Create DTO Error Response
     * 
     * @param errorInfo
     * @param request
     * @return
     */
    protected ErrorResponse createErrorResponse(HttpStatus status, NormalError normalError, String detailMessage,
            ErrorInfo.Type errorType) {
        return createErrorResponse(status, normalError, detailMessage, errorType, Optional.empty());
    }

    /**
     * Fully parameters creating DTO Error Response
     * 
     * @param hotelError
     * @param detailMessage
     * @param clazz
     * @param invalidParameters
     * @return
     */
    protected ErrorResponse createErrorResponse(HttpStatus status, NormalError normalError, String detailMessage,
            ErrorInfo.Type errorType, Optional<List<InvalidParameter>> invalidParameters) {
        ErrorInfo errorInfo = new ErrorInfo(
        		normalError.getErrorCode(),
        		normalError.getErrorMessage(),
                errorType,
                detailMessage,
                invalidParameters);
        return new ErrorResponse(status.value(), errorInfo);
    }
}