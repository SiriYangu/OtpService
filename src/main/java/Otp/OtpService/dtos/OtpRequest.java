package Otp.OtpService.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OtpRequest {
    @JsonProperty("Amount")
    private Long Amount;
    @JsonProperty("PhoneNumber")
    private Long PhoneNumber;
    @JsonProperty("AccountReference")
    private Long AccountReference;
    @JsonProperty("TransactionDesc")
    private String TransactionDesc;
    @JsonProperty("ConvenienceFee")
    private int ConvenienceFee;
}
