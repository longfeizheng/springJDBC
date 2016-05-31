package com.merryyou.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.google.common.collect.Iterables;
import com.merryyou.domain.AuthUser;
import com.merryyou.test.AbstractTransactionalSpringExtendedTest;
import com.merryyou.util.Status;
import com.merryyou.util.UUIDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:datasets/auth_user/auth_user.xml")
public class AuthUserDaoIT extends AbstractTransactionalSpringExtendedTest {

    @Autowired
    private AuthUserDao authUserDao;

    @DataProvider
    private Object[][] authUser() {
        AuthUser authUser = new AuthUser(UUIDUtils.generateStr());
        authUser.setUsername("admin");
        authUser.setPassword("admin");
        authUser.setRole(1);
        authUser.setStatus(Status.AVAILABLE);
        authUser.setCreatedTime(DateTime.now());
        return new Object[][]{{authUser}};
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/auth_user/auth_user.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFindAllSort() throws Exception {
        Iterable<AuthUser> results = authUserDao.findAll(new Sort("id"));

        assertThat(results, notNullValue());

        assertThat(Iterables.size(results), is(3));
    }

    @Test(dataProvider = "authUser")
    @ExpectedDatabase(value = "classpath:datasets/auth_user/auth_user_save.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSave(AuthUser authUser) throws Exception {
        AuthUser result = authUserDao.save(authUser);

        assertThat(result, notNullValue());
        assertThat(result.getUsername(), is(authUser.getUsername()));
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/auth_user/auth_user_delete_by_id.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testDeleteById() throws Exception {
        authUserDao.delete("1");
    }

    @Test
    @ExpectedDatabase(value = "classpath:datasets/auth_user/auth_user_update.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testUpdateSingle() throws Exception {

        AuthUser authUser = new AuthUser();
        authUser.setId("1");
        authUser.setPassword("admin");
        authUser.setRole(0);
        authUser.setStatus(Status.NOT_AVAILABLE);
        AuthUser result = authUserDao.update(authUser);
        assertThat(result, notNullValue());
    }
}