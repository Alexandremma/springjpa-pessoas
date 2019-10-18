package com.pessoas.springjpapessoas.converter;

import com.pessoas.springjpapessoas.entity.Cpf;
import javax.persistence.AttributeConverter;

public class CpfConverter implements AttributeConverter<Cpf, String> {

    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        if (cpf == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        if (cpf.getCpfSemMascara() != null && !cpf.getCpfSemMascara().isEmpty()) {
            sb.append(cpf.getCpfSemMascara());
        }

        return sb.toString();
    }

    @Override
    public Cpf convertToEntityAttribute(String dbCpf) {
        if (dbCpf == null || dbCpf.isEmpty()) {
            return null;
        }

        if (dbCpf == null || dbCpf.length() == 0 || dbCpf.isEmpty()) {
            return null;
        }

        Cpf cpf = new Cpf();
        cpf.setCpf(dbCpf);

        return cpf;
    }
}
