package spinner.macochave.com.probarspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    protected ArrayAdapter<CharSequence> adapter;
    Spinner spinner;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.comboSelect);
        /*
        Lleno el adaptador desde un origen de datos
        Context: Cuál es el contexto
        @ArrayRes: De dónde se obtendrán los datos
        @LayoutRes: A donde se irán los datos
         */
        adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);

        //ASIGNAR EL LAYOUT A INFLAR AL MOMENTO DE DESPLEGAR LA LISTA
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //SETEAR EL ADAPTADOR
        spinner.setAdapter(adapter);

        //CREAR LA ESCUCHA AL SPINNER
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*
        Almacenar la posición y valor del item actual
        Hacer lo que se desea con el item seleccionado
         */
        this.position = position;
        String selection = parent.getItemAtPosition(position).toString();

        Toast.makeText(this, "Selección actual: " + selection, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
