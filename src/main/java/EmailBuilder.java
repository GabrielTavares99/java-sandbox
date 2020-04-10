import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class EmailBuilder {
    private String to;
    private String html;
    private Long subject;
    private List<String> attachments;
    private Map<String, String> params;
}
