package ru.sem.to;

/**
 * Created by Admin on 08.11.2017.
 */
public class UserAdv {

    private Integer id;

    private Integer idCustomer;

    private String nameCustomer;

    private Integer idRole;

    private String login;

    private String password;

    private String role;

    public UserAdv(){
    }

    public UserAdv(Integer id, Integer idCustomer, String nameCustomer, Integer idRole, String login,
                   String password, String role) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.idRole = idRole;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserAdv{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", idRole=" + idRole +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
}
