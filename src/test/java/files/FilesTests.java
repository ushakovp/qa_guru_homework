package files;

import com.codeborne.pdftest.PDF;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;


public class FilesTests {

    ClassLoader cl = FilesTests.class.getClassLoader();

    @Test
    void PDFParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample.pdf")) {
            assert is != null;
            PDF pdf = new PDF(is);
            assertThat(pdf.producer).contains("Nevrona Designs");
            assertThat(pdf.numberOfPages).isEqualTo(2);
        }
    }

    @Test
    void CSVParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("addresses.csv")) {
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
    void TXTParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("sample.txt")) {
            assert is != null;
            byte[] fileContent = is.readAllBytes();
            String asString = new String(fileContent, UTF_8);
            assertThat(asString).contains("TestData1");
            assertThat(asString).contains("TestData2");
        }
    }

    @Test
    void ZipParseTest() {
    }
}
