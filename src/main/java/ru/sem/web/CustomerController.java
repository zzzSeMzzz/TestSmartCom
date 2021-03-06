package ru.sem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.sem.model.*;
import ru.sem.service.BasketService;
import ru.sem.service.OrderItemService;
import ru.sem.service.OrderService;
import ru.sem.to.SimpleBasketItem;
import ru.sem.to.SimpleOrder;

import java.util.Calendar;
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

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @RequestMapping(value="/main/addtobasket/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BasketItem addItemToBasket(@RequestParam("id") int id){
        log.info("addItemToBasket id_item="+id);
        return basketService.addItemToCustomer(getUserDetails().getCustomerId(), id);
    }

    @RequestMapping(value="/main/getbasket/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SimpleBasketItem> getMyBasket(){
        return basketService.getMyBasketSimpleItems(getUserDetails().getCustomerId());
    }

    @RequestMapping(value = "/main/delbasketitem/", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delBasketItem(@RequestBody SimpleBasketItem simpleBasketItem){
        return basketService.delete(simpleBasketItem.getId());
    }

    @RequestMapping(value = "/main/createorder/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SimpleOrder createOrder(@RequestBody SimpleOrder simpleOrder) {
        log.info("try create order "+simpleOrder);
        Orderm order = new Orderm();
        //order.setId(simpleOrder.getId());//null - is New
        Customer customer = new Customer();
        customer.setId(getUserDetails().getCustomerId());
        order.setCustomer(customer);
        order.setStatus(simpleOrder.getStatus());
        order.setOrderDate(simpleOrder.getOrderDate());
        order.setOrderNumber(simpleOrder.getOrderNumber());
        order = orderService.save(order);
        if(order!=null){
            int orderId = order.getId();
            //если заказа создан успешно, то
            //создаем order_item's
            //и очищаем корзину
            basketService.getByCustomerId(getUserDetails().getCustomerId())
                    .stream().forEach(basketItem -> orderItemService.createFromBasketItem(basketItem, orderId));

            basketService.deleteAllMy(getUserDetails().getCustomerId());
            return simpleOrder;
        }else return null;
    }

    @RequestMapping(value="/main/getorders/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SimpleOrder> getOrders(){
        if(getUserDetails().getRole()== Role.ROLE_CUSTOMER) {
            return orderService.getMyOrderSimple(getUserDetails().getCustomerId());
        }else{
            return orderService.getAllOrderSimple();
        }
    }

    @RequestMapping(value="/main/delorder/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean delOrders(@RequestBody SimpleOrder simpleOrder){
        return orderService.delete(simpleOrder.getId());
    }

    @RequestMapping(value="/main/updorder/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Orderm updateOrders(@RequestBody SimpleOrder simpleOrder){
        return orderService.save(simpleOrder);
    }
}
