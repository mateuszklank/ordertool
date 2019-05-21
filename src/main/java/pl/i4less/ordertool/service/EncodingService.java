package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.i4less.ordertool.logback.Logging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodingService {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static String EncodingString(String string) {
        try {
            if(string != null){
                string = URLEncoder.encode(string, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            logger.info("Error: {}", e);
        }
        return string;
    }

}