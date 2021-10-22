package au.gov.nla.dlir.models.event;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TextCorrectionMessage extends Payload {
  public enum ArticleType {NEWSPAPER, GAZETTE, DLC;}

  private String user;
  private String objId;
  private String copyId;
  private ArticleType articleType;
  private List<Correction> corrections;
}
