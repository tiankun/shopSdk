package com.redare.shop.unifyworkbench;

import com.redare.devframework.sql.db.MySqlJdbcHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author: yanggr
 * @Date: 2020/5/11 10:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class AbstractJUnitConfig {
    @Autowired
    public MySqlJdbcHelper jdbcHelper;

    @Test
    public void test1() {
        final List<Map<String, Object>> mapList = jdbcHelper.queryForListMap("SHOW TABLE STATUS from ztkt_integration_platform");
        System.out.printf(mapList.toString());


    }

}

