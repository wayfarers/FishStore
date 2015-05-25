package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.GenericResult;
import org.genia.fishstore.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDao{

	public EmployeeDaoImpl() {
		super(Employee.class);
	}
	
	@Override
	public Employee findByLogin(String login) {
		TypedQuery<Employee> query = em.createQuery("select emp from Employee emp where emp.login = :login", Employee.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public GenericResult<Employee> findByFilter(EmployeeFilter filter) {
		String sql = "select emp from Employee emp";
		String countSql = "select count(*) from Employee";
		String sqlFilter;
		
		List<String> conditions = new ArrayList<>();
		
		if (filter.getRole() != null) {
			conditions.add("emp.role = " + filter.getRole().getValue());
		}
		if (filter.getLogin() !=  null) {
			conditions.add("emp.login like" + "'%" + filter.getLogin() + "%'");
		}
		
		sqlFilter = " where " + StringUtils.join(conditions);
		int resultCount = em.createQuery(countSql + sqlFilter, int.class).getSingleResult();
		
		TypedQuery<Employee> query = em.createQuery(sql + sqlFilter, Employee.class);
		
		if (filter.getPaginator() != null) {
			filter.updateQueryPageInfo(query);
		}
		
		return new GenericResult<>(resultCount, query.getResultList());
	}
}
