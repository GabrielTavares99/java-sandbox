import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.TimeService;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TimeServiceTest {

    @ParameterizedTest(name = "method has {0} seconds to be execute")
    @CsvSource(value = {
            "5, 2",
            "7, 4"
    })
    @DisplayName("MUST RESOLVE BEFORE TIMEOUT")
    void performanceTest(int timeout, int timeToResolve) throws InterruptedException {
        TimeService timeService = new TimeService();
        assertTimeout(Duration.ofSeconds(timeout), () -> {
            timeService.lockMainThread(timeToResolve);
        });

    }

    @Test
    @Disabled //IGNORE
    public void disabledTest(){
        assertEquals(1, 1);
    }


}
