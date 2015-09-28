package com.merryyou.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.google.common.collect.Iterables;
import com.merryyou.domain.User;
import com.merryyou.test.AbstractTransactionalSpringExtendedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:datasets/user/user.xml")
public class UserDaoIT extends AbstractTransactionalSpringExtendedTest {

    @Autowired
    private UserDao userDao;

    @DataProvider
    private Object[][] user() {
        User user = new User();
        user.setFirstName("麻溜");
        user.setLastName("admin");
        user.setGender("fa");
        user.setCity("chang");
        return new Object[][]{{user}};
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllSort() throws Exception {
        Iterable<User> results = userDao.findAll(new Sort("id"));

        assertThat(results, notNullValue());
        assertThat(Iterables.size(results), is(3));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllPageable() throws Exception {
        Page<User> results = userDao.findAll(new PageRequest(0, 1, new Sort("id")));
        assertThat(results, notNullValue());
        assertThat(Iterables.size(results), is(1));

        User user = results.iterator().next();
        assertThat(user, notNullValue());
        assertThat(user.getId(), is(1));


        results = userDao.findAll(new PageRequest(1, 2, new Sort("id")));
        assertThat(results, notNullValue());
        assertThat(Iterables.size(results), is(1));

        user = results.iterator().next();
        assertThat(user, notNullValue());
        assertThat(user.getId(), is(3));
    }

    @Test(dataProvider = "user")
    @ExpectedDatabase(value = "classpath:datasets/user/user_save.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSave(User user) throws Exception {
        User result = userDao.save(user);

        assertThat(result, notNullValue());
        assertThat(result.getFirstName(), is(user.getFirstName()));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindOne() throws Exception {
        User result = userDao.findOne(1);

        assertThat(result, notNullValue());
        assertThat(result.getFirstName(), is("张三"));
        assertThat(result.getLastName(), is("张"));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testExists() throws Exception {
        Boolean flag = userDao.exists(1);
        assertThat(flag, is(true));

        flag = userDao.exists(4);
        assertThat(flag, is(false));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAll() throws Exception {
        Iterable<User> results = userDao.findAll();

        assertThat(results, notNullValue());
        assertThat(Iterables.size(results), is(3));

        results.forEach(user -> {
            Integer id = user.getId();
            assertThat(id, isIn(new Integer[]{
                    1,
                    2,
                    3
            }));
        });
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testCount() throws Exception {
        Long count = userDao.count();
        assertThat(count, is(3L));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user_delete_by_id.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testDeleteById() throws Exception {
        userDao.delete(1);
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/user/user_update.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testUpdateSingle() throws Exception {

        User user = new User();
        user.setId(1);
        user.setFirstName("张");
        User result = userDao.update(user);
        assertThat(result, notNullValue());
    }
}