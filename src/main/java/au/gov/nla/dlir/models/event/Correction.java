package au.gov.nla.dlir.models.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Correction {

  public enum Type {
    NEW,
    CHANGED,
    DELETED;
  }

  private Type type;
  private String lineId;
  private String correctedText;
  private String oldText;
  private String afterLineId;

}
