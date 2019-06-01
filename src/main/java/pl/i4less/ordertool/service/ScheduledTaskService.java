package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.controller.OrderController;
import pl.i4less.ordertool.logback.Logging;

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
public class ScheduledTaskService {

    @Autowired
    OrderController orderController;

    @Value("${path.date}")
    private String filePath;

    private Date taskDate;

    private String taskDateString;

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskDateString() {
        return taskDateString;
    }

    public void setTaskDateString(String taskDateString) {
        this.taskDateString = taskDateString;
    }

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void executeTask() {
        try {
            //read data from file
            logger.info(readFile(filePath, Charset.forName("ASCII")) + " - ostatnie wykonanie zadania.");

            //get current date and convert to String
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateString = dateFormat.format(date);
            logger.info(dateString + " - data aktualna.");

            //orderController.getOrdersObjects();

            //create and save date to file
            File file = new File("src/main/resources/date.log");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(dateString);
            fileWriter.close();
        } catch (IOException e) {
            logger.info("Error: {}", e);
        }
    }

}