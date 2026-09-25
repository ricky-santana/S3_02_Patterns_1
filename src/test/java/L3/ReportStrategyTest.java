package L3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReportStrategyTest {
    ReportStrategy reportStrategy;
    String reportContent = "Report_Example";

    @Test
    void ShouldConvertOnHTMLFormat(){
        reportStrategy = ReportStrategy.HTMl();
        String expected = reportContent + ".HTML";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }
    @Test
    void ShouldConvertOnJSONFormat() {
        reportStrategy = ReportStrategy.json();
        String expected = reportContent + ".JSON";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }

    @Test
    void ShouldConvertOnCSVFormat() {
        reportStrategy = ReportStrategy.csv();
        String expected = reportContent + ".CSV";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }

    @Test
    void ShouldConvertOnXMLFormat() {
        reportStrategy = ReportStrategy.xml();
        String expected = reportContent + ".XML";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }

    @Test
    void ShouldConvertOnPDFFormat() {
        reportStrategy = ReportStrategy.pdf();
        String expected = reportContent + ".PDF";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }

    @Test
    void ShouldConvertOnWordFormat() {
        reportStrategy = ReportStrategy.word();
        String expected = reportContent + ".WORD";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }

    @Test
    void ShouldConvertOnExcelFormat() {
        reportStrategy = ReportStrategy.excel();
        String expected = reportContent + ".EXCEL";
        assertEquals(expected, reportStrategy.generate(reportContent));
    }
}
