package vn.easycredit.common.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;
import lombok.Value;

/**
 * @author HienNT
 *
 */
@Value
@ToString
public class ErrorInfo {
    String code;
    String text;

    @JsonCreator
    public ErrorInfo(
            @JsonProperty("code") String code,
            @JsonProperty("text") String text) {
        this.code = code;
        this.text = text;
    }
}