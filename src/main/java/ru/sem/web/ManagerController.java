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
import ru.sem.model.Item;
import ru.sem.service.ItemService;

import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
@Controller
public class ManagerController {
    private static final Logger log = LoggerFactory.getLogger("application");

    @Autowired
    ItemService itemService;

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

}
