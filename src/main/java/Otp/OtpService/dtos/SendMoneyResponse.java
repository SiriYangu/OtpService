package Otp.OtpService.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendMoneyResponse {

    @JsonProperty("response_code")
    private String response_code;
    @JsonProperty("response")
    private String response;

}

