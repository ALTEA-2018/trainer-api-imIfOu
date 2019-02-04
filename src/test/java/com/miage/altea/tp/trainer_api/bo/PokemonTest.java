package com.miage.altea.tp.trainer_api.bo;

import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.junit.Assert.assertNotNull;

public class PokemonTest {

    @Test
    public void pokemon_shouldBeAnEntity(){
        assertNotNull(Pokemon.class.getAnnotation(Entity.class));
    }

    @Test
    public void pokemonId_shouldBeAGeneratedId() throws NoSuchFieldException {
        assertNotNull(Pokemon.class.getDeclaredField("id").getAnnotation(Id.class));
        assertNotNull(Pokemon.class.getDeclaredField("id").getAnnotation(GeneratedValue.class));
    }

}
