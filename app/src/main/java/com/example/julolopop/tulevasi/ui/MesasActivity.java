package com.example.julolopop.tulevasi.ui;

import android.app.Fragment;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.dao.MesasDao;
import com.example.julolopop.tulevasi.pojo.Catalogo;
import com.example.julolopop.tulevasi.ui.catalogo.AnadirProductoFragment;
import com.example.julolopop.tulevasi.ui.catalogo.CatalogoFragment;
import com.example.julolopop.tulevasi.ui.catalogo.ProductosFragment;
import com.example.julolopop.tulevasi.ui.mesas.EditarMesaFragment;
import com.example.julolopop.tulevasi.ui.mesas.ListaMesaFragment;
import com.example.julolopop.tulevasi.ui.mesas.ListaMesasFragment;

import java.util.Date;

public class MesasActivity extends AppCompatActivity implements AnadirProductoFragment.OnFragmentAnadirproductoListener,ProductosFragment.OnFragmentProductosListener,CatalogoFragment.OnCatalogoFragmentListener,ListaMesasFragment.OnFragmentListaMesasListener,ListaMesaFragment.OnFragmentListaMesaListener,EditarMesaFragment.OnFragmentEditarMesaListener {

    ListaMesasFragment listaMesasFragment;
    ListaMesaFragment listaMesaFragment;
    EditarMesaFragment editarMesaFragment;
    CatalogoFragment catalogoFragment;
    ProductosFragment productosFragment;
    AnadirProductoFragment anadirProductoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);


        MesasDao mesasDao = new MesasDao(this, "DBUsuarios", null, 1);

        SQLiteDatabase db = mesasDao.getReadableDatabase();

        mesasDao.crear(db);

        listaMesasFragment = (ListaMesasFragment) getSupportFragmentManager().findFragmentByTag(ListaMesasFragment.TAG);
        if(listaMesasFragment == null){

            listaMesasFragment = new ListaMesasFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(android.R.id.content,listaMesasFragment,ListaMesasFragment.TAG);
            fragmentTransaction.commit();
        }


    }


    @Override
    public void onAbrirMesaActivity(Bundle bundle) {
        listaMesaFragment = new ListaMesaFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        listaMesaFragment.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content,listaMesaFragment,ListaMesaFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onAnadirNuevoProducto(Bundle bundle) {
        anadirProductoFragment = new AnadirProductoFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        anadirProductoFragment.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content,anadirProductoFragment,AnadirProductoFragment.TAG);
        fragmentTransaction.commit();
    }


    @Override
    public void onBack() {

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void abrirEditarFragment(Bundle bundle) {

            editarMesaFragment = new EditarMesaFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            editarMesaFragment.setArguments(bundle);
            fragmentTransaction.replace(android.R.id.content,editarMesaFragment,EditarMesaFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }

    @Override
    public void abrirCatalogo(Bundle bundle) {
        catalogoFragment = new CatalogoFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        catalogoFragment.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content,catalogoFragment, CatalogoFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void abrirListaProductos(Bundle bundle) {
        productosFragment = new ProductosFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        productosFragment.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content,productosFragment, ProductosFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
