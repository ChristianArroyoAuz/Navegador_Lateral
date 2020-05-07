package com.lateral.navegador;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lateral.navegador.navigationdrawer.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout navegador;

    protected void onCreate(Bundle inicioLayout) {
        super.onCreate(inicioLayout);
        setContentView(R.layout.activity_inicio);

        Toolbar barraHerramientas = findViewById(R.id.cuadroNavegacion);
        setSupportActionBar((Toolbar) findViewById(R.id.cuadroNavegacion));

        navegador = findViewById(R.id.contenedorTab);
        ActionBarDrawerToggle alternar = new ActionBarDrawerToggle(this, navegador, barraHerramientas, R.string.menu_abrir, R.string.menu_cerrar);
        alternar.syncState();

        NavigationView navegar = findViewById(R.id.vistaNavegacion);
        navegar.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navegar.getMenu().getItem(0));
    }

    public void onBackPressed() {
        if (navegador.isDrawerOpen(GravityCompat.START)) {
            navegador.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem itemsMenu) {
        int opcion;
        switch (itemsMenu.getItemId()) {
            case R.id.inicio:
                opcion = R.string.menu_inicio;
                break;
            case R.id.historia:
                opcion = R.string.menu_historia;
                break;
            case R.id.laboratorio:
                opcion = R.string.menu_laboratorio;
                break;
            case R.id.imagen:
                opcion = R.string.menu_imagen;
                break;
            case R.id.teleconsulta:
                opcion = R.string.menu_teleconsulta;
                break;
            case R.id.citas:
                opcion = R.string.menu_citas;
                break;
            case R.id.contacto:
                opcion = R.string.menu_contacto;
                break;
            case R.id.facebook:
                opcion = R.string.menu_facebook;
                break;
            case R.id.instagram:
                opcion = R.string.menu_instagram;
                break;
            case R.id.usuario:
                opcion = R.string.menu_usuario;
                break;
            case R.id.password:
                opcion = R.string.menu_password;
                break;
            case R.id.herramientas:
                opcion = R.string.menu_herramientas;
                break;
            case R.id.salir:
                opcion = R.string.menu_salir;
                break;
            default:
                throw new IllegalArgumentException("Opción de menú no implementada!!");
        }
        setTitle(getString(opcion));
        navegador.closeDrawer(GravityCompat.START);
        return true;
    }
}