package com.scarlatti

import com.scarlatti.dao.DefaultDao
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by pc on 9/19/2017.
 */
@RunWith(SpringRunner)
@SpringBootTest
class TestDefaultDao {

    @Autowired
    DefaultDao defaultDao

    @Test
    void "insert a penguin"() {
        defaultDao.addPenguin('annie', 'annie')
    }

    @Test
    void "retrieve a penguin"() {
        println defaultDao.getPenguin('annie', 'annie')
    }
}
