package au.gov.nla.dlir.models.event;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@ToString(callSuper = true)
public class TextCorrectionMessage extends Payload {

  private static final String LINE_PREFIX = "[0,0]";
  private static final String LINE_SUFFIX = "@@||@@";

  public enum ArticleType {NEWSPAPER, GAZETTE, DLC}

  private String user;
  private String objId;
  private ArticleType articleType;
  private List<Correction> corrections;
  private String rollbackCorrectionId;
  private String form;

  public boolean isSaveCorrection() {
    return StringUtils.equalsIgnoreCase(getTransaction(), "Save");
  }

  public String getFormattedOldLines() {
    return corrections != null ? corrections.stream().map(c -> formatLine(c.getOldText())).collect(Collectors.joining()) : null;
  }

  public String getFormattedNewLines() {
    return corrections != null ? corrections.stream().map(c -> formatLine(c.getCorrectedText())).collect(Collectors.joining()) : null;
  }

  private String formatLine(final String line) {
    return Optional.ofNullable(line)
            .map(s -> String.format("%s%s%s", LINE_PREFIX, s, LINE_SUFFIX))
            .orElse(StringUtils.EMPTY);
  }
}
