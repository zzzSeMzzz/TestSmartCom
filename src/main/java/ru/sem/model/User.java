package ru.sem.model;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created by Admin on 27.10.2017.
 */

@NamedQueries({

        @NamedQuery(name = User.GET_ALL,
                query = "SELECT u FROM User u"),
        @NamedQuery(name = User.DELETE,
                query = "DELETE FROM User u WHERE u.id=:id"),

})

@Entity
@Table(name = "users")
public class User {

    public static final String GET_ALL = "User.getAll";
    public static final String DELETE = "User.delete";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String pass;

    @Column(name = "id_role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_customer")
    @NotFound(action = NotFoundAction.IGNORE)
    private Customer customer;

    public boolean isNew(){
        return getId() == null;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                ", customer=" + customer +
                '}';
    }
}
