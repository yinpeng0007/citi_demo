package com.citi.yinpeng.service;

import com.citi.yinpeng.model.vo.CardVO;

import java.math.BigDecimal;
import java.util.List;

public interface ICardService {

    List<CardVO> getCardVOList();

    CardVO getCardById(String id);

    CardVO updateCardById(String id, BigDecimal bigDecimalLimit);
}
