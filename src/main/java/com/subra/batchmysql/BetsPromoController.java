package com.subra.batchmysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sdass on 12/19/2019.
 */
@RestController
public class BetsPromoController {

    @Autowired
    BetsPromoService service;

    Logger log = LoggerFactory.getLogger(BetsPromoController.class);

    @RequestMapping(value = "/Byemail/{email}", method = RequestMethod.GET)
    List<BetsPromo> getPromoByEmail(@PathVariable("email") String email){
       log.info("input: " + email);
        List<BetsPromo> ls = service.getBetsPromoByEmail(email);
        return ls;
    }
}
