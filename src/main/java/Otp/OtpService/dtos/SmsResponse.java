package Otp.OtpService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SmsResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("response")
    private String response;
    @JsonProperty("message_id")
    private String message_id;
    @JsonProperty("recipient")
    private String recipient;
}
