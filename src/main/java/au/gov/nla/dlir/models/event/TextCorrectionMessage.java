package au.gov.nla.dlir.models.event;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@ToString(callSuper = true)
public class TextCorrectionMessage extends Payload {
  public enum ArticleType {NEWSPAPER, GAZETTE, DLC;}

  private String user;
  private String objId;
  private ArticleType articleType;
  private List<Correction> corrections;
  private String rollbackCorrectionId;
  private String form;

  public boolean isSaveCorrection() {
    return StringUtils.equalsIgnoreCase(getTransaction(), "Save");
  }

}
