package org.genia.fishstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.genia.fishstore.EmployeeFilter;
import org.genia.fishstore.entities.Employee;
import org.genia.fishstore.entities.PaginatedResult;
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
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PaginatedResult<Employee> findByFilter(EmployeeFilter filter) {
		String sql = "select emp from Employee emp";
		String countSql = "select count(emp.id) from Employee emp";
		String sqlFilter;
		
		List<String> conditions = new ArrayList<>();
		
		if (filter != null) {
			if (filter.getRole() != null) {
				conditions.add("emp.role = :role");
			}
			if (filter.getLogin() !=  null) {
				conditions.add("emp.login like" + "'%" + filter.getLogin() + "%'");
			}
		}
		
		if (conditions.size() == 0) {
			sqlFilter = "";
		} else {
			sqlFilter = " where " + StringUtils.join(conditions, " and ");
		}
		
		long resultCount = em.createQuery(countSql + sqlFilter, long.class).getSingleResult();
		
		TypedQuery<Employee> query = em.createQuery(sql + sqlFilter, Employee.class);
		
		if (filter != null) {
			if (filter.getRole() != null) {
				query.setParameter("role", filter.getRole());
			}

			if (filter.getPaginator() != null) {
				filter.getPaginator().updateQueryPageInfo(query);
			}
		}
		
		return new PaginatedResult<>(resultCount, query.getResultList());
	}
}
