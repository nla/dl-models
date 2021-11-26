package au.gov.nla.dlir.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsernameUtilsTest {
  @Test
  public void convertToLegacyUsername() {
    assertEquals(UsernameUtils.ANONYMOUS, UsernameUtils.convertToLegacyUsername(""));
    assertEquals(UsernameUtils.ANONYMOUS, UsernameUtils.convertToLegacyUsername(null));
    assertEquals("user:public:gru001", UsernameUtils.convertToLegacyUsername("gru001"));
    assertEquals("user:public:gru001", UsernameUtils.convertToLegacyUsername("user:public:gru001"));
    assertEquals("user:msun", UsernameUtils.convertToLegacyUsername("staff:msun"));
    assertEquals("user:msun", UsernameUtils.convertToLegacyUsername("user:msun"));
  }

  @Test
  public void getDisplayUsername() {
    assertEquals(UsernameUtils.ANONYMOUS_DISPLAY, UsernameUtils.getDisplayUsername(UsernameUtils.ANONYMOUS));
    assertEquals("gru001", UsernameUtils.getDisplayUsername("user:public:gru001"));
    assertEquals("msun", UsernameUtils.getDisplayUsername("user:msun"));
    assertEquals("msun", UsernameUtils.getDisplayUsername("staff:msun"));
    assertEquals("msun", UsernameUtils.getDisplayUsername("msun"));
  }
}
