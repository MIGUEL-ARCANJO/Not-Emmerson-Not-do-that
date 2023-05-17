package com.example.funcionarioarrayadapter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.funcionarioarrayadapter.CadastroFuncionario;
import com.example.funcionarioarrayadapter.MainActivity;
import com.example.funcionarioarrayadapter.R;

import java.util.ArrayList;

public class ListFuncionarioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public ListFuncionarioAdapter(Context context, ArrayList<Funcionario> funcionarios) {
        this.context = context;
        this.funcionarios = CadastroFuncionario.getArrayFuncionario();

    }

    @Override
    public int getCount() {
        return funcionarios.size();
    }

    @Override
    public Object getItem(int i) {
        return funcionarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return funcionarios.get(i).getCodigo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context)
                .inflate(
                        R.layout.lista_funcionarios,
                        viewGroup,
                        false);

        TextView nome = v.findViewById(R.id.txtNome);
        TextView cargo = v.findViewById(R.id.txtCargo);
        TextView sexo = v.findViewById(R.id.txtSexo);

        Funcionario funcionario = funcionarios.get(i);
        nome.setText(funcionario.getNome());
        sexo.setText(funcionario.getSexo() == 'M'?"Masculino":"Feminino");
        cargo.setText(funcionario.getCargo());

        return v;
    }
}
