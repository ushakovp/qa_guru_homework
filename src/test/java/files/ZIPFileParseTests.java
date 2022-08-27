package files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipFile;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class ZIPFileParseTests {
    private static final String PATHTOZIP = "src/test/resources/sample.zip";

    @Test
    void ZipParsePDFTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File(PATHTOZIP))) {
            InputStream is = zipFile.getInputStream(zipFile.getEntry("sample.pdf"));
            assert is != null;
            PDF pdf = new PDF(is);
            assertThat(pdf.producer).contains("Nevrona Designs");
            assertThat(pdf.numberOfPages).isEqualTo(2);
        }
    }

    @Test
    void ZipParseCSVTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File(PATHTOZIP))) {
            InputStream is = zipFile.getInputStream(zipFile.getEntry("addresses.csv"));
            assert is != null;
            CSVReader csvReader = new CSVReader(new InputStreamReader(is, UTF_8));
            List<String[]> csv = csvReader.readAll();
            assertThat(csv).contains(
                    new String[]{"John", "Doe", "120 jefferson st.", "Riverside", " NJ", " 08075"},
                    new String[]{"Jack", "McGinnis", "220 hobo Av.", "Phila", " PA", "09119"},
                    new String[]{"John \"Da Man\"", "Repici", "120 Jefferson St.", "Riverside", " NJ", "08075"},
                    new String[]{"Stephen", "Tyler", "7452 Terrace \"At the Plaza\" road", "SomeTown", "SD", " 91234"},
                    new String[]{"", "Blankman", "", "SomeTown", " SD", " 00298"},
                    new String[]{"Joan \"the bone\", Anne", "Jet", "9th, at Terrace plc", "Desert City", "CO", "00123"}
            );
        }
    }

    @Test
    void ZipParseXLSTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File(PATHTOZIP))) {
            InputStream is = zipFile.getInputStream(zipFile.getEntry("file_example_XLSX_5000.xlsx"));
            assert is != null;
            XLS xls = new XLS(is);
            assertThat(xls.excel.getSheetAt(0)
                    .getRow(1)
                    .getCell(7)
                    .getNumericCellValue()
            ).isEqualTo(1562);
        }
    }
}
