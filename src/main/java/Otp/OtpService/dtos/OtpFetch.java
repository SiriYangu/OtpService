package Otp.OtpService.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OtpFetch {
    private Long id;
    private Long Amount;
    private Long PhoneNumber;
    private Long AccountReference;
    private String TransactionDesc;
    private int ConvenienceFee;
    private String otp;
}
