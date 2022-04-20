package au.gov.nla.dlir.models.correction;

import au.gov.nla.dlir.util.UsernameUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
public class CorrectionMetadata {

  private static final String DELIMITER = "\\@\\@\\|\\|\\@\\@";
  private static final String SPATIAL = "^\\[\\d+,\\d+\\]";

  private long id;
  private Long articleId;
  private Long articlePartId;
  private String user;
  private String oldLines;
  private String newLines;
  private String status;
  private Long beforeId;
  private Date created;
  private Date updated;
  private String articleType;

  public String getCleanOldLines() {
    return Optional.ofNullable(oldLines).map(CorrectionMetadata::cleanText).orElse(null);
  }

  public String getCleanNewLines() {
    return Optional.ofNullable(newLines).map(CorrectionMetadata::cleanText).orElse(null);
  }

  private static String cleanText(final String input) {
    final StringBuilder sb = new StringBuilder();
    Arrays.stream(input.split(DELIMITER)).forEach(line -> sb.append(line.replaceFirst(SPATIAL, "")).append("\n"));
    return sb.toString();
  }

  public String getUserDisplay() {
    return StringUtils.isBlank(user) ? "" : UsernameUtils.getDisplayUsername(user);
  }
}
