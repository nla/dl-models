package au.gov.nla.dlir.models.correction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CorrectionStats {

  private String yyyymm;
  private String user;
  private String correcttrans;
  private String correctlines;
  private String articleType;

}
