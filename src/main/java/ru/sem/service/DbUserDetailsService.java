package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.sem.model.Customer;
import ru.sem.model.IdUserDetails;
import ru.sem.model.Role;
import ru.sem.repository.UserRepository;

import java.util.Arrays;


/**
 * Created by Admin on 01.11.2017.
 */

@Component
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ru.sem.model.User activeUserInfo = service.getDataByUserName(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole().name());
        if(activeUserInfo.getRole()== Role.ROLE_CUSTOMER){
            Customer customer = activeUserInfo.getCustomer();
            if(customer==null) throw new UsernameNotFoundException("К ROLE_CUSTOMER должен быть привязан заказчик. " +
                    "Возможно заказчик был удален из БД.");
            UserDetails userDetails = new IdUserDetails(activeUserInfo.getLogin(),
                    activeUserInfo.getPass(), Arrays.asList(authority), activeUserInfo.getId(), customer.getId());
            return userDetails;
        }else {
            UserDetails userDetails = new IdUserDetails(activeUserInfo.getLogin(),
                    activeUserInfo.getPass(), Arrays.asList(authority), activeUserInfo.getId(), -1);
            return userDetails;
        }
    }
}
