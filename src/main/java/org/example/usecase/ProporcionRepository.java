package org.example.usecase;

import org.example.domain.Proporcion;
import java.util.List;

public interface ProporcionRepository
{
    Proporcion save(Proporcion proporcion);
    List<Proporcion> getAll();
}