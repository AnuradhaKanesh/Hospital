import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class Patient {
    private String name;
    private boolean isFromOutsideLocation;
    private LocalDate OPDate;
}
