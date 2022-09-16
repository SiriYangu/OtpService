package Otp.OtpService.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestModel {
    @Id
    @GeneratedValue
    private int id;
    private Long PhoneNumber;
    private Long AccountReference;
    private Long Amount;
    private String TransactionDesc;
    private String otp;
    private int ConvenienceFee;
}
