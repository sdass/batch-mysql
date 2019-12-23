package com.subra.batchmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sdass on 12/19/2019.
 */
@Service
public class BetsPromoService {
    @Autowired
    private BetsPromoRepository repo;

    public List<BetsPromo> getBetsPromoByEmail(String email){
         List<BetsPromo> lse =  repo.findByEmail(email);
         return  lse;
    }

    public List<BetsPromo> getBetsPromoAll(){
        List<BetsPromo> ls = repo.findAll();
        return ls;
    }
}
