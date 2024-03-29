package au.gov.nla.dlir.models.correction;

import au.gov.nla.dlir.util.UsernameUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
  private String userId;
  private boolean profilePublic;
  private boolean biographyPublic;
  private boolean activityPublic;
  private boolean profileImageAvailable;

  private boolean anonymous;
  private boolean imageAvailable;

  public static UserProfile getAnonymousProfile() {
    final UserProfile userProfile = new UserProfile();
    userProfile.setUserId(UsernameUtils.ANONYMOUS);
    userProfile.setAnonymous(true);
    return userProfile;
  }

  public String getDisplayName() {
    return anonymous ? UsernameUtils.ANONYMOUS_DISPLAY : UsernameUtils.getDisplayUsername(userId);
  }

}
