package me.mbc.repository.customize;

import me.mbc.entity.customize.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
