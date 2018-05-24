package pooa2018.iff.br.trabalho01120181;

import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtArea;
    private TextView lPropostas;
    private Button bOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArea = findViewById(R.id.txtResposta);


        bOK.setOnClickListener(new View.OnClickListener() {

        }
        @Override
        public void onClick (View view){
            calcular();
        }
        )
    }

        private void calcular(){

        double area = Float.parseFloat(txtArea.getText().toString());
        double total_litros = 0, preco_L, preco_G;
        int total_latas = 0, total_galoes = 0;

        total_litros = area / 6;

        total_latas = (int) Math.ceil(total_litros / 18);
        total_galoes = (int) Math.ceil(total_litros / 3.6);

        preco_L = total_latas * 80;
        preco_G = total_galoes * 25;


        //Ifs de condicionamento



        String msg1 = "A quantidade de latas de tinta utilizadas serão" + total_latas + " com preço total de R$" + preco_L + ". \n A quantidade de galões de tinta utilizadas serão:" + total_galoes + " com preço total de R$" + preco_L;
        String msg2 = " ";
        int qtd_L, qtdG;

        lPropostas.setText((String.valueOf(msg1).concat(msg2)));

    }
}
