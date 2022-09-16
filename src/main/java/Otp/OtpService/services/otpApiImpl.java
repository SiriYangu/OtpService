package Otp.OtpService.services;

import Otp.OtpService.Constants;
import Otp.OtpService.config.OtpConfiguration;
import Otp.OtpService.dtos.*;
import Otp.OtpService.models.RequestModel;
import Otp.OtpService.repositories.otpRepository;
import Otp.OtpService.utils.genrateOtp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class otpApiImpl implements otpApi {

    private final OtpConfiguration otpConfiguration;
    private final OkHttpClient okHttpClient;
    private final otpRepository otpRepository;

    private final ObjectMapper objectMapper;

    public otpApiImpl(OtpConfiguration otpConfiguration, OkHttpClient okHttpClient, Otp.OtpService.repositories.otpRepository otpRepository, ObjectMapper objectMapper) {
        this.otpConfiguration = otpConfiguration;
        this.okHttpClient = okHttpClient;
        this.otpRepository = otpRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<SmsResponse> getOtp(OtpRequest otpRequest) {
        log.info("otp implementation");
        String otp = String.valueOf(genrateOtp.GenerateOtp(4));
        final String mesage = String.format("Siriyangu otp:%s",otp);
        RequestModel requestModel = new RequestModel();
        requestModel.setOtp(otp);
        requestModel.setAmount(otpRequest.getAmount());
        requestModel.setAccountReference(otpRequest.getAccountReference());
        requestModel.setTransactionDesc(otpRequest.getTransactionDesc());
        requestModel.setConvenienceFee(otpRequest.getConvenienceFee());
        requestModel.setPhoneNumber(otpRequest.getPhoneNumber());

        otpSend send = new otpSend();
        send.setApi_key(otpConfiguration.getApiKey());
        send.setMessage(mesage);
        send.setUsername(otpConfiguration.getUsername());
        send.setPhone(otpRequest.getPhoneNumber());
        send.setSender_id(otpConfiguration.getSender_id());

        RequestBody body = RequestBody.create(Constants.JSON_MEDIA_TYPE, Objects.requireNonNull(genrateOtp.toJson(send)));
        Request request = new Request.Builder()
                .url(otpConfiguration.getSmsurl())
                .post(body)
                .build();
        try{
            Response response = okHttpClient.newCall(request).execute();
            String content = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            otpRepository.save(requestModel);
            return mapper.readValue(content, new TypeReference<List<SmsResponse>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public SendMoneyResponse validateOtp(ValidateOtp validateOtp) {
        String otp = validateOtp.getOtp();
        RequestModel requestModel= otpRepository.findByOtp(otp);

        System.out.println(requestModel.getAmount());
        return null;
    }
}
