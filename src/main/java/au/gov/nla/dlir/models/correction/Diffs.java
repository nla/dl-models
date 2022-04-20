package au.gov.nla.dlir.models.correction;

public class Diffs {

  private String oldVersion;
  private String newVersion;

  // required for jackson
  public Diffs() {}

  public Diffs(String oldVersion, String newVersion) {
    this.oldVersion = oldVersion;
    this.newVersion = newVersion;
  }

  public String getOldVersion() {
    return oldVersion;
  }

  public String getNewVersion() {
    return newVersion;
  }
}
