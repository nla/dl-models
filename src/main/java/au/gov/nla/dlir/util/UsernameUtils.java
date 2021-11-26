package au.gov.nla.dlir.util;

import org.apache.commons.lang3.StringUtils;

public class UsernameUtils {
  protected static final String STAFF_PREFIX = "staff:";
  protected static final String OLD_STAFF_PREFIX = "user:";
  protected static final String PUBLIC_USER_PREFIX = "user:public:";
  protected static final String ANONYMOUS = "*anon*";
  protected static final String ANONYMOUS_DISPLAY = "Anonymous";

  private UsernameUtils() {}

  public static String convertToLegacyUsername(final String user) {
    if (StringUtils.isBlank(user)) {
      return ANONYMOUS;
    }
    if (user.startsWith(OLD_STAFF_PREFIX)) {
      return user;
    }
    if (user.startsWith(STAFF_PREFIX)) {
      return user.replace(STAFF_PREFIX, OLD_STAFF_PREFIX);
    }
    return PUBLIC_USER_PREFIX + user;
  }

  public static String getDisplayUsername(final String user) {
    if (user.startsWith(PUBLIC_USER_PREFIX)) {
      return user.substring(PUBLIC_USER_PREFIX.length());
    }
    if (user.startsWith(OLD_STAFF_PREFIX)) {
      return user.substring(OLD_STAFF_PREFIX.length());
    }
    if (user.startsWith(STAFF_PREFIX)) {
      return user.substring(STAFF_PREFIX.length());
    }
    if (StringUtils.equalsIgnoreCase(user, ANONYMOUS)) {
      return ANONYMOUS_DISPLAY;
    }
    return user;
  }
}
