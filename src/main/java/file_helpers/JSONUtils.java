package file_helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Employee;
import models.ReportDefinition;


import java.io.*;

import java.util.Arrays;
import java.util.List;

public class JSONUtils {
    private static final String FILEPATH = "src/main/resources/";
    private static final String FILE_EXTENSION = ".json";
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static List<Employee> getEmployees(String filename) throws IOException{
        Employee[] json = objectMapper.readValue(new File(FILEPATH + filename + FILE_EXTENSION), Employee[].class);
        return Arrays.asList(json);
    }


    public static ReportDefinition getReportDefinition(String filename) throws IOException {
        return objectMapper
                .readValue(new File(FILEPATH + filename + FILE_EXTENSION), ReportDefinition.class);
    }
}