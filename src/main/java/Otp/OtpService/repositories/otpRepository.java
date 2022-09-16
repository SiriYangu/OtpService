package Otp.OtpService.repositories;

import Otp.OtpService.dtos.OtpFetch;
import Otp.OtpService.dtos.OtpRequest;
import Otp.OtpService.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface otpRepository extends JpaRepository<RequestModel, Integer> {

    RequestModel findByOtp(String otp);
}
