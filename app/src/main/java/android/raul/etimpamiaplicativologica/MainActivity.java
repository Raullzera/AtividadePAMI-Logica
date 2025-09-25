package android.raul.etimpamiaplicativologica;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Override;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4, numeroFaltas, nomeAluno;

    private Button btnCalcular;

    private TextView resultado;

    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela05);

        initComponentes();

        btnCalcular.setOnClickListener(view->{
            validaCampos();
            calculaMedia();
        });


    }

    private void calculaMedia() {
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());

        double media = (n1 + n2 + n3 + n4) / 4;

        double faltas = Double.parseDouble(numeroFaltas.getText().toString());

        String nome = nomeAluno.getText().toString();

        if(media > 7) {
            if (faltas < 20) {
                resultado.setTextColor(Color.parseColor("#437845"));
                resultado.setText("Olá " + nome + ", você foi aprovado com média: " + media);
            } else {
                resultado.setTextColor(Color.parseColor("#F44336"));
                resultado.setText("Olá " + nome + ", Você foi reprovado por excesso de faltas " + faltas);
            }
        }else {
            resultado.setTextColor(Color.parseColor("#F44336"));
            resultado.setText("Olá " + nome + ", Você foi retido com média: " + media);
            }
        }

    private void validaCampos() {
        if (TextUtils.isEmpty(nota1.getText())){

            nota1.setError("Este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota2.getText())) {
            nota2.setError("Este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota3.getText())) {
            nota3.setError("Este campo não pode estar vazio.");
        } else if (TextUtils.isEmpty(nota4.getText())) {
            nota4.setError("Este campo não pode estar vazio.");
        }
    }

   private boolean validaCampos2(){
        boolean camposValidados = true;
        if(nota1.getText().toString().isEmpty() ) {
            camposValidados = false;
        } else if (nota2.getText().toString().isEmpty()) {
            camposValidados = false;
        } else if (nota3.getText().toString().isEmpty()) {
            camposValidados = false;
        } else if (nota4.getText().toString().isEmpty()) {
            camposValidados = false;
        };

        return camposValidados;
   }

    private void initComponentes() {

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.numeroFaltas);
        btnCalcular = findViewById(R.id.btn_calcular);
        resultado = findViewById(R.id.txt_resultado);
        nomeAluno = findViewById(R.id.nomeAluno);
    }

}
