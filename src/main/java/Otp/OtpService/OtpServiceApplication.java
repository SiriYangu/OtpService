package Otp.OtpService;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OtpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpServiceApplication.class, args);


	}
	@Bean
	public OkHttpClient getOkHttpClient(){
		return new OkHttpClient();
	}
	@Bean
	public ObjectMapper getobjectMapper(){
		return new ObjectMapper();
	}



}
