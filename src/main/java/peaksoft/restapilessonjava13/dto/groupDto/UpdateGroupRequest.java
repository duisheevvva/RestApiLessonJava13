package peaksoft.restapilessonjava13.dto.groupDto;

import lombok.Builder;

@Builder
public record UpdateGroupRequest(
        String groupName,
        String description
) {
}
