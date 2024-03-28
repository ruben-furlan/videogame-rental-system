package com.videogamerentalsystem.infraestucture.adapter.out.mapper.inventory;

import com.videogamerentalsystem.domain.model.inventory.GameInventoryModel;
import com.videogamerentalsystem.domain.model.inventory.GameInventoryPriceModel;
import com.videogamerentalsystem.infraestucture.adapter.out.entity.inventory.GameInventoryEntity;
import com.videogamerentalsystem.infraestucture.adapter.out.entity.inventory.GameInventoryPriceEntity;

import org.springframework.stereotype.Component;


@Component
public class GameInventoryMapper {


    public GameInventoryEntity toEntityGameInventory(GameInventoryModel gameInventoryModel) {
        return GameInventoryEntity.builder()
                .title(gameInventoryModel.getTitle())
                .type(gameInventoryModel.getType())
                .stock(gameInventoryModel.getStock())
                .inventoryPriceEntity(this.toEntityGameInventoryPrice(gameInventoryModel.getInventoryPriceModel()))
                .build();
    }

    private GameInventoryPriceEntity toEntityGameInventoryPrice(GameInventoryPriceModel gameInventoryPriceModel) {
        return GameInventoryPriceEntity.builder()
                .type(gameInventoryPriceModel.getType())
                .amount(gameInventoryPriceModel.getAmount())
                .currency(gameInventoryPriceModel.getCurrency())
                .build();
    }

    public GameInventoryModel toModelGameInventory(GameInventoryEntity gameInventoryEntity) {
        return GameInventoryModel.builder()
                .title(gameInventoryEntity.getTitle())
                .type(gameInventoryEntity.getType())
                .stock(gameInventoryEntity.getStock())
                .inventoryPriceModel(this.toModelGameInventoryPrice(gameInventoryEntity.getInventoryPriceEntity()))
                .build();
    }

    private GameInventoryPriceModel toModelGameInventoryPrice(GameInventoryPriceEntity gameInventoryPriceEntity) {
        return GameInventoryPriceModel.builder()
                .type(gameInventoryPriceEntity.getType())
                .amount(gameInventoryPriceEntity.getAmount())
                .currency(gameInventoryPriceEntity.getCurrency())
                .build();
    }


}
