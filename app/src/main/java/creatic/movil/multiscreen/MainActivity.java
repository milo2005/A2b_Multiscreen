package creatic.movil.multiscreen;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import creatic.movil.multiscreen.fragments.DetailFragment;
import creatic.movil.multiscreen.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity implements MasterFragment.MasterFragmentI{

    boolean port, phone;
    MasterFragment master;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        port = getResources().getBoolean(R.bool.port);
        phone = getResources().getBoolean(R.bool.phone);

        master = new MasterFragment();

        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.container1, master);
        if(!phone && !port){
            detail = new DetailFragment();
            fT.replace(R.id.container2, detail);
        }

        fT.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container1, master);
            ft.commit();
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setColor(int pos) {
        if(!phone && !port){
            detail.setColor(pos);
        }else{
            detail = new DetailFragment();
            detail.init(pos);
            FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
            fT.replace(R.id.container1,detail);
            fT.commit();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}


