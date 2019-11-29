package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple maQuestion;

    @Before
    public void setUp() throws Exception {
        //Given
        ArrayList<Integer> l = new ArrayList<>();
        l.add(new Integer(2));
        l.add(new Integer(4));
        this.maQuestion = new QuestionAChoixMultiple("Enonce de la question" , l);
    }

    @Test
    public void testGetEnonce() {
        //when : quand je demande l'enonce de la question
        String enonceAttendu = "Enonce de la question";
        String enonce = maQuestion.getEnonce();

        //Then : alors je m'attends à ce que ce soit celui donné à la construction de la question
        assertEquals(enonceAttendu,enonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        float scoreAttendu = 50 ;
        //when : quand je donne un indice de bonne réponse
        int indice = 2 ;
        //et que je demande le score de la réponse
        float score = maQuestion.getScoreForIndice(indice);

        //then : alors je m'attends à ce qu'il soit égal à 50 car il y a deux bonne réponse
        assertEquals(scoreAttendu,score,0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        float scoreAttendu = 0 ;
        //when : quand je donne un indice de mauvaise réponse
        int indice = 5 ;
        //et que je demande le score de la réponse
        float score = maQuestion.getScoreForIndice(indice);

        //then : alors je m'attends à ce qu'il soit égal à 0
        assertEquals(scoreAttendu,score,0.01f);
    }
}
