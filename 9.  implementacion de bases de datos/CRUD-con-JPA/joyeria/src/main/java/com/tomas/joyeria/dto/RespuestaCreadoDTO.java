package com.tomas.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaCreadoDTO {

    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("id_joya")
    private Long idJoya;

}
