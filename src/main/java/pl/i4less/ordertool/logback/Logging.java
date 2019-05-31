package pl.i4less.ordertool.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.controller.OrderController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Logging {

    @Autowired
    OrderController orderController;

    //private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Value("${path.date}")
    private String filePath;

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    //@Scheduled(fixedRate = 5000)
//    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
//    public void executeTask() {
//        try {
//            //‘﻿%Y-%m-%d %H:%M:%S’ - date format for Back Market orders
//
//            //read data from file
//            logger.info(readFile(filePath, Charset.forName("ASCII")) + " - ostatnie wykonanie zadania.");
//
//            //get current date and convert to String
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date();
//            String dateString = dateFormat.format(date);
//            logger.info(dateString + " - data aktualna.");
//
//            //wywolanie test4
//            //orderController.getOrdersObjects();
//
//            //create and save date to file
//            File file = new File("src/main/resources/date.log");
//            FileWriter fileWriter = new FileWriter(file, false);
//            fileWriter.write(dateString);
//            fileWriter.close();
//
//            //logger.info("Task executed at {}", dateFormat.format(new Date()));
//        } catch (IOException e) {
//            logger.info("Error: {}", e);
//        }
//    }

    public static void main(String[] args) {
        logger.info("Logging log from {}", Logging.class.getSimpleName());
    }

}