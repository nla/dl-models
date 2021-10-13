package au.gov.nla.dlir.models.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Correction {
  private Integer lineNumber;
  private String correctedText;
  private Integer beforeLineNumber;
}
