package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.ValueAnnotationBean;
import pl.i4less.ordertool.logback.Logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileService {

    private String taskDateString;

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public String getDateFromFile() {
        try {
            taskDateString = readFile(ValueAnnotationBean.getDatePath(), Charset.forName("ASCII"));
            logger.info("Date used to get orders from Backmarket: {}", taskDateString);
        } catch (IOException e) {
            logger.info("Error: {}", e);
        }
        return taskDateString;
    }

}