package Otp.OtpService.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mpesa.otp")
public class OtpConfiguration {
    private String apiKey;
    private String username;
    private String sender_id;
    private String smsurl;
    private String message;
}
