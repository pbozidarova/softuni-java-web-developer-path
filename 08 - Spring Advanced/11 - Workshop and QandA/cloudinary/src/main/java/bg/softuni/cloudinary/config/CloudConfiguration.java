package bg.softuni.cloudinary.config;

import com.cloudinary.Cloudinary;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfiguration {

  @Value("${cloudinary.cloud-name}")
  private String cloudName;

  @Value("${cloudinary.api-key}")
  private String apiKey;

  @Value("${cloudinary.api-secret}")
  private String apiSecret;

  @Bean
  public Cloudinary cloudinary() {
    var configMap = Map.of(
        "cloud_name", cloudName,
        "api_key", apiKey,
        "api_secret", apiSecret
    );

    return new Cloudinary(configMap);
  }
}
