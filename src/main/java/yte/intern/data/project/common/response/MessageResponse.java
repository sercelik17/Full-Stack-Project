package yte.intern.data.project.common.response;

public record MessageResponse(
        ResponseType responseType,
        String message
) {
}
