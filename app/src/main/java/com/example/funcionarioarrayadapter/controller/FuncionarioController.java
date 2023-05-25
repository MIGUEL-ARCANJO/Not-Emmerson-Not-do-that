package com.example.funcionarioarrayadapter.controller;

import com.example.funcionarioarrayadapter.CadastroFuncionario;
import com.example.funcionarioarrayadapter.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    private static FuncionarioController controller = null;
    private ArrayList<Funcionario> funcionarios;

    private FuncionarioController() {
        funcionarios = CadastroFuncionario.getArrayFuncionario();
    }

    public static FuncionarioController getController() {

        if (controller == null) {
            controller = new FuncionarioController();
        }
        return controller;
    }

    public void createFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listFuncionario() {
        return funcionarios;
    }

    public Funcionario updateFuncionario(Funcionario funcionario, int index) {
        Funcionario funcionarioVal = funcionarios.set(index, funcionario);
        return funcionarioVal;

    }

    public boolean deleteFuncionario(int index) {
        Funcionario funcionarioVal = funcionarios.get(index);

        if (funcionarios.remove(funcionarioVal)) {
            return true;
        }
        return false;
    }

    public Funcionario listFuncionarioByIndex(int index){
        return funcionarios.get(index);
    }
}
