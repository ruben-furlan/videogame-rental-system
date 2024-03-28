package com.videogamerentalsystem.infraestucture.adapter.out.persistence.inventory;


import com.videogamerentalsystem.common.PersistenceAdapter;
import com.videogamerentalsystem.domain.model.inventory.GameInventoryModel;
import com.videogamerentalsystem.domain.port.out.inventory.GameInventoryPort;
import com.videogamerentalsystem.infraestucture.adapter.out.entity.inventory.GameInventoryEntity;
import com.videogamerentalsystem.infraestucture.adapter.out.mapper.inventory.GameInventoryMapper;
import com.videogamerentalsystem.infraestucture.adapter.out.repository.SpringDataJpaGameInventory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class GameInventoryPersistenceAdapter implements GameInventoryPort {
    private final SpringDataJpaGameInventory springDataJpaGameInventory;
    private final GameInventoryMapper gameInventoryMapper;

    @Override
    public GameInventoryModel save(GameInventoryModel gameInventoryModel) {
        GameInventoryEntity gameInventoryEntity = this.gameInventoryMapper.toEntityGameInventory(gameInventoryModel);
        GameInventoryEntity save = this.springDataJpaGameInventory.save(gameInventoryEntity);
        return this.gameInventoryMapper.toModelGameInventory(save);
    }

    @Override
    public Optional<GameInventoryModel> findByID(Long id) {
        return  this.springDataJpaGameInventory.findById(id).map(this.gameInventoryMapper::toModelGameInventory);
    }
}
