package com.ltadcrm.ltadcrm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;
import com.ltadcrm.ltadcrm.repository.ItemsRepository;

import jakarta.persistence.Tuple;

@Service
public class ItemService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<ItemDetailDTO> getItemDetails() throws Exception{
        try{
        List<Tuple> tuples = itemsRepository.findAllItemsDTOs();
        List<ItemDetailDTO> dtos = new ArrayList<>();

        for (Tuple tuple : tuples) {
            ItemDetailDTO dto = new ItemDetailDTO(
                    tuple.get("id_usuario", Long.class),
                    tuple.get("nome_usuario", String.class),
                    tuple.get("tipo_usuario", String.class),
                    tuple.get("id_item", Long.class),
                    tuple.get("nf_invoice_item", String.class),
                    tuple.get("codigo_item", String.class),
                    tuple.get("observacao_item", String.class),
                    tuple.get("caminho_imagem_item", String.class),
                    tuple.get("pedido_origem", String.class),
                    tuple.get("sde_item", Long.class),
                    tuple.get("status_item", String.class),
                    tuple.get("valor_item", Double.class),
                    tuple.get("id_descricao", Long.class),
                    tuple.get("marca_descricao", String.class),
                    tuple.get("descricao_item", String.class),
                    tuple.get("localizacao_descricao", String.class),
                    tuple.get("modelo_descricao", String.class),
                    tuple.get("serie_descricao", String.class),
                    tuple.get("id_centro_custo", Long.class),
                    tuple.get("nome_centro_custo", String.class),
                    tuple.get("identificacao_centro_custo", String.class),
                    tuple.get("data_inicio_centro_custo", Date.class),
                    tuple.get("data_fim_centro_custo", Date.class),
                    tuple.get("id_contato", Long.class),
                    tuple.get("email_contato", String.class),
                    tuple.get("ocupacao_contato", String.class),
                    tuple.get("telefone_contato", String.class));
            dtos.add(dto);
        }

        return dtos;
    }catch(Exception e){
        throw new Exception("Current error in ItemService "+e);
    }
    }
}