package ru.sem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.sem.model.BasketItem;
import ru.sem.model.IdUserDetails;
import ru.sem.service.BasketService;
import ru.sem.to.SimpleBasketItem;
import ru.sem.to.UserAdv;

import java.util.List;


/**
 * Created by Admin on 16.11.2017.
 */
@Controller
public class CustomerController {


    private static final Logger log = LoggerFactory.getLogger("CustomerController");

    private IdUserDetails idUserDetails;

    public IdUserDetails getUserDetails(){
        if(idUserDetails==null){
            idUserDetails = (IdUserDetails)
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return idUserDetails;
    }



    @Autowired
    BasketService basketService;

    @RequestMapping(value="/main/addtobasket/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BasketItem addItemToBasket(@RequestParam("id") int id){
        log.info("addItemToBasket id_item="+id);
        return basketService.addItemToCustomer(getUserDetails().getUserId(), id);
    }

    @RequestMapping(value="/main/getbasket/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SimpleBasketItem> getMyBasket(){
        return basketService.getMyBasketSimpleItems(getUserDetails().getUserId());
    }

    @RequestMapping(value = "/main/delbasketitem/", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delBasketItem(@RequestBody SimpleBasketItem simpleBasketItem){
        return basketService.delete(simpleBasketItem.getId());
    }
}
