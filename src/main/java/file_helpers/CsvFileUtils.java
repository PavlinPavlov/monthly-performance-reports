package file_helpers;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import models.CsvEmpModel;
import models.CsvEmpModelFormat;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvFileUtils {
    private static final String FILEPATH = "src/main/resources/";
    private static final String FILE_EXTENSION = ".csv";

    public static void writeResults(String filename, List<CsvEmpModel> employees) {
        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        mapper.addMixIn(CsvEmpModel.class, CsvEmpModelFormat.class);
        CsvSchema schema = mapper.schemaFor(CsvEmpModel.class).withHeader();

        ObjectWriter writer = mapper.writer(schema.withLineSeparator("\n"));
        try {
            writer.writeValue(new File(FILEPATH + filename + FILE_EXTENSION), employees);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception while Writing full CSV report. Details: " + e);
        }
    }

}
