package au.gov.nla.dlir.util;

import org.junit.Assert;
import org.junit.Test;

public class LegacyUsernameUtilsTest {
    @Test
    public void usernameIsNull() {
        Assert.assertNull(LegacyUsernameUtils.getLegacyUsername(null));
    }

    @Test
    public void usernameContainsUserColon() {
        Assert.assertEquals("user:gru", LegacyUsernameUtils.getLegacyUsername("user:gru"));
    }

    @Test
    public void usernameContainsStaff() {
        Assert.assertEquals("user:gru", LegacyUsernameUtils.getLegacyUsername("staff:gru"));
    }

    @Test
    public void usernameNotContainStaff() {
        Assert.assertEquals("user:public:gru", LegacyUsernameUtils.getLegacyUsername("gru"));
    }
}
