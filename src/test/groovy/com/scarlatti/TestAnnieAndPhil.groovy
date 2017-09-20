package com.scarlatti

import com.scarlatti.dao.AnnieDao
import com.scarlatti.dao.PhilDao
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * Created by pc on 9/19/2017.
 */
@SpringBootTest
class TestAnnieAndPhil extends Specification {

    @Autowired
    AnnieDao annieDao

    @Autowired
    PhilDao philDao

    @Test
    "Annie can insert a penguin"() {
        expect:
        annieDao.addPenguin('annie', 'annie')
    }

    @Test
    "Phil cannot insert a penguin"() {
        when:
            philDao.addPenguin('phil', 'phillie')
        then:
            thrown(Exception)
    }

    @Test
    "Annie can retrieve a penguin"() {
        expect:
        println """Annie retrieved a penguin: ${
            annieDao.getPenguin('annie', 'annie')}"""
    }

    @Test
    "Phil can retrieve a penguin"() {
        expect:
        println """Phil retrieved a penguin: ${
            philDao.getPenguin('annie', 'annie')}"""
    }

    @Test
    "Annie cannot delete the penguins"() {
        when:
            annieDao.deletePenguins()
        then:
            Exception e = thrown()
            e.printStackTrace()
    }

    @Test
    "Phil can delete the penguins"() {
        expect:
        philDao.deletePenguins()
    }
}
