package me.mbc.repository.customize;

import me.mbc.entity.customize.Admin;
import me.mbc.entity.customize.Department;
import me.mbc.entity.customize.Employee;
import me.mbc.entity.extend.Role;
import me.mbc.entity.extend.User;
import me.mbc.repository.UserJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJoinTable {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void testGetDepartment(){
        Optional<Department> byId = departmentRepository.findById(1L);
        System.out.println(byId.get().getName());
        System.out.println("------------");
        System.out.println(byId.get());

    }

    @Test
    public void testGetEmployee(){
        Optional<Employee> byId = employeeRepository.findById(1L);
        System.out.println(byId.get().getName());
        System.out.println("------------");
        System.out.println(byId.get());
    }

    @Test
    public void testOneToMany(){
        Optional<Role> byId = roleRepository.findById(1L);
        System.out.println(byId.get());
    }

    @Test
    public void testManyToOne(){
        Optional<User> byId = userJpaRepository.findById(1L);

        System.out.println(byId.get());
        Set<Role> roles = byId.get().getRoles();
        roles.forEach(System.out::println);
    }



}

