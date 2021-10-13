package au.gov.nla.dlir.models.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payload {
  private String messageId;
  private String type;
  private String transaction;
}
