package com.dummy.myerp.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.technical.exception.NotFoundException;

public class ComptabiliteDaoMock implements ComptabiliteDao{

    @Override
    public List<CompteComptable> getListCompteComptable()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<JournalComptable> getListJournalComptable()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EcritureComptable> getListEcritureComptable()
    {
        List<EcritureComptable> lEcrs = new ArrayList<>();
        EcritureComptable ecr1 = new EcritureComptable();
        ecr1.setReference("AB-2017/00020");
        EcritureComptable ecr2 = new EcritureComptable();
        ecr2.setReference("AB-2018/00021");
        EcritureComptable ecr3 = new EcritureComptable();
        ecr3.setReference("AB-2018/00023");
        EcritureComptable ecr4 = new EcritureComptable();
        ecr4.setReference("AB-2018/00016");
        lEcrs.add(ecr1);lEcrs.add(ecr2);lEcrs.add(ecr3);lEcrs.add(ecr4);
        return lEcrs;
    }

    @Override
    public EcritureComptable getEcritureComptable(Integer pId) throws NotFoundException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EcritureComptable getEcritureComptableByRef(String pReference) throws NotFoundException
    {
        EcritureComptable ecriture = new EcritureComptable();
        //ecriture.setId(123);
        return null;
    }

    @Override
    public void loadListLigneEcriture(EcritureComptable pEcritureComptable)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertEcritureComptable(EcritureComptable pEcritureComptable)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateEcritureComptable(EcritureComptable pEcritureComptable)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteEcritureComptable(Integer pId)
    {
        // TODO Auto-generated method stub
        
    }

}
