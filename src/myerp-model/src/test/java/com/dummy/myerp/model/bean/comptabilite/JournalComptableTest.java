package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JournalComptableTest
{

    @Test
    public void getByCodeTest()
    {
        JournalComptable journal = new JournalComptable();
        journal.setCode("AA");
        JournalComptable journal2 = new JournalComptable();
        journal2.setCode("AB");
        JournalComptable journal3 = new JournalComptable();
        journal3.setCode("AC");
        JournalComptable journal0 = new JournalComptable();
        List<JournalComptable> liste = new ArrayList<>();
        liste.add(journal);liste.add(journal2);liste.add(journal3);liste.add(journal0);liste.add(null);
        
        JournalComptable test = JournalComptable.getByCode(liste,"AB");
        
        assertEquals(journal2,test);
        
        test = JournalComptable.getByCode(liste,"AD");
        
        assertEquals(null,test);
        
        test = JournalComptable.getByCode(liste,null);
        
        assertEquals(journal0,test);
    }
    
    @Test
    public void toStringtTest() {
        JournalComptable journal = new JournalComptable();
        journal.setLibelle("test");
        journal.setCode("AA");
        
        String theory = "JournalComptable{code='AA\', libelle='test\'}";
        
        assertEquals(theory,journal.toString());
        
        journal.setCode(null);
        
        theory = "JournalComptable{code='null\', libelle='test\'}";
        
        assertEquals(theory,journal.toString());
        
        journal.setCode("AA");
        journal.setLibelle(null);
        theory = "JournalComptable{code='AA\', libelle='null\'}";
        
        assertEquals(theory,journal.toString());
    }

}
