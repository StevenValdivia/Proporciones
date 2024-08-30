package org.example.infrastructure;

import org.example.domain.Proporcion;
import org.example.usecase.ProporcionRepository;

public class ProporcionRepositoryImpl implements ProporcionRepository
{

    @Override
    public Proporcion save(Proporcion proporcion)
    {
        return proporcion;
    }
}
