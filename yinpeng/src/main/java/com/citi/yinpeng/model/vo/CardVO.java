package com.citi.yinpeng.model.vo;

import com.citi.yinpeng.model.po.CardPO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CardVO {
    private String id;
    private String cardId;
    private String type;
    private BigDecimal maxLimit;
    private BigDecimal currentLimit;
    private BigDecimal availableLimit;
    private LocalDate requestTime;

    public static CardVO getInstance(CardPO cardPO){
        CardVO cardVO = new CardVO();
        BeanUtils.copyProperties(cardPO,cardVO);
        String cardId = cardPO.getCardId();
        String ASTERISK = "********";
        cardVO.setCardId(ASTERISK + cardId.substring(cardId.length() - 4));
        return cardVO;
    }
}
