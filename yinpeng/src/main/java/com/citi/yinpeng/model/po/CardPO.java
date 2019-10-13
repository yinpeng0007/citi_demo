package com.citi.yinpeng.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CardPO {
    private String id;
    private String cardId;
    private String type;
    private BigDecimal maxLimit;
    private BigDecimal currentLimit;
    private BigDecimal availableLimit;
    private LocalDate requestTime;
}
