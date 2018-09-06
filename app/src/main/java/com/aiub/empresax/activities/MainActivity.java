package com.aiub.empresax.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.aiub.empresax.R;
import com.aiub.empresax.adapter.Adapter;

// TOOLBAR ES LA FORMA CORRECTA DE CREAR BARRAS DE HERRAMIENTAS ARRIBA, TIENE MUCHAS FORMAS DE PERSONALIZARSE Y
// TIENE MAS COMPATIBILIDAD QUE LA ACTIONBAR QUE ES LA QUE SUELE HABER POR DEFECTO EN ANDROID
// PARA IMPLEMENTAR EL TOOLBAR LO PRIMERO QUE HAY QUE HACER ES QUITAR EL ACTIONBAR EN STYLES.XML
// Y AÑADIR EL CODIGO QUE INDICA LA DOCUMENTACION OFICIAL EN EL LAYOUT DEL ACTIVITY EN QUE QUERAMOS AÑADIR EL TOOLBAR
// HAY MAS INFORMACION EN LA DOCUMENTACION OFICIAL DE GOOGLE

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ESTE CODIGO TAMBIEN ES COPIADO DE LA DOCUMENTACION OFICIAL, IMPORTAMOS LA LIBRERIA TOOLBAR DE ANDROID.SUPPORT.V7.WIDGET
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // A la variabl etabLayout que creamos le añadimos un tabs nuevos y a cada uno un texto
        tabLayout.addTab(tabLayout.newTab().setText(R.string.first_fragment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.second_fragment));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.third_fragment));
        // Le añadimos este elemento para que mejore el diseño del tabLayout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // AUTOMATICAMENTE ESTA VARIABLE SE CONVIERTE EN FINAL PORQUE ES NECESARIO PARA PODER
        // USARLA DENTRO DEL METODO ONTABSELECTED
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        // CREAMOS UNA INSTANCIA DEL ADAPTADOR QUE HEMOS CREADO PASANDOLE LOS 2 ARGUMENTOS, EL PRIMERO ES EL QUE SIEMPRE VA A NECESITAR
        // Y EL SEGUNDO ES QUE AÑADIMOS, EN ESTE CASO EL NUMERO DE TABS
        Adapter adapter = new Adapter(getSupportFragmentManager(), tabLayout.getTabCount());
        // LE AÑADIMOS EL ADAPTADOR AL VIEWPAGER
        viewPager.setAdapter(adapter);
        // CADA VEZ QUE CAMBIEMOS DE TAB EL VIEWPAGER TAMBIEN CAMBIA DE FRAGMENT
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // CUANDO EL HAYA ALGUNA ACCION SOBRE EL TAB PODEMOS AÑADIR FUNCIONES CON ESTE METODO
        // LA PRIMERA SE ACTIVA AL SELECCIONAR UN TAB DIFERENTE AL QUE ESTAMOS, EN EL TAB AL QUE ACCEDEMOS
        // LA SEGUNDA CUANDO SELECCIONAMOS UN TAB DIFERENTE, PERO OCURE EN EL TAB EN QUE VAMOS A DEJAR DE ESTAR
        // EL TERCERO CUANDO PULSAMOS EN EL MISMO TAB DONDE ESTAMOS
        // LOS 3 METODOS SON NECESARIOS Y SE SOBREESCRIBEN AUTOMATICAMENTE
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    // EL MENU SON LOS 3 PUNTOS A LA DERRECHA ARRIBA QUE AL PULSAR APARECE UN MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
