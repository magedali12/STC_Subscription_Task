package utils.datareaders;

import org.testng.annotations.DataProvider;
import utils.config.LoadProperties;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

public class DataProviderUtils {

    static String ksaDataPath = LoadProperties.KsaData;
    static String kuwaitDataPath = LoadProperties.KuwaitData;
    static String BahrainDataPath = LoadProperties.BahrainData;



    @DataProvider(name = "ksaData")
    public static Iterator<Object[]> ksaData() throws IOException {
        String filePath = ksaDataPath;
        return DataProviderUtils.getData(filePath);
    }

    @DataProvider(name = "kuwaitData")
    public static Iterator<Object[]> kuwaitData() throws IOException {
        String filePath = kuwaitDataPath;
        return DataProviderUtils.getData(filePath);
    }

    @DataProvider(name = "bahrainData")
    public static Iterator<Object[]> bahrainData() throws IOException {
        String filePath = BahrainDataPath;
        return DataProviderUtils.getData(filePath);
    }


    public static Iterator<Object[]> getData(String filePath) throws IOException {
        String lowerPath = filePath.toLowerCase(Locale.ROOT);
        if (lowerPath.endsWith(".csv")) {
            return CSVReaderUtil.readCSV(filePath);
        } else if (lowerPath.endsWith(".xlsx")) {
            return ExcelReaderUtil.readExcel(filePath);
        } else if (lowerPath.endsWith(".json")) {
            return JSONReaderUtil.readJson(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
}
