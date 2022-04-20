package au.gov.nla.dlir.util;

import org.apache.commons.lang3.StringUtils;

public class LegacyUsernameUtils {
  private static final String STAFF_COLON = "staff:";
  private static final String USER_COLON = "user:";
  private static final String USER_PUBLIC_COLON = "user:public:";

  private LegacyUsernameUtils() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Legacy name is in the format of "user:msun" (staff user) or "user:public:gru001" (public user)
   */
  public static String getLegacyUsername(final String username) {
    if (username == null) {
      return null;
    }
    if (username.startsWith(USER_COLON)) {
      return username;
    }
    if (username.startsWith(STAFF_COLON)) {
      return USER_COLON + StringUtils.substringAfter(username, STAFF_COLON);
    }
    return USER_PUBLIC_COLON + username;
  }
}
