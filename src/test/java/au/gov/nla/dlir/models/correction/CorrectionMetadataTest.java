package au.gov.nla.dlir.models.correction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CorrectionMetadataTest {

  private final CorrectionMetadata correctionMetadata = new CorrectionMetadata();

  @Test
  public void getCleanNullOldLines() {
    Assertions.assertNull(correctionMetadata.getCleanOldLines());
  }

  @Test
  public void getCleanOldLines() {
    correctionMetadata.setOldLines("[0,0]TTTTTTT @@||@@[0,0]HONORARY EXECUTIVE COMMITTEE: @@||@@");
    Assertions.assertEquals(
        "TTTTTTT \nHONORARY EXECUTIVE COMMITTEE: \n", correctionMetadata.getCleanOldLines());
  }

  @Test
  public void testNullUserDisplayName() {
    String displayName = correctionMetadata.getUserDisplay();

    Assertions.assertNotNull(displayName);
    Assertions.assertEquals(0, displayName.length());
  }
}
