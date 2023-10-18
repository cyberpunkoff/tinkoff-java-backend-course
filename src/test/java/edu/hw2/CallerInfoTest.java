package edu.hw2;

import edu.hw2.callerinfo.CallingInfo;
import org.junit.jupiter.api.Test;
import static edu.hw2.callerinfo.CallerInfo.getCallingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class CallerInfoTest {
    @Test
    void callingInfoTest() {
        CallingInfo res = getCallingInfo();
        CallingInfo expected = new CallingInfo("edu.hw2.CallerInfoTest", "callingInfoTest");
        assertThat(res).isEqualTo(expected);
    }
}
