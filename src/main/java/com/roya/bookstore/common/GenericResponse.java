package com.roya.bookstore.common;

import com.roya.bookstore.enums.ResponseStatus;
import com.roya.bookstore.enums.Source;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericResponse {
    private Source source;
    private ResponseStatus responseStatus;
    private Object responseBody;

}
