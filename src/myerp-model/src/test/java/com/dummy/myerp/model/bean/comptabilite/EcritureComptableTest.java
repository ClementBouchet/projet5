package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.*;
import org.junit.Test;


public class EcritureComptableTest {

    private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
        BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
        BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
        String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
                                     .subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
        LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
                                                                    vLibelle,
                                                                    vDebit, vCredit);
        return vRetour;
    }

    @Test
    public void isEquilibree() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();

        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        boolean test = vEcriture.isEquilibree();
        assertTrue(vEcriture.toString(), test);

        vEcriture.getListLigneEcriture().clear();
        vEcriture.setLibelle("Non équilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "30"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
        assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
    }
    
    @Test
    public void getTotalDebitTest() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();
        
        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        
        BigDecimal test = vEcriture.getTotalDebit();
        BigDecimal theory = new BigDecimal("341");
        assertEquals(theory.compareTo(test),0);
        
        
        vEcriture.getListLigneEcriture().clear();
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "-100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        
        test = vEcriture.getTotalDebit();
        theory = new BigDecimal("140.00");
        
        assertEquals(theory,test);
        
        vEcriture.getListLigneEcriture().clear();
        vEcriture.getListLigneEcriture().add(this.createLigne(1, null, null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        
        test = vEcriture.getTotalDebit();
        theory = BigDecimal.ZERO;
        
        assertEquals(theory,test);
        
        vEcriture.getListLigneEcriture().clear();
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "-200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "-100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "-40", "7"));
        
        test = vEcriture.getTotalDebit();
        theory = new BigDecimal("-341.00");
        
        assertEquals(theory,test);
        
        vEcriture.getListLigneEcriture().clear();
        test = vEcriture.getTotalDebit();
        theory = BigDecimal.ZERO;
        
        assertEquals(theory,test);
    }
    
    @Test
    public void getTotalCreditTest() {
        
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();
        
        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        
        BigDecimal test = vEcriture.getTotalCredit();
        BigDecimal theory = new BigDecimal("341.00");
        
        assertEquals(theory.compareTo(test),0);
        
        vEcriture.getListLigneEcriture().clear();
        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "-1"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "10"));
        
        test = vEcriture.getTotalCredit();
        theory = new BigDecimal("310.00");
        
        assertEquals(theory.compareTo(test),0);
        
        vEcriture.getListLigneEcriture().clear();
        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, null));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", null));
        
        test = vEcriture.getTotalCredit();
        theory = BigDecimal.ZERO;
        
        assertEquals(theory.compareTo(test),0);
        
        vEcriture.getListLigneEcriture().clear();
        test = vEcriture.getTotalDebit();
        theory = BigDecimal.ZERO;
        
        assertEquals(theory.compareTo(test),0);
    }
    
    @Test
    public void toStringTest() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();
        Date date = new Date();
        date.setDate(1);date.setMonth(1);date.setYear(118);
        JournalComptable journal = new JournalComptable();
        journal.setCode("AB");
        journal.setCode("testJournal");
        int id = 10;
        String ref = "AB-2018/00001";
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "100"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", null));
        
        vEcriture.setDate(date);
        vEcriture.setId(id);
        vEcriture.setLibelle("test");
        vEcriture.setReference(ref);
        vEcriture.setJournal(journal);
        String test = "EcritureComptable{id="+id+", journal="+journal+", reference='"+ref+"\', date="+date+", libelle='test\', totalDebit="+new BigDecimal("341.00")+", totalCredit="+100+", listLigneEcriture=[\n"+StringUtils.join(vEcriture.getListLigneEcriture(), "\n")+"\n]}";
        
        assertEquals(test,vEcriture.toString());
        
        vEcriture.setLibelle(null);
        vEcriture.setDate(null);
        test = "EcritureComptable{id="+id+", journal="+journal+", reference='"+ref+"\', date=null, libelle='null\', totalDebit="+new BigDecimal("341.00")+", totalCredit="+100+", listLigneEcriture=[\n"+StringUtils.join(vEcriture.getListLigneEcriture(), "\n")+"\n]}";
        assertEquals(test,vEcriture.toString());
    }

}
