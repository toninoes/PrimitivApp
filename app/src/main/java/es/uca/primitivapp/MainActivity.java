package es.uca.primitivapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.n0)
    TextView n0;
    @BindView(R.id.n1)
    TextView n1;
    @BindView(R.id.n2)
    TextView n2;
    @BindView(R.id.n3)
    TextView n3;
    @BindView(R.id.n4)
    TextView n4;
    @BindView(R.id.n5)
    TextView n5;
    @BindView(R.id.check_decenas)
    CheckBox checkDecenas;
    @BindView(R.id.check_bajos_altos)
    CheckBox checkBajosAltos;
    @BindView(R.id.check_sumatorio)
    CheckBox checkSumatorio;
    @BindView(R.id.check_seguidos)
    CheckBox checkSeguidos;
    @BindView(R.id.check_terminaciones)
    CheckBox checkTerminaciones;
    @BindView(R.id.check_pares_impares)
    CheckBox checkParesImpares;
    @BindView(R.id.btnGen)
    Button btnGen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
        switch (id) {
            case R.id.action_ayuda:
                Intent intentAyuda = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(intentAyuda);
                return true;
            case R.id.action_inicio:
                Intent intentMain = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.btnGen)
    public void onViewClicked() {
        AleatoriosPrimitiva A = new AleatoriosPrimitiva(checkDecenas.isChecked(), checkSumatorio.isChecked(),
                checkTerminaciones.isChecked(), checkBajosAltos.isChecked(), checkSeguidos.isChecked(),
                checkParesImpares.isChecked());

        n0.setText(A.getCombinacion().get(0).toString());
        n1.setText(A.getCombinacion().get(1).toString());
        n2.setText(A.getCombinacion().get(2).toString());
        n3.setText(A.getCombinacion().get(3).toString());
        n4.setText(A.getCombinacion().get(4).toString());
        n5.setText(A.getCombinacion().get(5).toString());
    }
}