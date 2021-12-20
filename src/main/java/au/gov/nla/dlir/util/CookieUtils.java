package au.gov.nla.dlir.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

  private static final String LOCALHOST_DOMAIN = "localhost";
  private static final String NLA_DOMAIN = "nla.gov.au";

  private CookieUtils() {}

  public static void addCookie(
      final HttpServletResponse response,
      final String name,
      final String value,
      final boolean isLocal) {
    final Cookie cookie = new Cookie(name, value);
    cookie.setDomain(isLocal ? LOCALHOST_DOMAIN : NLA_DOMAIN);
    cookie.setMaxAge(-1);
    cookie.setPath("/");
    response.addCookie(cookie);
  }

  public static final void deleteCookie(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final String cookieName,
      final boolean isLocal) {
    final Cookie cookie = WebUtils.getCookie(request, cookieName);
    if (cookie != null && StringUtils.equalsIgnoreCase(cookie.getName(), cookieName)) {
      cookie.setDomain(isLocal ? LOCALHOST_DOMAIN : NLA_DOMAIN);
      cookie.setValue("");
      cookie.setPath("/");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
  }

  public static final String getCookieValue(
      final HttpServletRequest request, final String cookieName) {
    final Cookie cookie = WebUtils.getCookie(request, cookieName);
    return cookie != null && StringUtils.equalsIgnoreCase(cookie.getName(), cookieName)
        ? cookie.getValue()
        : null;
  }
}
