package org.example.infrastructure.database;

import org.example.domain.Proporcion;
import org.example.usecase.ProporcionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProporcionRepositoryImpl implements ProporcionRepository
{
    @Override
    public Proporcion save(Proporcion proporcion)
    {
        return proporcion;
    }
}
