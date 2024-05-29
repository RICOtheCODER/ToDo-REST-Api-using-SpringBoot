package com.Wiley.mytodoApp.dto;

import java.time.LocalDateTime;

public record UserErrorResponseDto(LocalDateTime time,int status,String error,String message,String path) {
}
