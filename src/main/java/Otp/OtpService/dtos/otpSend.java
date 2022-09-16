package Otp.OtpService.dtos;


import lombok.Data;

@Data
public class otpSend {
    private String api_key;
    private String username;
    private String sender_id;
    private String message;
    private Long phone;
}
