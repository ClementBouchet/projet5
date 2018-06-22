package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompteComptableTest
{

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getByNumeroTest()
    {
        CompteComptable compte = new CompteComptable();
        compte.setNumero(1);
        CompteComptable compte2 = new CompteComptable();
        compte2.setNumero(2);
        CompteComptable compte3 = new CompteComptable();
        compte3.setNumero(3);
        CompteComptable compte0 = new CompteComptable();
        List<CompteComptable> liste = new ArrayList<>();
        liste.add(compte);liste.add(compte2);liste.add(compte3);liste.add(compte0);liste.add(null);
        
        CompteComptable test = CompteComptable.getByNumero(liste,2);
        
        assertEquals(compte2,test);
        
        test = CompteComptable.getByNumero(liste,4);
        
        assertEquals(null,test);
        
        test = CompteComptable.getByNumero(liste,null);
        
        assertEquals(compte0,test);
    }
    
    @Test
    public void toStringtTest() {
        CompteComptable compte = new CompteComptable();
        compte.setLibelle("test");
        compte.setNumero(1);
        
        String theory = "CompteComptable{numero="+1+", libelle='test\'}";
        
        assertEquals(theory,compte.toString());
        
        compte.setNumero(null);
        
        theory = "CompteComptable{numero=null, libelle='test\'}";
        
        assertEquals(theory,compte.toString());
        
        compte.setNumero(1);
        compte.setLibelle(null);
        theory = "CompteComptable{numero=1, libelle='null\'}";
        
        assertEquals(theory,compte.toString());
    }

}
