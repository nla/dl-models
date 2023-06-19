package au.gov.nla.dlir.models.event;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TextCorrectionMessageTest {

  private final TextCorrectionMessage textCorrectionMessage = new TextCorrectionMessage();
  private final Correction correction1 = new Correction();
  private final Correction correction2 = new Correction();
  private final Correction correction3 = new Correction();

  @Test
  public void getFormattedOldLines() {
    correction1.setOldText("");
    correction2.setOldText("changed line");
    correction3.setOldText("deleted line");
    textCorrectionMessage.setCorrections(Arrays.asList(correction1, correction2, correction3));
    Assertions.assertEquals("[0,0]@@||@@[0,0]changed line@@||@@[0,0]deleted line@@||@@", textCorrectionMessage.getFormattedOldLines());
  }

  @Test
  public void getFormattedOldLinesNullCorrection() {
    Assertions.assertNull(textCorrectionMessage.getFormattedOldLines());
  }

  @Test
  public void getFormattedNullOldLines() {
    correction1.setOldText(null);
    textCorrectionMessage.setCorrections(Arrays.asList(correction1));
    Assertions.assertEquals("", textCorrectionMessage.getFormattedOldLines());
  }


  @Test
  public void getFormattedNewLines() {
    correction1.setCorrectedText("");
    correction2.setCorrectedText("changed line");
    correction3.setCorrectedText("deleted line");
    textCorrectionMessage.setCorrections(Arrays.asList(correction1, correction2, correction3));
    Assertions.assertEquals("[0,0]@@||@@[0,0]changed line@@||@@[0,0]deleted line@@||@@", textCorrectionMessage.getFormattedNewLines());
  }

  @Test
  public void getFormattedNewLinesNullCorrections() {
    Assertions.assertNull(textCorrectionMessage.getFormattedNewLines());
  }

  @Test
  public void getFormattedNullNewLines() {
    correction1.setCorrectedText(null);
    textCorrectionMessage.setCorrections(Arrays.asList(correction1));
    Assertions.assertEquals("", textCorrectionMessage.getFormattedNewLines());
  }

}
