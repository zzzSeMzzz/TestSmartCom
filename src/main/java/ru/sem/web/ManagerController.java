package ru.sem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sem.model.Customer;
import ru.sem.model.Item;
import ru.sem.service.CustomerService;
import ru.sem.service.ItemService;
import ru.sem.service.UserService;
import ru.sem.to.UserAdv;

import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
@Controller
public class ManagerController {
    private static final Logger log = LoggerFactory.getLogger("ManagerController");

    @Autowired
    ItemService itemService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/main/getitems", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Item> getAllItems(){
        log.debug("get all items");
        return itemService.getAll();
    }

    @RequestMapping(value = "/main/saveitem", method = RequestMethod.POST)
    @ResponseBody
    public Item createItem(@RequestBody Item item){
        log.info(item.toString());
        log.info("save item");

        return itemService.save(item);
    }

    @RequestMapping(value = "/main/delitem", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteItem(@RequestBody Item item){
        log.info(item.toString());
        log.info("del item");

        return itemService.delete(item.getId());
    }

    @RequestMapping(value="/main/getcustomers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @RequestMapping(value = "/main/savecustomer", method = RequestMethod.POST)
    @ResponseBody
    public Customer createItem(@RequestBody Customer item){
        log.info(item.toString());
        log.info("save customer");

        return customerService.save(item);
    }

    @RequestMapping(value = "/main/delcustomer", method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteCustomer(@RequestBody Customer customer){
        log.info(customer.toString());
        log.info("del customer");

        return customerService.delete(customer.getId());
    }

    @RequestMapping(value="/main/getusersadv", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserAdv> getAllUsersAdv(){
        return userService.getAllUserWithCustomerName();
    }


    @RequestMapping(value = "/main/saveuseradv", method = RequestMethod.POST)
    @ResponseBody
    public UserAdv createItem(@RequestBody UserAdv userAdv){
        log.info(userAdv.toString());
        log.info("save user");

        return userService.save(userAdv);
    }

}
