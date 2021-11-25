package au.gov.nla.dlir.models.correction;

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
}
