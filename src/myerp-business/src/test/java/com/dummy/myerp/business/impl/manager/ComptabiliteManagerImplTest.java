package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;


import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.impl.DaoProxyImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.technical.exception.NotFoundException;


public class ComptabiliteManagerImplTest extends AbstractBusinessManager{

    private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();


    @Test
    public void checkEcritureComptableUnit() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        manager.checkEcritureComptableUnit(vEcritureComptable);        
        
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitViolation() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG2() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(1234)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
        
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }
    
    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3bis() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }
    
    
    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3ter() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, null,
                new BigDecimal(123)));
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
        }
    
    @Test
    public void checkEcritureComptableUnitRG3bister() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(10),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(0),
                                                                                 null));
        
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, null,
                                                                                 new BigDecimal(10)));
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
        }
    
    @Test(expected = FunctionalException.class)
    //@Test
    public void checkEcritureComptableUnitRG5() throws Exception{
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        String ref = "AB-2018/00001";
        vEcritureComptable.setReference(ref);
        
        
        manager.checkEcritureComptableUnitRG5(vEcritureComptable);
    }
    
    @Test(expected = FunctionalException.class)
    //@Test
    public void checkEcritureComptableUnitRG5bis() throws Exception{
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        String ref = "AC-2017/00001";
        vEcritureComptable.setReference(ref);
        
        
        manager.checkEcritureComptableUnitRG5(vEcritureComptable);
    }
    
    @Test
    public void checkEcritureComptableContextTest() throws FunctionalException{
        
        EcritureComptable ecr = new EcritureComptable();
        ecr.setReference("AB-2018/00001");
        //ecr.setId(123);
        
        ComptabiliteDao compta;
        compta = new ComptabiliteDaoMock();
        DaoProxy daoProxy = DaoProxyImpl.getInstance();
        configure(null, daoProxy, null);
        getDaoProxy().setComptabiliteDao(compta);
        manager.checkEcritureComptableContext(ecr);
        
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void addReferenceTest() {
        ComptabiliteDao compta;
        compta = new ComptabiliteDaoMock();
        DaoProxy daoProxy = DaoProxyImpl.getInstance();
        configure(null, daoProxy, null);
        getDaoProxy().setComptabiliteDao(compta);
        
        EcritureComptable ecr = new EcritureComptable();
        Date date = new Date();
        JournalComptable journal = new JournalComptable();
        
        date.setYear(2018 - 1900);date.setMonth(3);date.setDate(3);       
        journal.setCode("AB");
        ecr.setDate(date);
        ecr.setJournal(journal);       
        manager.addReference(ecr);
        
        assertEquals("AB-2018/00024",ecr.getReference());
        
        ecr.setReference(null);
        date.setYear(2018 - 1900);date.setMonth(3);date.setDate(3);       
        journal.setCode("AC");
        ecr.setDate(date);
        ecr.setJournal(journal);       
        manager.addReference(ecr);
        
        assertEquals("AC-2018/00001",ecr.getReference());
        
        ecr.setReference(null);
        date.setYear(2018 - 1900);date.setMonth(3);date.setDate(3);       
        journal.setCode("AC");
        ecr.setDate(date);
        ecr.setJournal(journal);       
        manager.addReference(ecr);
        
        assertEquals("AC-2018/00001",ecr.getReference());
        
        ecr.setReference(null);
        date.setYear(2017 - 1900);date.setMonth(3);date.setDate(3);       
        journal.setCode("AB");
        ecr.setDate(date);
        ecr.setJournal(journal);       
        manager.addReference(ecr);
        
        assertEquals("AB-2017/00021",ecr.getReference());
    }

}
