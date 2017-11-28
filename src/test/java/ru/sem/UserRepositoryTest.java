package ru.sem;

/**
 * Created by Admin on 28.11.2017.
 */

import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sem.model.Role;
import ru.sem.model.User;
import ru.sem.repository.UserRepository;

import java.util.Arrays;


public class UserRepositoryTest {

    private static ConfigurableApplicationContext appCtx;
    private UserRepository repository;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        //controller = appCtx.getBean(AdminRestController.class);
    }

    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }

    @Before
    public void setUp() throws Exception {
        // Re-initialize
        repository = appCtx.getBean(UserRepository.class);
        /*repository.getAll().forEach(u -> repository.delete(u.getId()));
        repository.save(USER);
        repository.save(ADMIN);*/
    }

    @Test
    public void testNotFound(){
        User user = repository.get(-1);
        Assert.assertEquals(user, null);
    }


    @Test
    public void createAndDelete(){
        User user = new User();
        user.setCustomer(null);
        user.setLogin("dddddd");
        user.setPass("dfdfdfdf");
        user.setRole(Role.ROLE_MANAGER);
        Integer id = repository.save(user).getId();
        Assert.assertNotEquals(id, null);
        Assert.assertEquals(repository.delete(id), true);
    }
}
