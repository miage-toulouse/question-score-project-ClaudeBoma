package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private QuestionAChoixMultiple maQuestion ;
    private ScoreCalculateur monScoreCalculateur;

    @Before
    public void setUp() throws Exception {
        //given
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(2,3,5)) ;
        maQuestion = new QuestionAChoixMultiple("q1",l ,5);
        monScoreCalculateur = new ScoreCalculateur();
    }

    @Test
    public void testScoreIndicesMauvaisesReponses(){
        ArrayList<Integer> listeIndice = new ArrayList<>(Arrays.asList(1,4)) ;
        //when : quand je donne au score calculateur une question à choix multiple et  une liste d'indices de mauvaises réponses
        // et que je demande le calcul du score
        float score = monScoreCalculateur.calculeScore(listeIndice,maQuestion);

        //then : alors je m'attends à ce que le score soit égal à 0
        assertEquals(0f,score,0.01);
    }

    @Test
    public void testScoreIndicesBonnesReponses(){
        ArrayList<Integer> listeIndice = new ArrayList<>(Arrays.asList(2,3,5)) ;
        //when : quand je donne au score calculateur une question à choix multiple et  une liste d'indices avec toutes les bonnes réponses
        // et que je demande le calcul du score
        float score = monScoreCalculateur.calculeScore(listeIndice,maQuestion);

        //then : alors je m'attends à ce que le score soit égal à 100
        assertEquals(100f,score,0.01);
    }

    @Test
    public void testScoreIndices2BonneReponsesSur3(){
        ArrayList<Integer> listeIndice = new ArrayList<>(Arrays.asList(2,3)) ;
        float scoreAttendu = (2*100/3f);
        //when : quand je donne au score calculateur une question à choix multiple et  une liste d'indices avec des 2 bonnes réponses bonnes sur 3
        // et que je demande le calcul du score
        float score = monScoreCalculateur.calculeScore(listeIndice,maQuestion);

        //then : alors je m'attends à ce que le score soit à 2*(100/3)
        assertEquals( scoreAttendu,score,0.01);
    }

    @Test
    public void testScoreIndices3Bonnes2MauvaisesReponses(){
        ArrayList<Integer> listeIndice = new ArrayList<>(Arrays.asList(1,2,3,4,5)) ;
        float scoreAttendu = 0f;
        //when : quand je donne au score calculateur une question à choix multiple et  une liste d'indices avec 3 bonnes réponses et 2 mauvaises réponses
        // et que je demande le calcul du score
        float score = monScoreCalculateur.calculeScore(listeIndice,maQuestion);

        //then : alors je m'attends à ce que le score soit à 0
        assertEquals(scoreAttendu,score,0.01);
    }

    @Test
    public void testScoreIndices2Bonnes1MauvaisesReponses(){
        ArrayList<Integer> listeIndice = new ArrayList<>(Arrays.asList(1,2,3)) ;
        float scoreAttendu = 16.66f;
        //when : quand je donne au score calculateur une question à choix multiple et  une liste d'indices avec des 2 bonnes réponses et 1 mauvaise réponse
        // et que je demande le calcul du score
        float score = monScoreCalculateur.calculeScore(listeIndice,maQuestion);

        //then : alors je m'attends à ce que le score soit à 0
        assertEquals(scoreAttendu,score,0.01);
    }
}