package com.integration.dao;

import com.integration.entity.Admin;

import java.util.List;

public interface AdminDAO {
	public void saveAdmin(Admin admin);
	public List<Admin> findAllAdmin();
	public void removeAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public Admin findAdminById(int id);
	public Admin loginAdmin(Admin admin);
}
