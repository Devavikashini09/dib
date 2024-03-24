package com.dib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmailDetails {

    private String recipient;

    private String message_body;

    private String subject;

    private String attachment;
}
