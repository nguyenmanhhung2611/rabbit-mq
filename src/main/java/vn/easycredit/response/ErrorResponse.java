package vn.easycredit.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import vn.easycredit.common.dto.BaseResponse;
import vn.easycredit.common.dto.InfoGroup;

/**
 * 
 * @author HienNT
 *
 */
@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorResponse extends BaseResponse {
    @JsonCreator
    public ErrorResponse(
            @JsonProperty("infoGroup") InfoGroup infoGroup) {
        super(infoGroup);
    }
}
