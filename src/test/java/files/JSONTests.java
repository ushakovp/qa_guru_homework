package files;

import files.domain.Request;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import testexamples.FilesTestExamples;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONTests {

    ClassLoader cl = FilesTestExamples.class.getClassLoader();

    @Test
    void jacksonJSONTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("request.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Request request = mapper.readValue(is, Request.class);

            assertThat(request.getCitizenship()).isEqualTo("RUS");
            assertThat(request.getFl()).isTrue();
            assertThat(request.getNomer()).isEqualTo(666666);
            assertThat(request.getFiles().get(0).getFile_name()).isEqualTo("test.pdf");
        }
    }
}
