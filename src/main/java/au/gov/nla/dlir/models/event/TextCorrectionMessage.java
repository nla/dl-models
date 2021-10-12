package au.gov.nla.dlir.models.event;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TextCorrectionMessage extends Payload {
  private String objId;
  private String copyId;
  private List<Correction> corrections;
}
