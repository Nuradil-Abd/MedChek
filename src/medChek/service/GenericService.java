package medChek.service;

import medChek.models.Department;
import medChek.models.Doctor;
import medChek.models.Patient;

public interface GenericService<T>{

    String add(Long  hospitalId, T t);

    void removeById(Long id);

    String updateById(Long id, T t);
}
