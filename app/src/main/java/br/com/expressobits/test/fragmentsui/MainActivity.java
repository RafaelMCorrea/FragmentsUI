package br.com.expressobits.test.fragmentsui;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verifique se a atividade está usando a versão de layout com o fragment_container
        // FrameLayout
        if(findViewById(R.id.fragment_container)!=null){
            // No entanto, se estamos a ser restaurado a partir de um estado anterior,
            // então não precisa fazer nada e deve retornar ou então poderíamos acabar
            // com fragmentos sobrepostos.
            if(savedInstanceState !=null){
                return;
            }
            // Criar um novo fragmento a ser colocado na disposição actividade
            HeadLinesFragment firstFragment = new HeadLinesFragment();

            // No caso de essa atividade foi iniciada com instruções especiais de uma
            // Intenção, passar extras da intenção de o fragmento como argumentos
            firstFragment.setArguments(getIntent().getExtras());
            // Adicionar o fragmento para o 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container,firstFragment).commit();


            //get().setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
