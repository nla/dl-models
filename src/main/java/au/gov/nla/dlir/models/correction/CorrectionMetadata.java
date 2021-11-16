package au.gov.nla.dlir.models.correction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CorrectionMetadata {
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
}
