package org.genia.fishstore;

import javax.persistence.TypedQuery;

import org.genia.fishstore.entities.Role;

public class EmployeeFilter {
	private PageInfo paginator;
	
	private Role role;
	private String login;
	
	public EmployeeFilter() {
	}
	
	public PageInfo getPaginator() {
		return paginator;
	}
	public void setPaginator(PageInfo paginator) {
		this.paginator = paginator;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public <T> void updateQueryPageInfo(TypedQuery<T> query) {
		if (paginator != null)
		query.setFirstResult(paginator.getOffset()).setMaxResults(paginator.getItemsPerPage());
	}
}
