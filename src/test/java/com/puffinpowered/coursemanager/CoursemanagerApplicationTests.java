package com.puffinpowered.coursemanager;

import com.puffinpowered.coursemanager.domain.Trainer;
import com.puffinpowered.coursemanager.service.TrainerService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;

/**
 * One problem with JUnit is that the beforeClass doesn't allow you to use your service to pre-populate some data as it is static.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursemanagerApplicationTests {


    @Autowired
    WebApplicationContext context;

    @Autowired
    TrainerService trainerService;


    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void setUp() {
        if(trainerService.findOne(1) == null){
            Trainer trainer = new Trainer();
            trainer.setName("Arnie");
            trainerService.save(trainer);
        }

    }

    @Test
    public void contextLoads() {
        assertNotEquals(null, context);
    }

    @Test
    public void testSaveTrainerDetails() {
        Trainer trainer = new Trainer();
        trainer.setName("Billy Bob Thornton");
        Trainer trainerSaved = trainerService.save(trainer);
        assertThat(trainerSaved, isA(Trainer.class));
        assertEquals(trainerSaved.getName(), trainer.getName());
    }

    @Test
    public void testShowTrainerDetails() {
        Trainer trainer = trainerService.findOne(1);
        assertThat(trainer, isA(Trainer.class));
        assertEquals("Arnie", trainer.getName());
    }

    @Test
    public void testFindTrainerByName() {
        List<Trainer> trainers = trainerService.findByName("Arnie");
        assertEquals(1,trainers.size());
        assertEquals("Arnie", trainers.get(0).getName());
    }


}
