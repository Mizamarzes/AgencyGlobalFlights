package com.agencyglobalflights.auth.domain;

import java.sql.SQLException;

public interface UserService {

    void createUser(User user) throws SQLException;
}
