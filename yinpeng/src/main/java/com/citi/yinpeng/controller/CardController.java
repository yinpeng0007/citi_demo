package com.citi.yinpeng.controller;

import com.citi.yinpeng.model.form.CardModifyForm;
import com.citi.yinpeng.model.vo.CardVO;
import com.citi.yinpeng.service.ICardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@ControllerAdvice
@Slf4j
@RequestMapping(value = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {

    @Autowired
    private ICardService cardService;

    @GetMapping(value = "/list")
    public List<CardVO> getCardList() {
        return cardService.getCardVOList();
    }

    @GetMapping(value = "/{id}")
    public CardVO getCardById(@PathVariable String id) {
        return cardService.getCardById(id);
    }

    @PutMapping(value = "/{id}")
    public CardVO updateCard(@PathVariable String id, @RequestBody CardModifyForm cardModifyForm) {
        return cardService.updateCardById(id,cardModifyForm.getCurrentLimit());
    }
}
