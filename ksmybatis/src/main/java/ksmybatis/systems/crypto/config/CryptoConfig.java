package ksmybatis.systems.crypto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ksmybatis.systems.crypto.utils.AesEncryptor;

@Configuration
public class CryptoConfig {

	@Value("${crypto.aes.key}")
	private String key;
	
	@Bean
    AesEncryptor aesEncryptor() {
        return new AesEncryptor(key);
    }
}
