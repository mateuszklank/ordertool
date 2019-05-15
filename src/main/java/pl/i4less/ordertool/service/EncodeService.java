package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.i4less.ordertool.logback.Logging;

import java.net.URLEncoder;

@Component
@Service
public class EncodeService {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public String encodeValue(String value) {
        try {
            //URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
            value = URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            logger.error("Error encoding parameter {}", e.getMessage(), e);
        }
        return value;
    }

}