package com.merryyou.dao;


import com.merryyou.db.CustomQueryRepository;
import com.merryyou.db.UpdatableRepository;
import com.merryyou.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserDao extends CustomQueryRepository<User>,
        UpdatableRepository<User>, PagingAndSortingRepository<User, Integer> {
    public void insertData(User user);

    public List<User> getUserList();

    public void updateData(User user);

    public void deleteData(String id);

    public User getUser(String id);

}
