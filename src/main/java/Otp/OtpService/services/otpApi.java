package Otp.OtpService.services;

import Otp.OtpService.dtos.OtpRequest;
import Otp.OtpService.dtos.SendMoneyResponse;
import Otp.OtpService.dtos.SmsResponse;
import Otp.OtpService.dtos.ValidateOtp;

import java.util.List;

public interface otpApi {

    List<SmsResponse> getOtp(OtpRequest otpRequest);

    SendMoneyResponse validateOtp(ValidateOtp validateOtp);
}
