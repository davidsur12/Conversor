package app.conversor.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var txtInput: EditText? = null;
    var txtBinario: TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInput = findViewById(R.id.valorInput);
        txtBinario = findViewById(R.id.valorBinario);

        val lista: Spinner = findViewById(R.id.operaciones);
        val operaciones = arrayOf("Binario", "Octal", "Decimal", "Hexadecimal");
        // val adaptador:ArrayAdapter<*>;
        // var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, operaciones);
        ArrayAdapter.createFromResource(
            this, R.array.item_spinner_operaciones,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            lista.adapter = adapter;
        }

        lista.onItemSelectedListener = this;
    }

    fun decimalBinario(valor: String): String {
        var resultado: Int = 0;
        var cadenaResultado = StringBuilder();
        var cadenaResultado2 = StringBuilder();
        if (esNumero(valor)) {
            var num: Int = valor.toInt();


            if (num > 1) {


                resultado = num % 2
                num=num/2;
                cadenaResultado.append(resultado);
                while (num> 1) {
                    resultado = num % 2
                    num=num/2;
                    cadenaResultado.append(resultado);


                }
                cadenaResultado.append("1");

                for(i in cadenaResultado.length-1 downTo 0){
                    cadenaResultado2.append(cadenaResultado[i]);
                }
                txtBinario?.setText("" + cadenaResultado2);

            } else {
                txtBinario?.setText(num);
            }
        } else {
            txtBinario?.setText("no todos son digitos");
        }
        return "";
    }

    //esta funcion devuelve true si la cadena es totalmete numerica de lo contrario devuelve false
    fun esNumero(valor: String): Boolean {
        //txtBinario?.setText( "\n" + valor.length );
        var digito: Boolean = true;
        var cont: Int = 0;
        var cadena = StringBuilder();
        for (i in 0..valor.length - 1) {
            //cadena.append(valor[i])
            if (!valor[i].isDigit()) {
                digito = false;
            }


        }
        //txtBinario?.setText("\n" + cadena);
        return digito;
    }

    fun decimalOctal(valor: Int): Int {

        return 0;
    }

    fun decimalHexadecimal(valor: Int): Int {
        return 0;
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0 != null ) {
            //  Toast.makeText(this, "" + p2, Toast.LENGTH_SHORT).show();
            if(txtInput?.text.toString().length>0){    decimalBinario(txtInput?.text.toString());}


        }

    }
}