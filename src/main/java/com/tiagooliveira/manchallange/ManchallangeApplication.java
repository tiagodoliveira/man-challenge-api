package com.tiagooliveira.manchallange;
import com.tiagooliveira.manchallange.tools.DatabaseValuesGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ManchallangeApplication {

    public static void main(String[] args) {

		String sqlFile ="src/main/resources/data.sql";
		String xmlFilePath = "src/main/resources/route.xml";

		DatabaseValuesGenerator.generateData(sqlFile, xmlFilePath);
		SpringApplication.run(ManchallangeApplication.class, args);
    }



}
