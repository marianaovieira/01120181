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
        lPropostas = findViewById(R.id.lProposta);
        bOK = findViewById(R.id.bOk);

        bOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                calcular();
            }
        }
        );
    }

        private void calcular(){

        double area = Float.parseFloat(txtArea.getText().toString());
        double total_litros, preco_L, preco_G, auxiliar, valor_total;
        int total_latas, total_galoes;

        total_litros = area / 6;

        total_latas = (int) Math.ceil(total_litros / 18);
        total_galoes = (int) Math.ceil(total_litros / 3.6);

        preco_L = total_latas * 80;
        preco_G = total_galoes * 25;


        String msg1 = "Opção 1: A quantidade de latas de tinta utilizadas será de " + total_latas + " latas com preço total de R$" + preco_L + ". \n\nOpção 2: A quantidade de galões de tinta utilizados será de:" + total_galoes + " galões com preço total de R$" + preco_G;


            auxiliar = area % 18;

            if(auxiliar == 0)
                total_galoes = 0;
            else {
                total_galoes = (int) (auxiliar / 3.6);

                if(total_galoes == 0 || total_galoes * 3.6 < area)
                    total_galoes++;

                if(total_galoes * 25 > 80) {
                    total_galoes = 0;
                    total_latas++;
                }
            }

            valor_total = (total_galoes * 25) + (total_latas * 80);

            String msg2 = "\n \nOpção 3: A quantidade de latas de tinta será de "+total_latas+" e a de galões "+total_galoes+". O preço total será de R$"+valor_total;

            lPropostas.setText((String.valueOf(msg1).concat(msg2)));

    }
}
