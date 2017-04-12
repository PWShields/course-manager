package com.puffinpowered.coursemanager

import com.puffinpowered.coursemanager.domain.Trainer
import com.puffinpowered.coursemanager.service.TrainerService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * Created by pshields on 12/04/2017.
 *
 * This is meant to give us a comparison between Spock and JUnit testing.
 *
 * Note we are using the Junit @Test annotation to hook into the SpringRunner
 *
 * We are using the Spock Stepwise annotation to run the tests in order so we don't have to repeat ourselves
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Stepwise
class JPASpec extends Specification {

    @Autowired
    WebApplicationContext context

    @Autowired
    TrainerService trainerService

    @Test
    def "will boot up without errors"() {
        expect: "web application context exists"
        context != null
    }

    @Test
    def "Save Trainer"() {
        given: "A new Trainer"
        Trainer trainer = new Trainer();
        trainer.setName("Billy Bob Thornton");
        when: "we try to save the trainer details"
        Trainer trainerSaved = trainerService.save(trainer);
        then: "the details are saved successfully"
        assert trainerSaved.name == trainer.getName()
    }

    @Test
    def "Show Trainer"() {
        given: "An existing Trainer"
       //using Billy Bob from first test
        when: "we request the details"
       Trainer trainer = trainerService.findByNameContaining("Billy").get(0);
        then: "the details are returned"
        assert trainer.name == "Billy Bob Thornton"
    }
}