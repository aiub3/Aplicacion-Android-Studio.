package com.aiub.empresax.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.aiub.empresax.fragments.FirstFragment;
import com.aiub.empresax.fragments.SecondFragment;
import com.aiub.empresax.fragments.ThirdFragment;


public class Adapter extends FragmentStatePagerAdapter {

    // ESTE ADAPTADOR ES NECESARIO PARA EL VIEWPAGER

    private int numberOfTabs;

    // ESTE CONSTRUCTOR HAY QUE IMPLEMENTARLO DE LA CLASE PADRE, ES NECESARIO
    // EL PARAMETRO tabs LO IMPLEMENTAMOS SOLO PARA ESTE CASO, NO SE IMPLEMENTA AUTOMATICAMENTE
    public Adapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    // ESTOS METODOS HAY QUE IMPLEMENTARLOS DE LA CLASE PADRE, ES NECESARIO

    // CON ESTE METODO DEPENDIENDO DEL TAB DONDE ESTEMOS IREMOS A UN FRAGMENT
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    // POR DEFECTO ESTE METODO DEVOLVIA 0 PERO SE LO CMABIAMOS POR LA VARIABLE NUMBREOFTABS
    @Override
    public int getCount() {
        return numberOfTabs;
    }
}

