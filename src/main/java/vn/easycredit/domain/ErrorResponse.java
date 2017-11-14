package vn.easycredit.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * 
 * @author HienNT
 */

@Value
public class ErrorResponse {

    @ApiModelProperty(value = "HTTP Status")
    private Integer status;

    private ErrorInfo error;
}
