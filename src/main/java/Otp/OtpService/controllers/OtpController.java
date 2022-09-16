package Otp.OtpService.controllers;


import Otp.OtpService.dtos.OtpRequest;
import Otp.OtpService.dtos.SendMoneyResponse;
import Otp.OtpService.dtos.SmsResponse;
import Otp.OtpService.dtos.ValidateOtp;
import Otp.OtpService.services.otpApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("otp")
@Slf4j
public class OtpController {

    private final otpApi otpApi;
    private final ObjectMapper objectMapper;

    public OtpController(otpApi otpApi, ObjectMapper objectMapper) {
        this.otpApi = otpApi;
        this.objectMapper = objectMapper;
    }

    @PostMapping(path = "/request" , produces = "application/json")
    public ResponseEntity<List<SmsResponse>> getOtp(@RequestBody OtpRequest otpRequest){
        System.out.println("controller");
        List<SmsResponse> res = otpApi.getOtp(otpRequest);
    return ResponseEntity.ok().body(res);
   }

   @PostMapping(path = "/otpvalidate", produces = "application/json")
    public ResponseEntity<SendMoneyResponse>validate(@RequestBody ValidateOtp validateOtp){
       otpApi.validateOtp(validateOtp);
        return ResponseEntity.ok().build();
    }
   }
