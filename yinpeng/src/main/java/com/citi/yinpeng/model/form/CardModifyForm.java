package com.citi.yinpeng.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CardModifyForm {
    private BigDecimal currentLimit;
}
