package Otp.OtpService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidateOtp {
    @JsonProperty("otp")
    public String otp;
}
