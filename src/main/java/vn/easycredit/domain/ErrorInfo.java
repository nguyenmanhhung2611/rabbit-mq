package vn.easycredit.domain;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * 
 * @author HienNT
 *
 */
@Value
public class ErrorInfo {

    private String code;

    private String message;

    private Type type;

    @ApiModelProperty(value = "should be a detail exception message or full stacktrace for easy debugging purpose")
    private String detailMessage;

    Optional<List<InvalidParameter>> invalidParameters;

    public ErrorInfo(String code, String message, Type type) {
        this(code, message, type, message, Optional.empty());
    }

    public ErrorInfo(String code, String message, Type type, String detailMessage) {
        this(code, message, type, detailMessage, Optional.empty());
    }

    public ErrorInfo(String code, String message, Type type, String detailMessage,
            Optional<List<InvalidParameter>> invalidParameters) {
        this.code = code;
        this.message = message;
        this.detailMessage = detailMessage;
        this.type = type;
        this.invalidParameters = invalidParameters.map(x -> ImmutableList.copyOf(x));
    }

    @Value
    @AllArgsConstructor
    public static class InvalidParameter {
        String fieldName;
        String message;
    }

    public enum Type {
        CACHE,
        VALIDATION,
        EXTERNALAPI,
        BUSINESS,
        SECURITY,
        WORKFLOW,
        PAYMENT,
        TRANSACTION,
        RESERVATION,
        GENERAL;
    }
}
