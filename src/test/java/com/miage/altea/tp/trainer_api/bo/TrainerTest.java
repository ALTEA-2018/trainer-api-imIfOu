package com.miage.altea.tp.trainer_api.bo;


import org.junit.Test;

import javax.persistence.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrainerTest {

    @Test
    public void trainer_shouldBeAnEntity(){
        assertNotNull(Trainer.class.getAnnotation(Entity.class));
    }

    @Test
    public void trainerName_shouldBeAnId() throws NoSuchFieldException {
        assertNotNull(Trainer.class.getDeclaredField("name").getAnnotation(Id.class));
    }

    @Test
    public void trainerTeam_shouldBeAOneToManyRelationship() throws NoSuchFieldException {
        var oneToMany = Trainer.class.getDeclaredField("team").getAnnotation(OneToMany.class);

        assertNotNull(oneToMany);

        assertArrayEquals(new CascadeType[]{CascadeType.ALL}, oneToMany.cascade());
        assertEquals(FetchType.EAGER, oneToMany.fetch());
    }
}
