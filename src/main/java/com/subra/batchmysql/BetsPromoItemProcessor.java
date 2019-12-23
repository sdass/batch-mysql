package com.subra.batchmysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

/**
 * Created by sdass on 12/20/2019.
 */
public class BetsPromoItemProcessor implements ItemProcessor<BetsPromo, BetsPromo> {

    private static final Logger log = LoggerFactory.getLogger(BetsPromoItemProcessor.class);
    @Override
    public BetsPromo process(BetsPromo in) throws Exception {

        BetsPromo transformed = new BetsPromo(in.getEmail(), in.getFirstName(), in.getLastName(), in.getBetsId(), in.getState(), in.getPromoId());
        log.info("time-stamp added...");
        transformed.setSignupDate(LocalDateTime.now());

        return transformed;
    }
}
