package au.gov.nla.dlir.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LegacyUsernameUtilsTest {
    @Test
    public void usernameIsNull() {
        Assertions.assertNull(LegacyUsernameUtils.getLegacyUsername(null));
    }

    @Test
    public void usernameContainsUserColon() {
        Assertions.assertEquals("user:gru", LegacyUsernameUtils.getLegacyUsername("user:gru"));
    }

    @Test
    public void usernameContainsStaff() {
        Assertions.assertEquals("user:gru", LegacyUsernameUtils.getLegacyUsername("staff:gru"));
    }

    @Test
    public void usernameNotContainStaff() {
        Assertions.assertEquals("user:public:gru", LegacyUsernameUtils.getLegacyUsername("gru"));
    }
}
