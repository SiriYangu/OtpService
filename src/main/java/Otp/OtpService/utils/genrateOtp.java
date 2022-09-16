package Otp.OtpService.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class genrateOtp {
   public static char[] GenerateOtp(int len){
       log.info("generating otp");
       String numbers = "0123456789";
       Random rndm_method = new Random();
       char [] otp = new char[len];
       for(int i = 0;i<len;i++){
           otp[i]= numbers.charAt(rndm_method.nextInt(numbers.length()));
       }
       return otp;
   }

   public static String toJson(Object object){
       try{
           return new ObjectMapper().writeValueAsString(object);
       } catch (JsonProcessingException exception) {
           throw new RuntimeException(exception);
       }
   }

}
