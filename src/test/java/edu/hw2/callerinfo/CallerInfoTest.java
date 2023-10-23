package edu.hw2.callerinfo;

import org.junit.jupiter.api.Test;
import static edu.hw2.callerinfo.CallerInfo.getCallingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class CallerInfoTest {
    @Test
    void callingInfoTest() {
        CallingInfo res = getCallingInfo();
        CallingInfo expected = new CallingInfo("edu.hw2.callerinfo.CallerInfoTest", "callingInfoTest");
        assertThat(res).isEqualTo(expected);
    }
}
