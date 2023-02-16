import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class ZipTextParsingTest {

    ClassLoader cl = ZipTextParsingTest.class.getClassLoader();

    @Test
    void zipParseTextTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("sample.zip");
                ZipInputStream zis = new ZipInputStream(resource);
                )
        {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {

            assertThat(entry.getName()).contains("sample.text");

            }

        }
    }
}
