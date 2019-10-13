package com.citi.yinpeng.service.impl;

import com.citi.yinpeng.model.po.CardPO;
import com.citi.yinpeng.model.vo.CardVO;
import com.citi.yinpeng.service.ICardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CardServiceImpl implements ICardService {

    private Map<String,CardPO> cardMap = new ConcurrentHashMap<>();

    /**
     * init cards
     */
    @PostConstruct
    private void init() {
        CardPO cardVO = new CardPO("1", "000000005574", "Coles Rewards MasterCard", BigDecimal.valueOf(144000), BigDecimal.valueOf(140000), BigDecimal.valueOf(35400.26), LocalDate.of(2019, Month.JANUARY, 10));
        CardPO cardVO2 = new CardPO("2", "000000006674", "Roles Cewards NormalCard", BigDecimal.valueOf(256000), BigDecimal.valueOf(10000), BigDecimal.valueOf(10000), LocalDate.of(2019, Month.FEBRUARY, 10));
        cardMap.put(cardVO.getId(),cardVO);
        cardMap.put(cardVO2.getId(),cardVO2);
    }

    /**
     * get CardVO List
     * @return
     */
    @Override
    public List<CardVO> getCardVOList() {
        return cardMap.values().stream().map(CardVO::getInstance).collect(Collectors.toList());
    }

    /**
     * get Card By Id
     * @param id
     * @return
     */
    @Override
    public CardVO getCardById(String id) {
        CardPO card = cardMap.get(id);
        if (null != card) {
            return CardVO.getInstance(card);
        } else {
            log.error("card id not exists error");
            throw new RuntimeException("card id not exists error!");
        }
    }

    /**
     * update Card By Id
     * @param id
     * @param bigDecimalLimit
     * @return
     */
    @Override
    public CardVO updateCardById(String id, BigDecimal bigDecimalLimit) {
        CardPO card = cardMap.get(id);
        if (null != card) {
            BigDecimal maxLimit = card.getMaxLimit();
            // validate
            if (maxLimit.compareTo(bigDecimalLimit) < 0){
                log.error("currentLimit is bigger than maxLimit!");
                throw new RuntimeException("currentLimit is bigger than maxLimit!");
            }
            card.setCurrentLimit(bigDecimalLimit);
            card.setRequestTime(LocalDate.now());
            return CardVO.getInstance(card);
        } else {
            log.error("card id not exists error");
            throw new RuntimeException("card id not exists error!");
        }
    }

}
