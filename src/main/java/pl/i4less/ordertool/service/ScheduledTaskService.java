package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.ValueAnnotationBean;
import pl.i4less.ordertool.logback.Logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTaskService {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

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

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

//    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
//    public void pushOrdersfromBackmarketToSystimTask() {
//        try {
//
//            //read date from file
//            taskDateString = readFile(ValueAnnotationBean.getDatePath(), Charset.forName("ASCII"));
//            logger.info("Date String after read: {}", taskDateString);
//
//            //parse date readed from file
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                logger.info("Date before parse: {}", taskDate);
//                taskDate = format.parse(taskDateString);
//            } catch (ParseException e) {
//                logger.info("Error: {}", e);
//            }
//            logger.info("Date after parse: {}", taskDate);
//
//            //get current date
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date();
//
//            //compare current date with readed date
//            int compare = taskDate.compareTo(date);
//            logger.info("Date before(-1), equal(0) or after(1) the argument Date: {}", compare);
//
//            //convert current date to String
//            String newDateString = dateFormat.format(date);
//            logger.info("New actual date: {}", newDateString);
//
//            //create and save date to file
//            File file = new File("src/main/resources/date.log");
//            FileWriter fileWriter = new FileWriter(file, false);
//            fileWriter.write(newDateString);
//            fileWriter.close();
//        } catch (IOException e) {
//            logger.info("Error: {}", e);
//        }
//    }

}