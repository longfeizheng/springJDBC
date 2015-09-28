package com.merryyou.service.serviceimpl;

import com.merryyou.dao.UserDao;
import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Transactional信息
 * propagation:事物传播行为
 * isolation  :事物隔离级别
 * readOnly   :只读
 * rollbackFor:发生哪些异常回滚
 * noRollbackFor:发生哪些异常不回滚
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userdao;

    @Override
    public void insertData(User user) {
        userdao.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userdao.getUserList();
    }

    @Override
    public void deleteData(String id) {
        userdao.delete(Integer.parseInt(id));

    }

    @Override
    public User getUser(String id) {
        return userdao.findOne(Integer.parseInt(id));
    }

    @Override
    public void updateData(User user) {
        userdao.update(user);

    }


}
